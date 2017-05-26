package bStat.CS.com.common.dao;

import bStat.CS.com.common.models.tables.Products;
import bStat.CS.com.common.models.tables.ProductsHierarchy;
import com.google.inject.Inject;
import io.dropwizard.hibernate.AbstractDAO;
import io.dropwizard.hibernate.HibernateBundle;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

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
}

