package bStat.cs.com.common.models.tables;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;

/**
 * Created by Yashi Agarwal on 19-05-2017.
 */
@Entity
@Table(name = "products_group")
public class ProductsGroup {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "group_id")
    private long groupId;

    @JsonProperty("start_node")
    private String startNode;

    @JsonProperty("group_name")
    private String  groupName;

    @JsonProperty("description")
    private String description;

    public ProductsGroup() {
    }

    public ProductsGroup(long groupId, String startNode, String groupName, String description) {
        this.groupId = groupId;
        this.startNode = startNode;
        this.groupName = groupName;
        this.description = description;
    }

    public long getGroupId() {
        return groupId;
    }

    public void setGroupId(long groupId) {
        this.groupId = groupId;
    }

    public String getStartNode() {
        return startNode;
    }

    public void setStartNode(String startNode) {
        this.startNode = startNode;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
