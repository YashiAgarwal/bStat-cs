package bStat.CS.com.common.models.tables;

import bStat.CS.com.common.enums.TradeCategory;
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
    @Column(name = "product_id")
    private long productId;

    @JsonProperty("title")
    private String title;

    @JsonProperty("category_id")
    private long categoryId;

    @JsonProperty("category_child_id")
    private long categoryChildId;

    @JsonProperty("image_url")
    private String imageUrl;

    @JsonProperty("warranty_period")
    private String warrantyPeriod;

    @Column(name = "selling_price")
    private double sellingPrice;

    @Column(name = "MRP")
    private double MRP;

    @Column(name = "trade_category")
    @Enumerated(EnumType.STRING)
    private TradeCategory tradeCategory;

    @JsonProperty("listing")
    private boolean listing;    // active or inactive

    @Column(name = "created_on")
    private Date createdOn;

    @Column(name = "modified_on")
    private Date modifiedOn;

    public Products() {
    }

    public Products(String title, long categoryId, long categoryChildId, String imageUrl, String warrantyPeriod,
                    double sellingPrice, double MRP, TradeCategory tradeCategory, boolean listing, Date createdOn, Date modifiedOn) {
        this.title = title;
        this.categoryId = categoryId;
        this.categoryChildId = categoryChildId;
        this.imageUrl = imageUrl;
        this.warrantyPeriod = warrantyPeriod;
        this.sellingPrice = sellingPrice;
        this.MRP = MRP;
        this.tradeCategory = tradeCategory;
        this.listing = listing;
        this.createdOn = createdOn;
        this.modifiedOn = modifiedOn;
    }

    public long getProductId() {
        return productId;
    }

    public void setProductId(long productId) {
        this.productId = productId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public long getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(long categoryId) {
        this.categoryId = categoryId;
    }

    public long getCategoryChildId() {
        return categoryChildId;
    }

    public void setCategoryChildId(long categoryChildId) {
        this.categoryChildId = categoryChildId;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getWarrantyPeriod() {
        return warrantyPeriod;
    }

    public void setWarrantyPeriod(String warrantyPeriod) {
        this.warrantyPeriod = warrantyPeriod;
    }

    public double getSellingPrice() {
        return sellingPrice;
    }

    public void setSellingPrice(double sellingPrice) {
        this.sellingPrice = sellingPrice;
    }

    public double getMRP() {
        return MRP;
    }

    public void setMRP(double MRP) {
        this.MRP = MRP;
    }

    public TradeCategory getTradeCategory() {
        return tradeCategory;
    }

    public void setTradeCategory(TradeCategory tradeCategory) {
        this.tradeCategory = tradeCategory;
    }

    public boolean isListing() {
        return listing;
    }

    public void setListing(boolean listing) {
        this.listing = listing;
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
}

