package bStat.CS.com.common.dao;

import bStat.CS.com.common.exceptions.ApiException;
import bStat.CS.com.common.exceptions.ResponseErrorMsg;
import bStat.CS.com.common.models.tables.CategoryNodes;
import bStat.CS.com.common.models.tables.ProductVerticals;
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
public class CategoryNodesDao extends AbstractDAO<CategoryNodes> {

    private static final Logger logger = LoggerFactory.getLogger(CategoryNodesDao.class);

    @Inject
    public CategoryNodesDao(HibernateBundle bundle) {
        super(bundle.getSessionFactory());
    }

    public CategoryNodes saveInDB(CategoryNodes CategoryNodes) {
        return persist(CategoryNodes);
    }

    public void deleteCategoryNodeRowWithTxn(long nodeId) {
        HSession hSession = new HSession();
        hSession.openWithTransaction();
        try {
            CategoryNodes categoryNodes = get(nodeId);
            if(categoryNodes!=null){
                currentSession().delete(categoryNodes);
            }else{
                throw new ApiException(Response.Status.BAD_REQUEST, ResponseErrorMsg.NOT_AVAILABLE,
                        "No such node id found in DB: "+nodeId);
            }
            hSession.commit();
        } catch (Exception e) {
            logger.error("Error while fetching deleteCategoryNodeRowWithTxn in CategoryNodes table " + e.getMessage(), e);
        } finally {
            hSession.close();
        }
    }

    public List<CategoryNodes> getAllCategoryNodes(){
        Criteria cr = currentSession().createCriteria(CategoryNodes.class);
        return cr.list();
    }
}
