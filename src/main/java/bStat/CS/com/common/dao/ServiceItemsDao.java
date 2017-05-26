package bStat.CS.com.common.dao;

import bStat.CS.com.common.models.tables.Products;
import bStat.CS.com.common.models.tables.ServiceItems;
import com.google.inject.Inject;
import io.dropwizard.hibernate.AbstractDAO;
import io.dropwizard.hibernate.HibernateBundle;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

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
}

