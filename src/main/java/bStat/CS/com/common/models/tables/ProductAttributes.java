package bStat.CS.com.common.models.tables;

import lombok.*;

import javax.persistence.*;

/**
 * Created by Yashi Agarwal on 30-05-2017.
 */
@Entity
@Getter
@Setter
@AllArgsConstructor
@Table(name = "product_attributes")
public class ProductAttributes {

    @Id
    @Column(name = "id")
    private String id;

    @Column(name = "product_id")
    private String productId;

    @Column(name = "attribute_key")
    private String attributeKey;

    @Column(name = "attribute_value")
    private String attributeValue;


}
