package bStat.CS.com.FeedObjects;

import bStat.CS.com.common.enums.ServiceType;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import java.util.Date;

/**
 * Created by Yashi Agarwal on 02-06-2017.
 */
@Getter
@Setter
public class ServiceItemsDTO {


    private String associatedProductId;

    private String productVariationId;

    private String description;

    private String title;

    private ServiceType serviceType;

    private double priceForFreeService;

    private int countOfFreeServices;

    private String periodOfService;

    private double priceForPaidService;
}
