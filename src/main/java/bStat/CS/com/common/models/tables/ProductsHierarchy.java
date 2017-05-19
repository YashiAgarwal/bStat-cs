package bStat.CS.com.common.models.tables;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;

/**
 * Created by Yashi Agarwal on 19-05-2017.
 */

@Entity
@Table(name = "products_hierarchy")
public class ProductsHierarchy {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "parent_node_id")
    private long parentNodeId;

    @JsonProperty("child_node_id")
    private long childNodeId;

    @JsonProperty("group_id")
    private long groupId;

    @JsonProperty("node_type")
    private long nodeType;

    public ProductsHierarchy() {
    }

    public ProductsHierarchy(long parentNodeId, long childNodeId, long groupId, long nodeType) {
        this.parentNodeId = parentNodeId;
        this.childNodeId = childNodeId;
        this.groupId = groupId;
        this.nodeType = nodeType;
    }

    public long getParentNodeId() {
        return parentNodeId;
    }

    public void setParentNodeId(long parentNodeId) {
        this.parentNodeId = parentNodeId;
    }

    public long getChildNodeId() {
        return childNodeId;
    }

    public void setChildNodeId(long childNodeId) {
        this.childNodeId = childNodeId;
    }

    public long getGroupId() {
        return groupId;
    }

    public void setGroupId(long groupId) {
        this.groupId = groupId;
    }

    public long getNodeType() {
        return nodeType;
    }

    public void setNodeType(long nodeType) {
        this.nodeType = nodeType;
    }
}




