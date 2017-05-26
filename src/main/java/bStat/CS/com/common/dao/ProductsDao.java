package bStat.CS.com.common.dao;

import bStat.CS.com.common.models.tables.Products;
import com.google.inject.Inject;
import io.dropwizard.hibernate.AbstractDAO;
import io.dropwizard.hibernate.HibernateBundle;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by Yashi Agarwal on 19-05-2017.
 */
public class ProductsDao extends AbstractDAO<Products> {

    private static final Logger logger = LoggerFactory.getLogger(ProductsDao.class);

    @Inject
    public ProductsDao(HibernateBundle bundle) {
        super(bundle.getSessionFactory());
    }

    public Products saveInDB(Products Products) {
        return persist(Products);
    }
}
