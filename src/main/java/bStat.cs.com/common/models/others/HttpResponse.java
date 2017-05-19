package bStat.cs.com.common.models.others;

import java.util.Map;

/**
 * Created by sanjay.rajput on 21/05/15.
 */

public class HttpResponse {

    private int code;
    private String body;
    private Map<String, String> headers;

    public HttpResponse(int code, String body, Map<String, String> headers) {
        this.code = code;
        this.body = body;
        this.headers = headers;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public Map<String, String> getHeaders() {
        return headers;
    }

    public void setHeaders(Map<String, String> headers) {
        this.headers = headers;
    }
}
