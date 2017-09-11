package bStat.CS.com.FeedObjects;

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
public class CategoryNodeDTO {

    private String nodeName;

    private String nodeMetaData;

    private String productId;

    private String description;
}
