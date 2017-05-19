package bStat.cs.com.utils;

import javax.ws.rs.core.MultivaluedMap;
import java.util.*;

/**
 * Created by chaitra.kr on 22/03/16.
 */
public class Utilities {

    public static String getRandomString() {
        return UUID.randomUUID().toString().replaceAll("-", "");
    }

    public static String getNDRClientForCronus() {
        return "NDR";
    }

    public static String getUID() {
        return UUID.randomUUID().toString().replaceAll("-", "");
    }

    public static String getRequestId() {
        return "NDR-" + UUID.randomUUID().toString().replaceAll("-", "");

    }

    public static List<String> retryDisposition(){
        return Arrays.asList("CUSTOMER_REQUESTED_CALLBACK","Not Concluded","Customer Requested Callback");
    }


    public static Map<String, String> getMap(MultivaluedMap<String, String> headers) {
        Map<String, String> parameters = new HashMap<String, String>();
        Iterator<String> it = headers.keySet().iterator();
        while (it.hasNext()) {
            String theKey = it.next();
            parameters.put(theKey, headers.getFirst(theKey));
        }
        return parameters;
    }

    public static String getCampaign() {
        return "234189926";
    }

}
