package bStat.CS.com.common.models.tables;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

/**
 * Created by Yashi Agarwal on 19-05-2017.
 */
    @Entity
    @Data
    @NoArgsConstructor
    @Table(name = "hierarchy_nodes")
    public class CategoryNodes {

        @Id
        @Column(name = "node_id")
        private String nodeId;

        @Column(name = "node_name")
        private String nodeName;

        @Column(name = "node_meta_data")
        private String nodeMetaData;

        @Column(name = "product_id")  //in case node is a product itself
        private String productId;

        @Column(name = "description")
        private String description;


    }
