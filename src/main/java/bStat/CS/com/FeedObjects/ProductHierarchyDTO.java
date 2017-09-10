package bStat.CS.com.FeedObjects;

import bStat.CS.com.common.enums.NodeType;

/**
 * Created by Yashi Agarwal on 06-06-2017.
 */
public class ProductHierarchyDTO {

    private String parentNodeId;

    private String childNodeId;

    private String verticalId;

    private NodeType nodeType;

    public String getParentNodeId() {
        return parentNodeId;
    }

    public void setParentNodeId(String parentNodeId) {
        this.parentNodeId = parentNodeId;
    }

    public String getChildNodeId() {
        return childNodeId;
    }

    public void setChildNodeId(String childNodeId) {
        this.childNodeId = childNodeId;
    }

    public String getVerticalId() {
        return verticalId;
    }

    public void setVerticalId(String verticalId) {
        this.verticalId = verticalId;
    }

    public NodeType getNodeType() {
        return nodeType;
    }

    public void setNodeType(NodeType nodeType) {
        this.nodeType = nodeType;
    }
}


