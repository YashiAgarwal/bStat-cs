package bStat.cs.com.utils;

import bStat.ims.com.common.exceptions.ApiException;
import bStat.ims.com.common.models.others.HttpResponse;
import bStat.ims.com.config.HttpConfiguration;
import com.google.inject.Inject;
import org.glassfish.jersey.client.ClientConfig;
import org.glassfish.jersey.client.ClientProperties;
import org.glassfish.jersey.client.JerseyClientBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Map;

public class HttpService {
    final private static Logger logger = LoggerFactory.getLogger(HttpService.class);
    private static Client httpClient = null;
    private static String ENCODING = "UTF-8";

    @Inject
    private HttpConfiguration httpConfiguration;

    @Inject
    public HttpService(HttpConfiguration httpConfiguration) {
        this.httpConfiguration = httpConfiguration;
//        GuiceInjector.getInjector().injectMembers(this);
        init();
    }

    public void init() {
        ClientConfig clientConfig = new ClientConfig();
        clientConfig.property(ClientProperties.CONNECT_TIMEOUT, httpConfiguration.getConnectionTimeout());
        clientConfig.property(ClientProperties.READ_TIMEOUT, httpConfiguration.getReadTimeout());
        httpClient = JerseyClientBuilder.createClient(clientConfig);
    }

    public Response executeGet(String resource, Map<String, String> urlParams, Map<String, String> headers) {
//        logger.info("Calling HTTP Service");
//        logger.info("Method : GET");
//        logger.info("Url : " + resource);
        resource = setupQueryUrl(resource, urlParams);
        WebTarget webTarget = httpClient.target(resource);
        Invocation.Builder request = webTarget.request(MediaType.APPLICATION_JSON_TYPE);

        if (headers != null) {
            for (Map.Entry<String, String> pair : headers.entrySet()) {
                request = request.header(pair.getKey(), pair.getValue());
            }
        }
        Response response = request.get();
        return response;
    }

    public HttpResponse executePost(String resource, String body) throws ApiException {
//        logger.info("Calling HTTP Service");
//        logger.info("Request: ");
//        logger.info("Method : POST");
//        logger.info("Url : " + resource);
//        logger.info("Body : " + body);
        WebTarget webTarget = httpClient.target(resource);
        Invocation.Builder request = webTarget.request(MediaType.APPLICATION_JSON_TYPE);
        Response response = request.post(Entity.entity(body, MediaType.APPLICATION_JSON_TYPE));
//        logger.info("Response: ");
//        logger.info("Code: {}", response.getStatus());
        String responseBody = response.readEntity(String.class);
//        logger.info("Body: {}", responseBody);
        return new HttpResponse(response.getStatus(), responseBody, Utilities.getMap(response.getStringHeaders()));
    }

    public HttpResponse executePost(String resource, String body, Map<String, String> headers) {
//        logger.info("Calling HTTP Service");
//        logger.info("Request: ");
//        logger.info("Method : POST");
        logger.info("Url : " + resource);
//        logger.info("Body : " + body);

        WebTarget webTarget = httpClient.target(resource);
        Invocation.Builder request = webTarget.request(MediaType.APPLICATION_JSON_TYPE);
        if (headers != null && !headers.isEmpty()) {
            for (Map.Entry<String, String> pair : headers.entrySet()) {
                request = request.header(pair.getKey(), pair.getValue());
            }
        }
        Response response = request.post(Entity.entity(body, MediaType.APPLICATION_JSON_TYPE));
//        logger.info("Response: ");
//        logger.info("Code: {}", response.getStatus());
        String responseBody = response.readEntity(String.class);
//        logger.info("Body: {}", responseBody);
        return new HttpResponse(response.getStatus(), responseBody, Utilities.getMap(response.getStringHeaders()));
    }

    public HttpResponse executeDelete(String resource,String pathParam ,Map<String, String> headers) {
//        logger.info("Calling HTTP Service");
//        logger.info("Request: ");
//        logger.info("Method : DELETE");
//        logger.info("Url : " + resource);

        WebTarget webTarget = httpClient.target(resource).path(pathParam);
        Invocation.Builder request = webTarget.request(MediaType.APPLICATION_JSON_TYPE);
        if (headers != null && !headers.isEmpty()) {
            for (Map.Entry<String, String> pair : headers.entrySet()) {
                request = request.header(pair.getKey(), pair.getValue());
            }
        }
        Response response = request.delete();
//        logger.info("Response: ");
//        logger.info("Code: {}", response.getStatus());
        String responseBody = response.readEntity(String.class);
//        logger.info("Body: {}", responseBody);
        return new HttpResponse(response.getStatus(), responseBody, Utilities.getMap(response.getStringHeaders()));
    }

    public static String urlGenerator(String host, String env, int port, String appender) {
        return "http://" + host + env + ":" + port + "/" + appender;
    }

    private String setupQueryUrl(String path, Map<String, String> givenUrlParams) {

        String url = path;
        try {
            if (path != null && givenUrlParams != null) {
                for (Map.Entry<String, String> entry : givenUrlParams.entrySet()) {
                    url = addQueryParam(url, entry.getKey(), URLEncoder.encode(entry.getValue(), "UTF-8"));
                }
            }
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException(e.getCause());
        }
        return url;
    }

    private String addQueryParam(String url, String param, String value) {
        return url.indexOf("?") > 0 ? url + "&" + param + "=" + value : url + "?" + param + "=" + value;
    }
}
