package bStat.CS.com.FeedObjects;

import bStat.CS.com.common.enums.TradeCategory;
import lombok.Data;

/**
 * Created by Yashi Agarwal on 31-05-2017.
 */
@Data
public class ProductDTO {

    private String title;

    private String categoryId;

    private String categoryChildId;

    private String verticalId;

    private String imageUrl;

    private String warrantyPeriod;

    private double sellingPrice;

    private double MRP;

    private TradeCategory tradeCategory;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(String categoryId) {
        this.categoryId = categoryId;
    }

    public String getCategoryChildId() {
        return categoryChildId;
    }

    public void setCategoryChildId(String categoryChildId) {
        this.categoryChildId = categoryChildId;
    }

    public String getVerticalId() {
        return verticalId;
    }

    public void setVerticalId(String verticalId) {
        this.verticalId = verticalId;
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
}
