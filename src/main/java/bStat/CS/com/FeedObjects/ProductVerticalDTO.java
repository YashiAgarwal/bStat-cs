package bStat.CS.com.FeedObjects;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created by Yashi Agarwal on 05-06-2017.
 */
public class ProductVerticalDTO {
    private long startCategoryNode;

    private String verticalName;

    private String description;

    public long getStartCategoryNode() {
        return startCategoryNode;
    }

    public void setStartCategoryNode(long startCategoryNode) {
        this.startCategoryNode = startCategoryNode;
    }

    public String getVerticalName() {
        return verticalName;
    }

    public void setVerticalName(String verticalName) {
        this.verticalName = verticalName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
