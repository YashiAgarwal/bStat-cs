package bStat.CS.com.resources;

import bStat.CS.com.FeedObjects.ProductAttributeDTO;
import bStat.CS.com.FeedObjects.ProductDTO;
import bStat.CS.com.FeedObjects.ServiceItemsDTO;
import bStat.CS.com.Response.SuccessResponse;
import bStat.CS.com.Validators.AddRequestValidators;
import bStat.CS.com.common.dao.ProductAttributesDao;
import bStat.CS.com.common.dao.ProductsDao;
import bStat.CS.com.common.dao.ServiceItemsDao;
import bStat.CS.com.common.exceptions.ApiException;
import bStat.CS.com.common.models.tables.ProductAttributes;
import bStat.CS.com.common.models.tables.Products;
import bStat.CS.com.common.models.tables.ServiceItems;
import bStat.CS.com.controllers.DataController;
import com.codahale.metrics.annotation.ExceptionMetered;
import com.codahale.metrics.annotation.Timed;
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
    ServiceItemsDao serviceItemsDao;

    @Inject
    ProductAttributesDao productAttributesDao;

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
    @POST
    @Path("/new/serviceItems")
    @Produces(MediaType.APPLICATION_JSON)
    @UnitOfWork
    @Timed
    @ExceptionMetered
    @ApiOperation(value = "addServiceItems", response = Response.class)
    public Response addServiceItems(@Valid ServiceItemsDTO serviceItemsDTO) {
        try {
            dataController.addNewServiceItems(serviceItemsDTO);
            logger.info("New ServiceItems added successfully: " + serviceItemsDTO.getTitle());
            return Response.ok(new SuccessResponse(HttpStatus.OK_200, "New service items  added successfully")).build();
        } catch (Exception e) {
            logger.error("Add New serviceItems Exception", e.getMessage(), e);
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity("Add New ServiceItems Exception" + e.getMessage()).build();
        }
    }

    //Delete a service item
    @GET
    @Path("/del/service item")
    @Produces(MediaType.APPLICATION_JSON)
    @UnitOfWork
    @Timed
    @ExceptionMetered
    @ApiOperation(value = "deleteServiceItem")
    public void deleteServiceItem(@QueryParam("id") long id) throws ApiException {
        try {
            serviceItemsDao.deleteServiceItemRowWithTxn(id);
        }
        catch (Exception e) {
            logger.error("Delete ServiceItem Exception", e.getMessage(), e);
            throw new ApiException(Response.Status.INTERNAL_SERVER_ERROR, "Delete ServiceItem Exception");
        }
    }

    //Get all service items
    @GET
    @Path("/service items")
    @Produces(MediaType.APPLICATION_JSON)
    @UnitOfWork
    @Timed
    @ExceptionMetered
    @ApiOperation(value = "getAllServiceItems", response = Response.class)
    public List<ServiceItems> getAllServiceItems() throws ApiException {
        try {
            return serviceItemsDao.getAllServiceItems();
        } catch (Exception e) {
            logger.error("GetAllServiceItems Exception", e.getMessage(), e);
            throw new ApiException(Response.Status.INTERNAL_SERVER_ERROR, "GetAllServiceItems Exception");
        }
    }

    //Add product attribute
    @POST
    @Path("/new/product attribute")
    @Produces(MediaType.APPLICATION_JSON)
    @UnitOfWork
    @Timed
    @ExceptionMetered
    @ApiOperation(value = "addProductAttribute", response = Response.class)
    public Response addProductAttribute(@Valid ProductAttributeDTO productAttributeDTO) {
        try {
            dataController.addNewProductAttribute(productAttributeDTO);
            logger.info("New ProductAttribute added successfully: " + productAttributeDTO.getAttributeValue());
            return Response.ok(new SuccessResponse(HttpStatus.OK_200, "New product attribute  added successfully")).build();
        } catch (Exception e) {
            logger.error("Add New product attribute Exception", e.getMessage(), e);
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity("Add New ProductAttribute Exception" + e.getMessage()).build();
        }
    }

    //Delete a product attribute
    @GET
    @Path("/del/product attribute")
    @Produces(MediaType.APPLICATION_JSON)
    @UnitOfWork
    @Timed
    @ExceptionMetered
    @ApiOperation(value = "deleteProductAttribute")
    public void deleteProductAttribute(@QueryParam("id") long id) throws ApiException {
        try {
            productAttributesDao.deleteProductAttributeRowWithTxn(id);
        }
        catch (Exception e) {
            logger.error("Delete ProductAttribute Exception", e.getMessage(), e);
            throw new ApiException(Response.Status.INTERNAL_SERVER_ERROR, "Delete ProductAttribute Exception");
        }
    }

    //Get all product attributes
    @GET
    @Path("/product attributes")
    @Produces(MediaType.APPLICATION_JSON)
    @UnitOfWork
    @Timed
    @ExceptionMetered
    @ApiOperation(value = "getAllProductAttributes", response = Response.class)
    public List<ProductAttributes> getAllProductAttributes() throws ApiException {
        try {
            return productAttributesDao.getAllProductAttributes();
        } catch (Exception e) {
            logger.error("GetAllProductAttributes Exception", e.getMessage(), e);
            throw new ApiException(Response.Status.INTERNAL_SERVER_ERROR, "GetAllProductAttributes Exception");
        }
    }

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

