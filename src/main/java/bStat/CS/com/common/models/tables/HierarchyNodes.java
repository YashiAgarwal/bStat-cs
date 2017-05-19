package bStat.CS.com.common.models.tables;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;

/**
 * Created by Yashi Agarwal on 19-05-2017.
 */
    @Entity
    @Table(name = "hierarchy_nodes")
    public class HierarchyNodes {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(name = "node_id")
        private long nodeId;

        @JsonProperty("product_id")
        private long productId;

        @JsonProperty("description")
        private String description;

        public HierarchyNodes() {
        }

        public HierarchyNodes(long nodeId, long productId, String description) {
            this.nodeId = nodeId;
            this.productId = productId;
            this.description = description;
        }

        public long getNodeId() {
            return nodeId;
        }

        public void setNodeId(long nodeId) {
            this.nodeId = nodeId;
        }

        public long getProductId() {
            return productId;
        }

        public void setProductId(long productId) {
            this.productId = productId;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }
    }
