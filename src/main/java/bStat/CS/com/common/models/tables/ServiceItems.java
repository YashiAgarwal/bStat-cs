package bStat.CS.com.common.models.tables;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by Yashi Agarwal on 23-05-2017.
 */
 @Entity
 @Table(name = "service_items")
 public class ServiceItems {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    @JsonProperty("product_id")
    private long productId;

    @JsonProperty("description")
    private String description;

    @JsonProperty("title")
    private String title;

    @JsonProperty("service_type")
    private String serviceType;

    @JsonProperty("price_for_free_service")
    private String priceForFreeService;

    @JsonProperty("customer_id")
    private long customerId;

    @JsonProperty("service_type_id")
    private long serviceTypeId;

    @Column(name = "created_on")
    private Date createdOn;

    @Column(name = "modified_on")
    private Date modifiedOn;

    @JsonProperty("count_of_free_services")
    private int countOfFreeServices;

    @JsonProperty("period_of_service")
    private int periodOfService;

    @JsonProperty("price_for_paid_service")
    private int priceForPaidService;

    public ServiceItems() {
    }

    public ServiceItems(long id, long productId, String description, String title, String serviceType,
                        String priceForFreeService, long customerId, long serviceTypeId, Date createdOn, Date modifiedOn,
                        int countOfFreeServices, int periodOfService, int priceForPaidService) {
        this.id = id;
        this.productId = productId;
        this.description = description;
        this.title = title;
        this.serviceType = serviceType;
        this.priceForFreeService = priceForFreeService;
        this.customerId = customerId;
        this.serviceTypeId = serviceTypeId;
        this.createdOn = createdOn;
        this.modifiedOn = modifiedOn;
        this.countOfFreeServices = countOfFreeServices;
        this.periodOfService = periodOfService;
        this.priceForPaidService = priceForPaidService;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getProductId() {
        return productId;
    }

    public void setProductId(long productId) {
        this.productId = productId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getServiceType() {
        return serviceType;
    }

    public void setServiceType(String serviceType) {
        this.serviceType = serviceType;
    }

    public String getPriceForFreeService() {
        return priceForFreeService;
    }

    public void setPriceForFreeService(String priceForFreeService) {
        this.priceForFreeService = priceForFreeService;
    }

    public long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(long customerId) {
        this.customerId = customerId;
    }

    public long getServiceTypeId() {
        return serviceTypeId;
    }

    public void setServiceTypeId(long serviceTypeId) {
        this.serviceTypeId = serviceTypeId;
    }

    public Date getCreatedOn() {
        return createdOn;
    }

    public void setCreatedOn(Date createdOn) {
        this.createdOn = createdOn;
    }

    public Date getModifiedOn() {
        return modifiedOn;
    }

    public void setModifiedOn(Date modifiedOn) {
        this.modifiedOn = modifiedOn;
    }

    public int getCountOfFreeServices() {
        return countOfFreeServices;
    }

    public void setCountOfFreeServices(int countOfFreeServices) {
        this.countOfFreeServices = countOfFreeServices;
    }

    public int getPeriodOfService() {
        return periodOfService;
    }

    public void setPeriodOfService(int periodOfService) {
        this.periodOfService = periodOfService;
    }

    public int getPriceForPaidService() {
        return priceForPaidService;
    }

    public void setPriceForPaidService(int priceForPaidService) {
        this.priceForPaidService = priceForPaidService;
    }
}
