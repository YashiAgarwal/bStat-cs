package bStat.CS.com.common.models.tables;

import bStat.CS.com.common.enums.ServiceType;
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
    @Enumerated(EnumType.STRING)
    private ServiceType serviceType;

    @JsonProperty("price_for_free_service")
    private double priceForFreeService;

    @JsonProperty("customer_id")
    private long customerId;

    @Column(name = "created_on")
    private Date createdOn;

    @Column(name = "modified_on")
    private Date modifiedOn;

    @JsonProperty("count_of_free_services")
    private int countOfFreeServices;

    @JsonProperty("period_of_service")
    private String periodOfService;

    @JsonProperty("price_for_paid_service")
    private double priceForPaidService;


    public ServiceItems() {
    }

    public ServiceItems(long productId, String description, String title, ServiceType serviceType,
                        double priceForFreeService, long customerId, Date createdOn,
                        Date modifiedOn, int countOfFreeServices, String periodOfService, double priceForPaidService) {
        this.productId = productId;
        this.description = description;
        this.title = title;
        this.serviceType = serviceType;
        this.priceForFreeService = priceForFreeService;
        this.customerId = customerId;
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

    public ServiceType getServiceType() {
        return serviceType;
    }

    public void setServiceType(ServiceType serviceType) {
        this.serviceType = serviceType;
    }

    public double getPriceForFreeService() {
        return priceForFreeService;
    }

    public void setPriceForFreeService(double priceForFreeService) {
        this.priceForFreeService = priceForFreeService;
    }

    public long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(long customerId) {
        this.customerId = customerId;
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

    public String getPeriodOfService() {
        return periodOfService;
    }

    public void setPeriodOfService(String periodOfService) {
        this.periodOfService = periodOfService;
    }

    public double getPriceForPaidService() {
        return priceForPaidService;
    }

    public void setPriceForPaidService(double priceForPaidService) {
        this.priceForPaidService = priceForPaidService;
    }
}
