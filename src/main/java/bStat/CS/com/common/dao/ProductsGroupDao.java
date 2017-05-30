package bStat.CS.com.common.dao;

import bStat.CS.com.common.models.tables.ProductVerticals;
import com.google.inject.Inject;
import io.dropwizard.hibernate.AbstractDAO;
import io.dropwizard.hibernate.HibernateBundle;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by Yashi Agarwal on 19-05-2017.
 */
public class ProductsGroupDao extends AbstractDAO<ProductVerticals> {

    private static final Logger logger = LoggerFactory.getLogger(ProductsGroupDao.class);

    @Inject
    public ProductsGroupDao(HibernateBundle bundle) {
        super(bundle.getSessionFactory());
    }

    public ProductVerticals saveInDB(ProductVerticals ProductsGroup) {
        return persist(ProductsGroup);
    }
}
