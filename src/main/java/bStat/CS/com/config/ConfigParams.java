package bStat.CS.com.config;

/**
 * Created with IntelliJ IDEA.
 * User: akash.jain
 * Date: 28/08/15
 * Time: 11:01 PM
 * To change this template use File | Settings | File Templates.
 */

public class ConfigParams {

    private String protocol;
    private String server;
    private Integer port;
    private Integer timeOut;
    private Integer apiVersion;
    private String bucket;

    public String getProtocol() {
        return protocol;
    }

    public void setProtocol(String protocol) {
        this.protocol = protocol;
    }

    public String getServer() {
        return server;
    }

    public void setServer(String server) {
        this.server = server;
    }

    public Integer getPort() {
        return port;
    }

    public void setPort(Integer port) {
        this.port = port;
    }

    public Integer getTimeOut() {
        return timeOut;
    }

    public void setTimeOut(Integer timeOut) {
        this.timeOut = timeOut;
    }

    public Integer getApiVersion() {
        return apiVersion;
    }

    public void setApiVersion(Integer apiVersion) {
        this.apiVersion = apiVersion;
    }

    public String getBucket() {
        return bucket;
    }

    public void setBucket(String bucket) {
        this.bucket = bucket;
    }

    public ConfigParams(String protocol, String server, Integer port, Integer timeOut, Integer apiVersion, String bucket) {
        this.protocol = protocol;
        this.server = server;
        this.port = port;
        this.timeOut = timeOut;
        this.apiVersion = apiVersion;
        this.bucket = bucket;
    }

    public ConfigParams() {
    }
}

