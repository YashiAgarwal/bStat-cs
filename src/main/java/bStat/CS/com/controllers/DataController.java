package bStat.CS.com.controllers;

import bStat.CS.com.FeedObjects.*;
import bStat.CS.com.common.dao.*;
import bStat.CS.com.common.models.tables.*;
import bStat.CS.com.utils.Constants;
import bStat.CS.com.utils.Utilities;
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

    @Inject
    Utilities utilities;

    private static final Logger logger = LoggerFactory.getLogger(DataController.class);

    @Inject
    public DataController(HierarchyNodesDao hierarchyNodesDao, ProductAttributesDao productAttributesDao, ProductsDao productsDao,
                          ProductsHierarchyDao productsHierarchyDao, ServiceItemsDao serviceItemsDao, Utilities utilities) {
        this.hierarchyNodesDao = hierarchyNodesDao;
        this.productAttributesDao = productAttributesDao;
        this.productsDao = productsDao;
        this.productsHierarchyDao = productsHierarchyDao;
        this.serviceItemsDao = serviceItemsDao;
        this.utilities = utilities;
    }


    public void addNewProduct(ProductDTO productDTO) {
        Products products = new Products(utilities.generateRandomUID(Constants.PRODUCT_ID_PREFIX, Constants.PRODUCT_ID_LENGTH),
                productDTO.getTitle(), productDTO.getCategoryId(), productDTO.getCategoryChildId(),
                productDTO.getImageUrl(), productDTO.getWarrantyPeriod(), productDTO.getTradeCategory(),
                productDTO.isListing(), new Date(System.currentTimeMillis()), productDTO.getVariationParameter(), productDTO.isConcrete());
        productsDao.saveInDB(products);
    }

    public void addNewServiceItems(ServiceItemsDTO serviceItemsDTO) {
        ServiceItems serviceItems = new ServiceItems(utilities.generateRandomUID(Constants.SERVICE_ID_PREFIX,
                Constants.SERVICE_ID_LENGTH),serviceItemsDTO.getAssociatedProductId(),serviceItemsDTO.getDescription(),
                serviceItemsDTO.getTitle(), serviceItemsDTO.getServiceType(), serviceItemsDTO.getPriceForFreeService(),
                new Date(System.currentTimeMillis()), new Date(System.currentTimeMillis()),
                serviceItemsDTO.getCountOfFreeServices(), serviceItemsDTO.getPeriodOfService(),
                serviceItemsDTO.getPriceForPaidService(), serviceItemsDTO.getProductVariationId());
        serviceItemsDao.saveInDB(serviceItems);
    }

    public void addNewProductAttribute(ProductAttributeDTO productAttributeDTO) {
        ProductAttributes productAttributes = new ProductAttributes(utilities.generateRandomUID(Constants.PRODUCT_ATTRIBUTE_ID_PREFIX,
                Constants.PRODUCT_ATTRIBUTE_ID_LENGTH), productAttributeDTO.getProductId(),
                productAttributeDTO.getAttributeKey(), productAttributeDTO.getAttributeValue());
        productAttributesDao.saveInDB(productAttributes);
    }

    public void addNewProductVertical(ProductVerticalDTO productVerticalDTO) {
        ProductVerticals productVerticals = new ProductVerticals(utilities.generateRandomUID(Constants.PRODUCT_VERTICAL_ID_PREFIX,
                Constants.PRODUCT_VERTICAL_ID_LENGTH),
                productVerticalDTO.getStartCategoryNode(), productVerticalDTO.getVerticalName(), productVerticalDTO.getDescription(),
                productVerticalDTO.getGroupId());
        productVerticalsDao.saveInDB(productVerticals);
    }

    public void addNewCategoryNode(CategoryNodeDTO categoryNodeDTO) {
        CategoryNodes categoryNodes = new CategoryNodes(utilities.generateRandomUID(Constants.CATEGORY_NODE_ID_PREFIX,
                Constants.CATEGORY_NODE_ID_LENGTH), categoryNodeDTO.getNodeName(), categoryNodeDTO.getNodeMetaData(),
                categoryNodeDTO.getDescription(), categoryNodeDTO.getDescription());
        categoryNodesDao.saveInDB(categoryNodes);
    }

    public void addNewProductHierarchy(ProductHierarchyDTO productHierarchyDTO){
        ProductsHierarchy productsHierarchy = new ProductsHierarchy(utilities.generateRandomUID(Constants.CATEGORY_NODE_ID_PREFIX,
                Constants.CATEGORY_NODE_ID_LENGTH), productHierarchyDTO.getParentNodeId(),
                productHierarchyDTO.getChildNodeId(), productHierarchyDTO.getGroupId(), productHierarchyDTO.getNodeType());
        productsHierarchyDao.saveInDB(productsHierarchy);
    }

}


