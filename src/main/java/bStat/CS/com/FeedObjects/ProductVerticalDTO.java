package bStat.CS.com.FeedObjects;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;

/**
 * Created by Yashi Agarwal on 05-06-2017.
 */
@Getter
@Setter
@AllArgsConstructor
public class ProductVerticalDTO {
    private String verticalId;

    private long startCategoryNode;

    private String verticalName;

    private String description;

    private String groupId;
}
