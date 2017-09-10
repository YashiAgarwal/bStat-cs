package bStat.CS.com.common.dao;

import bStat.CS.com.common.exceptions.ApiException;
import bStat.CS.com.common.exceptions.ResponseErrorMsg;
import bStat.CS.com.common.models.tables.CategoryNodes;
import bStat.CS.com.common.models.tables.Products;
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
 * Created by Yashi Agarwal on 19-05-2017.
 */
public class ProductsHierarchyDao extends AbstractDAO<ProductsHierarchy> {

    private static final Logger logger = LoggerFactory.getLogger(ProductsHierarchyDao.class);

    @Inject
    public ProductsHierarchyDao(HibernateBundle bundle) {
        super(bundle.getSessionFactory());
    }

    public ProductsHierarchy saveInDB(ProductsHierarchy ProductsHierarchy) {
        return persist(ProductsHierarchy);
    }

    public void deleteProductHierarchyRowWithTxn(long id) {
        HSession hSession = new HSession();
        hSession.openWithTransaction();
        try {
            ProductsHierarchy productsHierarchy = get(id);
            if(productsHierarchy!=null){
                currentSession().delete(productsHierarchy);
            }else{
                throw new ApiException(Response.Status.BAD_REQUEST, ResponseErrorMsg.NOT_AVAILABLE,
                        "No such  id found in DB: "+id);
            }
            hSession.commit();
        } catch (Exception e) {
            logger.error("Error while fetching deleteProductHierarchyRowWithTxn in ProductsHierarchy table " + e.getMessage(), e);
        } finally {
            hSession.close();
        }
    }

    public List<ProductsHierarchy> getAllProductHierarchy(){
        Criteria cr = currentSession().createCriteria(ProductsHierarchy.class);
        return cr.list();
    }
}

