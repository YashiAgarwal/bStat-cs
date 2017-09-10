package bStat.CS.com.common.models.tables;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Created by Yashi Agarwal on 03-09-2017.
 */
@Entity
@Getter
@Setter
@AllArgsConstructor
@Table(name = "product_variations")
public class ProductVariations {

    @Id
    @Column(name = "variation_id")
    private String variationId;

    @Column(name = "product_id")
    private String productId;

    @Column(name = "value")
    private double value;

    @Column(name = "MRP")
    private double MRP;

    @Column(name = "selling_price")
    private double sellingPrice;
    

    

}
