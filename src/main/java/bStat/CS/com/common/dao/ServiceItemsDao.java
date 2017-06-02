package bStat.CS.com.common.dao;

import bStat.CS.com.common.exceptions.ApiException;
import bStat.CS.com.common.exceptions.ResponseErrorMsg;
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
 * Created by Yashi Agarwal on 25-05-2017.
 */
public class ServiceItemsDao extends AbstractDAO<ServiceItems> {

    private static final Logger logger = LoggerFactory.getLogger(ServiceItemsDao.class);

    @Inject
    public ServiceItemsDao(HibernateBundle bundle) {
        super(bundle.getSessionFactory());
    }

    public ServiceItems saveInDB(ServiceItems ServiceItems) {
        return persist(ServiceItems);
    }

    public void deleteServiceItemRowWithTxn(long id) {
        HSession hSession = new HSession();
        hSession.openWithTransaction();
        try {
            ServiceItems serviceItems = get(id);
            if(serviceItems!=null){
                currentSession().delete(serviceItems);
            }else{
                throw new ApiException(Response.Status.BAD_REQUEST, ResponseErrorMsg.NOT_AVAILABLE,
                        "No such  id found in DB: "+id);
            }
            hSession.commit();
        } catch (Exception e) {
            logger.error("Error while fetching deleteServiceItemRowWithTxn in ServiceItems table " + e.getMessage(), e);
        } finally {
            hSession.close();
        }
    }

    public List<ServiceItems> getAllServiceItems(){
        Criteria cr = currentSession().createCriteria(Products.class);
        return cr.list();
    }

}

