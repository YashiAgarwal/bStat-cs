package bStat.CS.com.FeedObjects;

import bStat.CS.com.common.enums.TradeCategory;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import java.util.Date;

/**
 * Created by Yashi Agarwal on 31-05-2017.
 */
@Getter
@Setter
public class ProductDTO {

    private String title;

    private String categoryId;

    private String categoryChildId;

    private String verticalId;

    private String imageUrl;

    private String warrantyPeriod;

    private double sellingPrice;

    private double MRP;

    private TradeCategory tradeCategory;

    private boolean listing;    // active or inactive

    private Object variationParameter;

    private boolean isConcrete;
}
