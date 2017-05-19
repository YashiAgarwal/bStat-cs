package bStat.cs.com.config;

/**
 * Created by prashant170392 on 01/05/2017
 */
public class HttpConfiguration {
    int connectionTimeout;
    int readTimeout;

    public HttpConfiguration() {

    }

    public HttpConfiguration(int connectionTimeout, int readTimeout) {
        this.connectionTimeout = connectionTimeout;
        this.readTimeout = readTimeout;
    }

    public int getConnectionTimeout() {
        return connectionTimeout;
    }

    public void setConnectionTimeout(int connectionTimeout) {
        this.connectionTimeout = connectionTimeout;
    }

    public int getReadTimeout() {
        return readTimeout;
    }

    public void setReadTimeout(int readTimeout) {
        this.readTimeout = readTimeout;
    }
}
