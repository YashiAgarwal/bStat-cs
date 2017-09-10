package bStat.CS.com.controllers;

import bStat.CS.com.FeedObjects.*;
import bStat.CS.com.common.dao.*;
import bStat.CS.com.common.models.tables.*;
import com.google.inject.Inject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Date;

/**
 * Created by Yashi Agarwal on 31-05-2017.
 */
public class DataController {

    @Inject
    HierarchyNodesDao hierarchyNodesDao;

    @Inject
    ProductsDao productsDao;

    @Inject
    ServiceItemsDao serviceItemsDao;

    @Inject
    ProductAttributesDao productAttributesDao;

    @Inject
    CategoryNodesDao categoryNodesDao;

    @Inject
    ProductVerticalsDao productVerticalsDao;

    @Inject
    ProductsHierarchyDao productsHierarchyDao;

    private static final Logger logger = LoggerFactory.getLogger(DataController.class);

    @Inject
    public DataController(HierarchyNodesDao hierarchyNodesDao, ProductAttributesDao productAttributesDao, ProductsDao productsDao,
                          ProductsHierarchyDao productsHierarchyDao, ServiceItemsDao serviceItemsDao) {
        this.hierarchyNodesDao = hierarchyNodesDao;
        this.productAttributesDao = productAttributesDao;
        this.productsDao = productsDao;
        this.productsHierarchyDao = productsHierarchyDao;
        this.serviceItemsDao = serviceItemsDao;
    }


    public void addNewProduct(ProductDTO productDTO) {
        Products products = new Products(productDTO.getTitle(), productDTO.getCategoryId(), productDTO.getCategoryChildId(),
                productDTO.getVerticalId(), productDTO.getImageUrl(), productDTO.getWarrantyPeriod(), productDTO.getTradeCategory(),
                productDTO.isListing(), new Date(System.currentTimeMillis()), productDTO.getVariationParameter(), productDTO.isConcrete());
        productsDao.saveInDB(products);
    }

    public void addNewServiceItems(ServiceItemsDTO serviceItemsDTO) {
        ServiceItems serviceItems = new ServiceItems(serviceItemsDTO.getProductId(), serviceItemsDTO.getDescription(),
                serviceItemsDTO.getTitle(), serviceItemsDTO.getServiceType(), serviceItemsDTO.getPriceForFreeService(),
                serviceItemsDTO.getCustomerId(), new Date(System.currentTimeMillis()), new Date(System.currentTimeMillis()),
                serviceItemsDTO.getCountOfFreeServices(), serviceItemsDTO.getPeriodOfService(), serviceItemsDTO.getPriceForPaidService());
        serviceItemsDao.saveInDB(serviceItems);
    }

    public void addNewProductAttribute(ProductAttributeDTO productAttributeDTO) {
        ProductAttributes productAttributes = new ProductAttributes(productAttributeDTO.getProductId(),
                productAttributeDTO.getAttributeKey(), productAttributeDTO.getAttributeValue());
        productAttributesDao.saveInDB(productAttributes);
    }

    public void addNewProductVertical(ProductVerticalDTO productVerticalDTO) {
        ProductVerticals productVerticals = new ProductVerticals(productVerticalDTO.getStartCategoryNode(),
                productVerticalDTO.getVerticalName(), productVerticalDTO.getDescription());
        productVerticalsDao.saveInDB(productVerticals);
    }

    public void addNewCategoryNode(CategoryNodeDTO categoryNodeDTO) {
        CategoryNodes categoryNodes = new CategoryNodes(categoryNodeDTO.getProductId(), categoryNodeDTO.getDescription());
        categoryNodesDao.saveInDB(categoryNodes);
    }

    public void addNewProductHierarchy(ProductHierarchyDTO productHierarchyDTO){
        ProductsHierarchy productsHierarchy = new ProductsHierarchy(productHierarchyDTO.getParentNodeId(),
                productHierarchyDTO.getChildNodeId(), productHierarchyDTO.getVerticalId(), productHierarchyDTO.getNodeType());
        productsHierarchyDao.saveInDB(productsHierarchy);
    }

}


