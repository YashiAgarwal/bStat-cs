package bStat.CS.com.FeedObjects;

import javax.persistence.Column;

/**
 * Created by Yashi Agarwal on 02-06-2017.
 */
public class ProductAttributeDTO {

    private long productId;

    private String attributeKey;

    private String attributeValue;

    public long getProductId() {
        return productId;
    }

    public void setProductId(long productId) {
        this.productId = productId;
    }

    public String getAttributeKey() {
        return attributeKey;
    }

    public void setAttributeKey(String attributeKey) {
        this.attributeKey = attributeKey;
    }

    public String getAttributeValue() {
        return attributeValue;
    }

    public void setAttributeValue(String attributeValue) {
        this.attributeValue = attributeValue;
    }
}
