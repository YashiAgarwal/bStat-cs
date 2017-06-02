package bStat.CS.com.controllers;

import bStat.CS.com.FeedObjects.ProductAttributeDTO;
import bStat.CS.com.FeedObjects.ProductDTO;
import bStat.CS.com.FeedObjects.ServiceItemsDTO;
import bStat.CS.com.common.dao.ProductAttributesDao;
import bStat.CS.com.common.dao.ProductsDao;
import bStat.CS.com.common.dao.ServiceItemsDao;
import bStat.CS.com.common.models.tables.ProductAttributes;
import bStat.CS.com.common.models.tables.Products;
import bStat.CS.com.common.models.tables.ServiceItems;
import bStat.CS.com.resources.DataResource;
import com.google.inject.Inject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Date;

/**
 * Created by Yashi Agarwal on 31-05-2017.
 */
public class DataController {

    @Inject
    ProductsDao productsDao;

    @Inject
    ServiceItemsDao serviceItemsDao;

    @Inject
    ProductAttributesDao productAttributesDao;

    private static final Logger logger = LoggerFactory.getLogger(DataController.class);


    public void addNewProduct(ProductDTO productDTO) {
        Products products = new Products(productDTO.getTitle() , productDTO.getCategoryId() , productDTO.getCategoryChildId(),
                productDTO.getVerticalId() , productDTO.getImageUrl(), productDTO.getWarrantyPeriod(), productDTO.getSellingPrice(),
                productDTO.getMRP(), productDTO.getTradeCategory(), true, new Date(System.currentTimeMillis()),
                new Date(System.currentTimeMillis()));
        productsDao.saveInDB(products);
    }

    public void addNewServiceItems(ServiceItemsDTO serviceItemsDTO){
        ServiceItems serviceItems = new ServiceItems(serviceItemsDTO.getProductId(), serviceItemsDTO.getDescription(),
                serviceItemsDTO.getTitle(), serviceItemsDTO.getServiceType(), serviceItemsDTO.getPriceForFreeService(),
                serviceItemsDTO.getCustomerId(), new Date(System.currentTimeMillis()), new Date(System.currentTimeMillis()),
                serviceItemsDTO.getCountOfFreeServices(), serviceItemsDTO.getPeriodOfService(), serviceItemsDTO.getPriceForPaidService());
        serviceItemsDao.saveInDB(serviceItems);
    }

    public void addNewProductAttribute(ProductAttributeDTO productAttributeDTO){
        ProductAttributes productAttributes = new ProductAttributes(productAttributeDTO.getProductId(),
                productAttributeDTO.getAttributeKey(), productAttributeDTO.getAttributeValue());
        productAttributesDao.saveInDB(productAttributes);
    }
}
