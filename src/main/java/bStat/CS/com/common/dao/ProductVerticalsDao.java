package bStat.CS.com.common.dao;

import bStat.CS.com.common.exceptions.ApiException;
import bStat.CS.com.common.exceptions.ResponseErrorMsg;
import bStat.CS.com.common.models.tables.ProductAttributes;
import bStat.CS.com.common.models.tables.ProductVerticals;
import bStat.CS.com.common.models.tables.ProductsHierarchy;
import bStat.CS.com.common.utils.HSession;
import com.google.inject.Inject;
import io.dropwizard.hibernate.AbstractDAO;
import io.dropwizard.hibernate.HibernateBundle;
import org.hibernate.Criteria;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.ws.rs.core.Response;
import java.util.List;

/**
 * Created by Yashi Agarwal on 05-06-2017.
 */
public class ProductVerticalsDao extends AbstractDAO<ProductVerticals> {

    private static final Logger logger = LoggerFactory.getLogger(ProductVerticalsDao.class);

    @Inject
    public ProductVerticalsDao(HibernateBundle bundle) {
        super(bundle.getSessionFactory());
    }

    public ProductVerticals saveInDB(ProductVerticals ProductVerticals) {
        return persist(ProductVerticals);
    }

    public void deleteProductVerticalRowWithTxn(long verticalId) {
        HSession hSession = new HSession();
        hSession.openWithTransaction();
        try {
            ProductVerticals productVerticals = get(verticalId);
            if(productVerticals!=null){
                currentSession().delete(productVerticals);
            }else{
                throw new ApiException(Response.Status.BAD_REQUEST, ResponseErrorMsg.NOT_AVAILABLE,
                        "No such vertical id found in DB: "+verticalId);
            }
            hSession.commit();
        } catch (Exception e) {
            logger.error("Error while fetching deleteProductVerticalRowWithTxn in ProductVerticals table " + e.getMessage(), e);
        } finally {
            hSession.close();
        }
    }

    public List<ProductVerticals> getAllProductVerticals(){
        Criteria cr = currentSession().createCriteria(ProductVerticals.class);
        return cr.list();
    }

}
