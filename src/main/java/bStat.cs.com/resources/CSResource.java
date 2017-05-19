package bStat.cs.com.resources;

import bStat.ims.com.FeedObjects.AddressDTO;
import bStat.ims.com.FeedObjects.StoreDTO;
import bStat.ims.com.Response.SuccessResponse;
import bStat.ims.com.common.dao.StoresDao;
import bStat.ims.com.common.exceptions.ApiException;
import bStat.ims.com.common.models.tables.Store;
import bStat.ims.com.controllers.*;
import com.codahale.metrics.annotation.ExceptionMetered;
import com.codahale.metrics.annotation.Timed;
import com.google.inject.Inject;
import io.dropwizard.hibernate.UnitOfWork;
import org.eclipse.jetty.http.HttpStatus;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.validation.Valid;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

/**
 * Created by prashant170392 on 01/05/2017
 */

@Path("/ims")
@Produces(MediaType.APPLICATION_JSON)
public class CSResource {

    @Inject
    private StoresController storesController;
    @Inject
    private StoresDao storesDao;

    private static final Logger logger = LoggerFactory.getLogger(CSResource.class);

    //Add a new store entry
    @POST
    @Path("/new/store")
    @Produces(MediaType.APPLICATION_JSON)
    @UnitOfWork
    @Timed
    @ExceptionMetered
    public Response addStore(@Valid StoreDTO storeDTO){
        try {
            storesController.addNewStore(storeDTO);
            logger.info("New Store added successfully: " + storeDTO.getStoreName());
            return Response.ok(new SuccessResponse(HttpStatus.OK_200, "New Store added successfully")).build();
        } catch (Exception e) {
            logger.error("Add New Store Exception", e.getMessage(), e);
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity("Add New Store Exception" + e.getMessage()).build();
        }
    }

    //Add a new address entry
    @POST
    @Path("/new/address")
    @Produces(MediaType.APPLICATION_JSON)
    @UnitOfWork
    @Timed
    @ExceptionMetered
    public Response addAddress(@Valid AddressDTO addressDTO) throws ApiException {
        try {
            storesController.addNewAddress(addressDTO);
            logger.info("New Address added successfully: " + addressDTO.getAddressLine1());
            return Response.ok(new SuccessResponse(HttpStatus.OK_200, "Address added successfully")).build();
        } catch (Exception e) {
            logger.error("Add New Store Exception", e.getMessage(), e);
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity("Add New Store Exception" + e.getMessage()).build();
        }
    }

    //Get all stores
    @GET
    @Path("/stores")
    @Produces(MediaType.APPLICATION_JSON)
    @UnitOfWork
    @Timed
    @ExceptionMetered
    public List<Store> getAllStores() throws ApiException {
        try {
            return storesDao.getAllStores();
        } catch (Exception e) {
            logger.error("Add New Store Exception", e.getMessage(), e);
            throw new ApiException(Response.Status.INTERNAL_SERVER_ERROR, "Add New Store Exception");
        }
    }



    //Add a new Raw Material Entry
    //Get all raw materials
    //Get stocks in store X
    //Get stock in All stores

    //Get Product Inventory of Product X
    //Get Raw Material Inventory of Raw Material X
}