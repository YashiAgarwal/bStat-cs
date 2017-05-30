package bStat.CS.com.common.models.tables;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;

/**
 * Created by Yashi Agarwal on 19-05-2017.
 */
@Entity
@Table(name = "product_verticals")
public class ProductVerticals {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "vertical_id")
    private long verticalId;

    @JsonProperty("start_category_node")
    private String startCategoryNode;

    @JsonProperty("vertical_name")
    private String verticalName;

    @JsonProperty("description")
    private String description;

    public ProductVerticals() {
    }

    public ProductVerticals(long verticalId, String startNode, String groupName, String description) {
        this.verticalId = verticalId;
        this.startCategoryNode = startNode;
        this.verticalName = groupName;
        this.description = description;
    }

    public long getVerticalId() {
        return verticalId;
    }

    public void setVerticalId(long verticalId) {
        this.verticalId = verticalId;
    }

    public String getStartNode() {
        return startCategoryNode;
    }

    public void setStartNode(String startNode) {
        this.startCategoryNode = startNode;
    }

    public String getVerticalName() {
        return verticalName;
    }

    public void setVerticalName(String verticalName) {
        this.verticalName = verticalName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
