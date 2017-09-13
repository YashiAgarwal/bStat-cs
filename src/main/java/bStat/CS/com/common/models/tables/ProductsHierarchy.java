package bStat.CS.com.common.models.tables;

import bStat.CS.com.common.enums.NodeType;
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
@Table(name = "products_hierarchy")
public class ProductsHierarchy {

    @Id
    @Column(name = "id")
    private String id;

    @Column(name = "parent_node_id")
    private String parentNodeId;

    @Column(name = "child_node_id")
    private String childNodeId;

    @Column(name = "group_id")
    private String groupId;

    @Column(name = "node_type")
    @Enumerated(EnumType.STRING)
    private NodeType nodeType;


}




