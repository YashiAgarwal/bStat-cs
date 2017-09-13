package bStat.CS.com.FeedObjects;

import bStat.CS.com.common.enums.TradeCategory;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.*;

import javax.persistence.Column;
import java.util.Date;

/**
 * Created by Yashi Agarwal on 31-05-2017.
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
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

    private boolean listing;    // active or inactive

    private String variationParameter;

    private boolean isConcrete;

    public static void main(String[] args) throws JsonProcessingException {
        ProductDTO productDTO = new ProductDTO("Maggi", "CA1234", "CAC2345",
                "V123", "imageurl.com", "1 year" , 10.12, 15.0, TradeCategory.TRADED,
                true, "VP12", true);
        String s = new ObjectMapper().writeValueAsString(productDTO);
        System.out.println(s);
    }
}
