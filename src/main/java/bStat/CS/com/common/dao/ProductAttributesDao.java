package bStat.CS.com.common.dao;

import bStat.CS.com.common.exceptions.ApiException;
import bStat.CS.com.common.exceptions.ResponseErrorMsg;
import bStat.CS.com.common.models.tables.ProductAttributes;
import bStat.CS.com.common.models.tables.Products;
import bStat.CS.com.common.models.tables.ServiceItems;
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
 * Created by Yashi Agarwal on 30-05-2017.
 */
public class ProductAttributesDao extends AbstractDAO<ProductAttributes> {

    private static final Logger logger = LoggerFactory.getLogger(ProductAttributesDao.class);

    @Inject
    public ProductAttributesDao(HibernateBundle bundle) {
        super(bundle.getSessionFactory());
    }

    public ProductAttributes saveInDB(ProductAttributes ProductAttributes) {
        return persist(ProductAttributes);
    }

    public void deleteProductAttributeRowWithTxn(long id) {
        HSession hSession = new HSession();
        hSession.openWithTransaction();
        try {
            ProductAttributes productAttributes = get(id);
            if(productAttributes!=null){
                currentSession().delete(productAttributes);
            }else{
                throw new ApiException(Response.Status.BAD_REQUEST, ResponseErrorMsg.NOT_AVAILABLE,
                        "No such  id found in DB: "+id);
            }
            hSession.commit();
        } catch (Exception e) {
            logger.error("Error while fetching deleteProductAttributeRowWithTxn in ProductAttributes table " + e.getMessage(), e);
        } finally {
            hSession.close();
        }
    }

    public List<ProductAttributes> getAllProductAttributes(){
        Criteria cr = currentSession().createCriteria(ProductAttributes.class);
        return cr.list();
    }

}

