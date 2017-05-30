package bStat.CS.com.common.models.tables;

import bStat.CS.com.common.enums.NodeType;
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
    @Column(name = "id")
    private long id;

    @Column(name = "parent_node_id")
    private long parentNodeId;

    @JsonProperty("child_node_id")
    private long childNodeId;

    @JsonProperty("vertical_id")
    private long verticalId;

    @JsonProperty("node_type")
    @Enumerated(EnumType.STRING)
    private NodeType nodeType;

    public ProductsHierarchy() {
    }

    public ProductsHierarchy(long parentNodeId, long childNodeId, long verticalId, NodeType nodeType) {
        this.parentNodeId = parentNodeId;
        this.childNodeId = childNodeId;
        this.verticalId = verticalId;
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

    public long getVerticalId() {
        return verticalId;
    }

    public void setVerticalId(long verticalId) {
        this.verticalId = verticalId;
    }

    public NodeType getNodeType() {
        return nodeType;
    }

    public void setNodeType(NodeType nodeType) {
        this.nodeType = nodeType;
    }
}




