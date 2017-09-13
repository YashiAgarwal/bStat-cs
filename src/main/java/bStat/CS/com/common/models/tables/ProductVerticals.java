package bStat.CS.com.common.models.tables;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import javax.persistence.*;

/**
 * Created by Yashi Agarwal on 19-05-2017.
 */
@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "product_verticals")
public class ProductVerticals {

    @Id
    @Column(name = "vertical_id")
    private String verticalId;

    @Column(name = "start_category_node")
    private long startCategoryNode;

    @Column(name = "vertical_name")
    private String verticalName;

    @Column(name = "description")
    private String description;

    @Column(name = "group_id")
    private String groupId;


}
