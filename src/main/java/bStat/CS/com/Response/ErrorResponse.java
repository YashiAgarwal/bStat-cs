package bStat.CS.com.Response;

/**
 * Created by prashant.agarwal on 06/05/16.
 */
public class ErrorResponse {

    private int code;
    private String status;
    private String error;

    public ErrorResponse() {
    }

    public ErrorResponse(int code, String status, String error) {
        this.code = code;
        this.status = status;
        this.error = error;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }
}
