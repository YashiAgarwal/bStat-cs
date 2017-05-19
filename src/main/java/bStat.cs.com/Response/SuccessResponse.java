package bStat.cs.com.Response;

/**
 * Created by prashant.agarwal on 13/05/17.
 */
public class SuccessResponse {
    int status;
    String message;
    Object value;

    public SuccessResponse() {
    }

    public SuccessResponse(int status, String message) {
        this.status = status;
        this.message = message;
    }

    public SuccessResponse(int status, String message, Object value) {
        this.status = status;
        this.message = message;
        this.value = value;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getValue() {
        return value;
    }

    public void setValue(Object value) {
        this.value = value;
    }
}
