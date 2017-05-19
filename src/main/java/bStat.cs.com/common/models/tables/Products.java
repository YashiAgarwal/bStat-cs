package bStat.cs.com.common.models.tables;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by Yashi Agarwal on 19-05-2017.
 */
@Entity
@Table(name = "products")
public class Products {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    @JsonProperty("trade_category")
    private String tradeCategory;

    @JsonProperty("name")
    private String name;

    @JsonProperty("description")
    private String description;

    @JsonProperty("group_id")
    private long groupId;

    @JsonProperty("node_id")
    private long nodeId;

    @Column(name = "created_on")
    private Date createdOn;

    @Column(name = "modified_on")
    private Date modifiedOn;

    @JsonProperty("ideal_weight")
    private int idealWeight;

    @JsonProperty("ideal_length")
    private int idealLength;

    @Column(name = "ideal_breadth")
    private int idealBreadth;

    @Column(name = "ideal_width")
    private int idealWidth;

    @Column(name = "selling_price")
    private int sellingPrice;

    @Column(name = "is_direct__price")
    private boolean isDirectPrice;

    @JsonProperty("formula_id")
    private long formulaId;

    @Column(name = "dimension_unit")
    private int dimensionUnit;

    @Column(name = "weight_unit")
    private int weightUnit;

    @Column(name = "is_active")
    private boolean isActive;

    public Products() {
    }

    public Products(long id, String tradeCategory, String name, String description, long groupId, long nodeId,
                    Date createdOn, Date modifiedOn, int idealWeight, int idealLength, int idealBreadth,
                    int idealWidth, int sellingPrice, boolean isDirectPrice, long formulaId, int dimensionUnit,
                    int weightUnit, boolean isActive) {
        this.id = id;
        this.tradeCategory = tradeCategory;
        this.name = name;
        this.description = description;
        this.groupId = groupId;
        this.nodeId = nodeId;
        this.createdOn = createdOn;
        this.modifiedOn = modifiedOn;
        this.idealWeight = idealWeight;
        this.idealLength = idealLength;
        this.idealBreadth = idealBreadth;
        this.idealWidth = idealWidth;
        this.sellingPrice = sellingPrice;
        this.isDirectPrice = isDirectPrice;
        this.formulaId = formulaId;
        this.dimensionUnit = dimensionUnit;
        this.weightUnit = weightUnit;
        this.isActive = isActive;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTradeCategory() {
        return tradeCategory;
    }

    public void setTradeCategory(String tradeCategory) {
        this.tradeCategory = tradeCategory;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public long getGroupId() {
        return groupId;
    }

    public void setGroupId(long groupId) {
        this.groupId = groupId;
    }

    public long getNodeId() {
        return nodeId;
    }

    public void setNodeId(long nodeId) {
        this.nodeId = nodeId;
    }

    public Date getCreatedOn() {
        return createdOn;
    }

    public void setCreatedOn(Date createdOn) {
        this.createdOn = createdOn;
    }

    public Date getModifiedOn() {
        return modifiedOn;
    }

    public void setModifiedOn(Date modifiedOn) {
        this.modifiedOn = modifiedOn;
    }

    public int getIdealWeight() {
        return idealWeight;
    }

    public void setIdealWeight(int idealWeight) {
        this.idealWeight = idealWeight;
    }

    public int getIdealLength() {
        return idealLength;
    }

    public void setIdealLength(int idealLength) {
        this.idealLength = idealLength;
    }

    public int getIdealBreadth() {
        return idealBreadth;
    }

    public void setIdealBreadth(int idealBreadth) {
        this.idealBreadth = idealBreadth;
    }

    public int getIdealWidth() {
        return idealWidth;
    }

    public void setIdealWidth(int idealWidth) {
        this.idealWidth = idealWidth;
    }

    public int getSellingPrice() {
        return sellingPrice;
    }

    public void setSellingPrice(int sellingPrice) {
        this.sellingPrice = sellingPrice;
    }

    public boolean isDirectPrice() {
        return isDirectPrice;
    }

    public void setDirectPrice(boolean directPrice) {
        isDirectPrice = directPrice;
    }

    public long getFormulaId() {
        return formulaId;
    }

    public void setFormulaId(long formulaId) {
        this.formulaId = formulaId;
    }

    public int getDimensionUnit() {
        return dimensionUnit;
    }

    public void setDimensionUnit(int dimensionUnit) {
        this.dimensionUnit = dimensionUnit;
    }

    public int getWeightUnit() {
        return weightUnit;
    }

    public void setWeightUnit(int weightUnit) {
        this.weightUnit = weightUnit;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }
}

