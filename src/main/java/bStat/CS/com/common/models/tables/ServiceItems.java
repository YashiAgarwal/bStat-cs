package bStat.CS.com.common.models.tables;

import bStat.CS.com.common.enums.ServiceType;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by Yashi Agarwal on 23-05-2017.
 */
 @Entity
 @Data
 @NoArgsConstructor
 @Table(name = "service_items")
 public class ServiceItems {

    @Id
    @Column(name = "id")
    private String id;

    @Column(name = "associated_product_id")
    private String associatedProductId;

    @Column(name = "description")
    private String description;

    @Column(name = "title")
    private String title;

    @Column(name = "service_type")
    @Enumerated(EnumType.STRING)
    private ServiceType serviceType;

    @Column(name = "price_for_free_service")
    private double priceForFreeService;

    @Column(name = "customer_id")
    private String customerId;

    @Column(name = "created_on")
    private Date createdOn;

    @Column(name = "modified_on")
    private Date modifiedOn;

    @Column(name = "count_of_free_services")
    private int countOfFreeServices;

    @Column(name = "period_of_service")
    private String periodOfService;

    @Column(name = "price_for_paid_service")
    private double priceForPaidService;

    @Column(name = "product_variation_id")
    private String productVariationId;


}
