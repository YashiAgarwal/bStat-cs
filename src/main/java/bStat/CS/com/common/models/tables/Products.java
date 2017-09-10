package bStat.CS.com.common.models.tables;

import bStat.CS.com.common.enums.TradeCategory;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by Yashi Agarwal on 19-05-2017.
 */
@Entity
@Data
@NoArgsConstructor
@Table(name = "products")
public class Products {

    @Id
    @Column(name = "product_id")
    private String productId;

    @Column(name = "title")
    private String title;

    @Column(name = "category_id")
    private String categoryId;

    @Column(name = "category_child_id")
    private String categoryChildId;

    @Column(name = "image_url")
    private String imageUrl;

    @Column(name = "warranty_period")
    private String warrantyPeriod;

    @Column(name = "trade_category")
    @Enumerated(EnumType.STRING)
    private TradeCategory tradeCategory;

    @Column(name = "listing")
    private boolean listing;    // active or inactive

    @Column(name = "created_on")
    private Date createdOn;

    @Column(name = "variation_parameter")
    private Object variationParameter;

    @Column(name = "is_concrete")
    private boolean isConcrete;     // will be true if product has no variation
}

