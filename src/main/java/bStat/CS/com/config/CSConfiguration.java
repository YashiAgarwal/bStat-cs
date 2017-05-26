package bStat.CS.com.config;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.dropwizard.Configuration;
import io.dropwizard.db.DataSourceFactory;
import io.federecio.dropwizard.swagger.SwaggerBundleConfiguration;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

/**
 * Created by prashant170392 on 01/05/2017
 */
public class CSConfiguration extends Configuration {

    @Valid
    @JsonProperty("database")
    private DataSourceFactory database;

    @JsonProperty("swagger")
    public SwaggerBundleConfiguration swagger;

    @JsonProperty
    public DataSourceFactory getDatabase() {
        return database;
    }

    @JsonProperty
    @NotNull
    private ConfigParams configParams;

    public ConfigParams getConfigParams() {
        return configParams;
    }

    public SwaggerBundleConfiguration getSwagger() {
        return swagger;
    }
}
