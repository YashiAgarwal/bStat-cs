package bStat.CS.com.FeedObjects;

import bStat.CS.com.common.enums.ServiceType;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.Column;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import java.util.Date;

/**
 * Created by Yashi Agarwal on 02-06-2017.
 */
public class ServiceItemsDTO {

    private long productId;

    private String description;

    private String title;

    private ServiceType serviceType;

    private double priceForFreeService;

    private long customerId;

    private int countOfFreeServices;

    private String periodOfService;

    private double priceForPaidService;

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
