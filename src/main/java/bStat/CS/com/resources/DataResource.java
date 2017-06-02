package bStat.CS.com.resources;



import bStat.CS.com.FeedObjects.ProductDTO;
import bStat.CS.com.Response.SuccessResponse;
import bStat.CS.com.Validators.AddRequestValidators;
import bStat.CS.com.common.dao.ProductsDao;
import bStat.CS.com.common.exceptions.ApiException;
import bStat.CS.com.common.models.tables.Products;
import bStat.CS.com.controllers.DataController;
import com.codahale.metrics.annotation.ExceptionMetered;
import com.codahale.metrics.annotation.Timed;
import com.google.gson.Gson;
import com.google.inject.Inject;
import com.wordnik.swagger.annotations.Api;
import com.wordnik.swagger.annotations.ApiOperation;
import io.dropwizard.hibernate.UnitOfWork;
import org.eclipse.jetty.http.HttpStatus;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.validation.Valid;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

/**
 * Created by prashant170392 on 01/05/2017
 */

@Path("/data")
@Api("Data Resource")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class DataResource {

    private static final Logger logger = LoggerFactory.getLogger(DataResource.class);

    @Inject
    DataController dataController;

    @Inject
    ProductsDao productsDao;

    @Inject
    private AddRequestValidators addRequestValidators;

    @POST
    @Path("/new/product")
    @Produces(MediaType.APPLICATION_JSON)
    @UnitOfWork
    @Timed
    @ExceptionMetered
    @ApiOperation(value = "addProduct", response = Response.class)
    public Response addProduct(@Valid ProductDTO productDTO) {
        try {
            dataController.addNewProduct(productDTO);
            logger.info("New Product added successfully: " + productDTO.getTitle());
            return Response.ok(new SuccessResponse(HttpStatus.OK_200, "New product added successfully")).build();
        } catch (Exception e) {
            logger.error("Add New Product Exception", e.getMessage(), e);
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity("Add New Product Exception" + e.getMessage()).build();
        }
    }


    @GET
    @Path("/del/product")
    @Produces(MediaType.APPLICATION_JSON)
    @UnitOfWork
    @Timed
    @ExceptionMetered
    @ApiOperation(value = "deleteProduct")
    public void deleteProduct(@QueryParam("productId") long productId) throws ApiException {
        try {
            productsDao.markProductInactive(productId);
        } catch (ApiException ae) {
            logger.error("Delete Product Exception", ae.getMessage(), ae);
            throw ae;
        }
        catch (Exception e) {
            logger.error("Delete Product Exception", e.getMessage(), e);
            throw new ApiException(Response.Status.INTERNAL_SERVER_ERROR, "Delete Product Exception");
        }
    }


    @GET
    @Path("/products")
    @Produces(MediaType.APPLICATION_JSON)
    @UnitOfWork
    @Timed
    @ExceptionMetered
    @ApiOperation(value = "getAllProducts", response = Response.class)
    public List<Products> getAllProducts() throws ApiException {
        try {
            return productsDao.getAllProducts();
        } catch (Exception e) {
            logger.error("GetAllStores Exception", e.getMessage(), e);
            throw new ApiException(Response.Status.INTERNAL_SERVER_ERROR, "GetAllProducts Exception");
        }
    }

    //Add service items
    //Delete a service item
    //Get all service items

    //Add product attribute
    //Delete a product attribute
    //Get all product attributes

    //Add product vertical
    //Delete a product vertical
    //Get all product verticals

    //Add category node
    //Delete a category node
    //Get all category nodes

    //Add product hierarchy
    //Delete a product hierarchy
    //Get all product hierarchies
}

