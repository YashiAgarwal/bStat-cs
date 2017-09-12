package bStat.CS.com.resources;



import bStat.CS.com.FeedObjects.*;
import bStat.CS.com.Response.SuccessResponse;
import bStat.CS.com.Validators.AddRequestValidators;
import bStat.CS.com.common.dao.*;
import bStat.CS.com.common.exceptions.ApiException;
import bStat.CS.com.common.models.tables.*;
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
    ProductVerticalsDao productVerticalsDao;

    @Inject
    CategoryNodesDao categoryNodesDao;

    @Inject
    ProductsHierarchyDao productsHierarchyDao;

    @Inject
    private AddRequestValidators addRequestValidators;

    @POST
    @Path("/new/product")
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
    @Path("/new/service_items")
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
    @Path("/del/service_item")
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
    @Path("/service_items")
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
    @Path("/new/product_attribute")
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
    @Path("/del/product_attribute")
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
    @Path("/product_attributes")
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
    @POST
    @Path("/new/product_vertical")
    @UnitOfWork
    @Timed
    @ExceptionMetered
    @ApiOperation(value = "addProductVertical", response = Response.class)
    public Response addProductVertical(@Valid ProductVerticalDTO productVerticalDTO) {
        try {
            dataController.addNewProductVertical(productVerticalDTO);
            logger.info("New ProductVertical added successfully: " + productVerticalDTO.getVerticalName());
            return Response.ok(new SuccessResponse(HttpStatus.OK_200, "New product vertical  added successfully")).build();
        } catch (Exception e) {
            logger.error("Add New product vertical Exception", e.getMessage(), e);
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity("Add New ProductVertical Exception" + e.getMessage()).build();
        }
    }

    //Delete a product vertical
    @GET
    @Path("/del/product_vertical")
    @UnitOfWork
    @Timed
    @ExceptionMetered
    @ApiOperation(value = "deleteProductVertical")
    public void deleteProductVertical(@QueryParam("verticalId") long verticalId) throws ApiException {
        try {
            productVerticalsDao.deleteProductVerticalRowWithTxn(verticalId);
        }
        catch (Exception e) {
            logger.error("Delete ProductVertical Exception", e.getMessage(), e);
            throw new ApiException(Response.Status.INTERNAL_SERVER_ERROR, "Delete ProductVertical Exception");
        }
    }

    //Get all product verticals
    @GET
    @Path("/product_verticals")
    @UnitOfWork
    @Timed
    @ExceptionMetered
    @ApiOperation(value = "getAllProductVerticals", response = Response.class)
    public List<ProductVerticals> getAllProductVerticvals() throws ApiException {
        try {
            return productVerticalsDao.getAllProductVerticals();
        } catch (Exception e) {
            logger.error("GetAllProductVerticals Exception", e.getMessage(), e);
            throw new ApiException(Response.Status.INTERNAL_SERVER_ERROR, "GetAllProductVerticals Exception");
        }
    }

    //Add category node
    @POST
    @Path("/new/category_node")
    @UnitOfWork
    @Timed
    @ExceptionMetered
    @ApiOperation(value = "addCategoryNode", response = Response.class)
    public Response addCategoryNode(@Valid CategoryNodeDTO categoryNodeDTO) {
        try {
            dataController.addNewCategoryNode(categoryNodeDTO);
            logger.info("New CategoryNode added successfully: " + categoryNodeDTO.getProductId());
            return Response.ok(new SuccessResponse(HttpStatus.OK_200, "New category node  added successfully")).build();
        } catch (Exception e) {
            logger.error("Add New category node Exception", e.getMessage(), e);
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity("Add New category node Exception" + e.getMessage()).build();
        }
    }

    //Delete a category node
    @GET
    @Path("/del/category_node")
    @UnitOfWork
    @Timed
    @ExceptionMetered
    @ApiOperation(value = "deleteCategoryNode")
    public void deleteCategoryNode(@QueryParam("nodeId") long nodeId) throws ApiException {
        try {
            categoryNodesDao.deleteCategoryNodeRowWithTxn(nodeId);
        }
        catch (Exception e) {
            logger.error("Delete CategoryNode Exception", e.getMessage(), e);
            throw new ApiException(Response.Status.INTERNAL_SERVER_ERROR, "Delete CategoryNode Exception");
        }
    }

    //Get all category nodes
    @GET
    @Path("/category_nodes")
    @UnitOfWork
    @Timed
    @ExceptionMetered
    @ApiOperation(value = "getAllCategoryNodes", response = Response.class)
    public List<CategoryNodes> getAllCategoryNodes() throws ApiException {
        try {
            return categoryNodesDao.getAllCategoryNodes();
        } catch (Exception e) {
            logger.error("GetAllCategoryNodes Exception", e.getMessage(), e);
            throw new ApiException(Response.Status.INTERNAL_SERVER_ERROR, "GetAllCategoryNodes Exception");
        }
    }

    //Add product hierarchy
    @POST
    @Path("/new/product_hierarchy")
    @UnitOfWork
    @Timed
    @ExceptionMetered
    @ApiOperation(value = "addProductHierarchy", response = Response.class)
    public Response addProductHierarchy(@Valid ProductHierarchyDTO productHierarchyDTO) {
        try {
            dataController.addNewProductHierarchy(productHierarchyDTO);
            logger.info("New ProductHierarchy added successfully: Parent node id- " + productHierarchyDTO.getParentNodeId()
                    +", child node id- " + productHierarchyDTO.getChildNodeId());
            return Response.ok(new SuccessResponse(HttpStatus.OK_200, "New product hierarchy  added successfully")).build();
        } catch (Exception e) {
            logger.error("Add New product hierarchy Exception", e.getMessage(), e);
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity("Add New product hierarchy Exception" + e.getMessage()).build();
        }
    }

    //Delete a product hierarchy
    @GET
    @Path("/del/product_hierarchy")
    @UnitOfWork
    @Timed
    @ExceptionMetered
    @ApiOperation(value = "deleteProductHierarchy")
    public void deleteProductHierarchy(@QueryParam("id") long id) throws ApiException {
        try {
            productsHierarchyDao.deleteProductHierarchyRowWithTxn(id);
        }
        catch (Exception e) {
            logger.error("Delete ProductHierarchy Exception", e.getMessage(), e);
            throw new ApiException(Response.Status.INTERNAL_SERVER_ERROR, "Delete ProductHierarchy Exception");
        }
    }

    //Get all product hierarchies
    @GET
    @Path("/product_hierarchy")
    @UnitOfWork
    @Timed
    @ExceptionMetered
    @ApiOperation(value = "getAllProductsHierarchy", response = Response.class)
    public List<ProductsHierarchy> getAllProductsHierarchy() throws ApiException {
        try {
            return productsHierarchyDao.getAllProductHierarchy();
        } catch (Exception e) {
            logger.error("GetAllProductsHierarchy Exception", e.getMessage(), e);
            throw new ApiException(Response.Status.INTERNAL_SERVER_ERROR, "GetAllProductsHierarchy Exception");
        }
    }
}

