package bStat.CS.com.utils;

import org.apache.commons.lang3.RandomStringUtils;

import javax.inject.Singleton;
import javax.ws.rs.core.MultivaluedMap;
import java.util.*;

/**
 * Created by chaitra.kr on 22/03/16.
 */
@Singleton
public class Utilities {

    public static String getRandomString() {
        return UUID.randomUUID().toString().replaceAll("-", "");
    }

    public static String generateRandomUID(String prefix, int length) {
        String uid = RandomStringUtils.randomAlphanumeric(length);
        return prefix+uid;
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

}
