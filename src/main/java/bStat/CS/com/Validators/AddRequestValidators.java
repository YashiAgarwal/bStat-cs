package bStat.CS.com.Validators;

import bStat.CS.com.FeedObjects.ProductDTO;
import bStat.CS.com.common.dao.ProductsDao;
import bStat.CS.com.common.exceptions.ApiException;
import bStat.CS.com.common.exceptions.ResponseErrorMsg;
import bStat.CS.com.common.models.tables.Products;
import com.google.inject.Inject;

import javax.ws.rs.core.Response;

/**
 * Created by Yashi Agarwal on 31-05-2017.
 */
public class AddRequestValidators {

    @Inject
    ProductsDao productsDao;

    @Inject
    public AddRequestValidators(ProductsDao productsDao) {
        this.productsDao = productsDao;
    }

}

