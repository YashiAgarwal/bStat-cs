package bStat.CS.com.resources;

import com.wordnik.swagger.annotations.Api;

import javax.ws.rs.Consumes;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 * Created by Yashi Agarwal on 02-06-2017.
 */

@Path("/product")
@Api("Product Resource")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class ProductResource {

    //Get product info - get product, its all attributes, its associated service items

    //update product details

    //update service item of a product

    //update value of any attribute in "Product Attributes" table for some product id

}
