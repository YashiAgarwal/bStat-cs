package bStat.CS.com.common.dao;

import bStat.CS.com.common.exceptions.ApiException;
import bStat.CS.com.common.exceptions.ResponseErrorMsg;
import bStat.CS.com.common.models.tables.Products;
import bStat.CS.com.common.utils.HSession;
import com.google.inject.Inject;
import io.dropwizard.hibernate.AbstractDAO;
import io.dropwizard.hibernate.HibernateBundle;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.ws.rs.core.Response;
import java.util.List;

/**
 * Created by Yashi Agarwal on 19-05-2017.
 */
public class ProductsDao extends AbstractDAO<Products> {

    private static final Logger logger = LoggerFactory.getLogger(ProductsDao.class);

    @Inject
    public ProductsDao(HibernateBundle bundle) {
        super(bundle.getSessionFactory());
    }

    public Products saveInDB(Products Products) {
        return persist(Products);
    }

    public void deleteProductRowWithTxn(long productId) {
        HSession hSession = new HSession();
        hSession.openWithTransaction();
        try {
            Products products = get(productId);
            if(products!=null){
                currentSession().delete(products);
            }else{
                throw new ApiException(Response.Status.BAD_REQUEST, ResponseErrorMsg.NOT_AVAILABLE,
                        "No such productId found in DB: "+productId);
            }
            hSession.commit();
        } catch (Exception e) {
            logger.error("Error while fetching deleteProductRowWithTxn in Products table " + e.getMessage(), e);
        } finally {
            hSession.close();
        }
    }

    public List<Products> getAllProducts(){
        Criteria cr = currentSession().createCriteria(Products.class);
        return cr.list();
    }

    public void updateInDB(Products products){
        currentSession().update(products);
    }

    public void markProductInactive(String productId) throws ApiException {
        Criteria cr = currentSession().createCriteria(Products.class);
        cr.add(Restrictions.eq("productId", productId));
        List<Products> productList = cr.list();
        if(productList != null && productList.size() > 0) {
            Products product = productList.get(0);
            product.setListing(false);
            currentSession().update(product);
        }else {
            throw new ApiException(Response.Status.BAD_REQUEST, ResponseErrorMsg.NOT_AVAILABLE, "product Id not found in db.");
        }
    }
}
