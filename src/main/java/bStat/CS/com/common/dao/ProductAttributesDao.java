package bStat.CS.com.common.dao;

import bStat.CS.com.common.models.tables.ProductAttributes;
import bStat.CS.com.common.models.tables.Products;
import com.google.inject.Inject;
import io.dropwizard.hibernate.AbstractDAO;
import io.dropwizard.hibernate.HibernateBundle;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

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
}

