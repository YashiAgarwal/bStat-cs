package bStat.CS.com.common.dao;

import bStat.CS.com.common.models.tables.HierarchyNodes;
import com.google.inject.Inject;
import io.dropwizard.hibernate.AbstractDAO;
import io.dropwizard.hibernate.HibernateBundle;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by Yashi Agarwal on 19-05-2017.
 */
public class HierarchyNodesDao extends AbstractDAO<HierarchyNodes> {

    private static final Logger logger = LoggerFactory.getLogger(HierarchyNodesDao.class);

    @Inject
    public HierarchyNodesDao(HibernateBundle bundle) {
        super(bundle.getSessionFactory());
    }

    public HierarchyNodes saveInDB(HierarchyNodes HierarchyNodes) {
        return persist(HierarchyNodes);
    }
}
