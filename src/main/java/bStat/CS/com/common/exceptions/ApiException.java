package bStat.CS.com.common.exceptions;

import javax.ws.rs.core.Response;

/**
 * Created by prashant170392 on 01/05/2017
 */
public class ApiException extends Exception {
    private Response.Status status;
    private ResponseErrorMsg reason;
    private String message;

    public ApiException(Response.Status status, String message) {
        this.status = status;
        this.reason = ResponseErrorMsg.RUNTIME_ERROR;
        this.message = message;
    }

    public ApiException(Response.Status status, ResponseErrorMsg reason, String message) {
        this.status = status;
        this.reason = reason;
        this.message = message;
    }

    public Response.Status getStatus() {
        return status;
    }

    public void setStatus(Response.Status status) {
        this.status = status;
    }

    public ResponseErrorMsg getReason() {
        return reason;
    }

    public void setReason(ResponseErrorMsg reason) {
        this.reason = reason;
    }

    @Override
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
