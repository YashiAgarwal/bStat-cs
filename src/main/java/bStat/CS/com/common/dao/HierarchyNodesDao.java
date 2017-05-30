package bStat.CS.com.common.dao;

import bStat.CS.com.common.models.tables.CategoryNodes;
import com.google.inject.Inject;
import io.dropwizard.hibernate.AbstractDAO;
import io.dropwizard.hibernate.HibernateBundle;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by Yashi Agarwal on 19-05-2017.
 */
public class HierarchyNodesDao extends AbstractDAO<CategoryNodes> {

    private static final Logger logger = LoggerFactory.getLogger(HierarchyNodesDao.class);

    @Inject
    public HierarchyNodesDao(HibernateBundle bundle) {
        super(bundle.getSessionFactory());
    }

    public CategoryNodes saveInDB(CategoryNodes HierarchyNodes) {
        return persist(HierarchyNodes);
    }
}
