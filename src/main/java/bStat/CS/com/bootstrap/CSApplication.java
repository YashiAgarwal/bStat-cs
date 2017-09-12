package bStat.CS.com.bootstrap;

import bStat.CS.com.common.models.tables.*;
import bStat.CS.com.common.utils.GuiceInjector;
import bStat.CS.com.config.CSConfiguration;
import bStat.CS.com.resources.DataResource;
import com.codahale.metrics.JmxReporter;
import com.codahale.metrics.MetricRegistry;
import com.google.inject.Guice;
import com.google.inject.Injector;
import io.dropwizard.Application;
import io.dropwizard.db.DataSourceFactory;
import io.dropwizard.hibernate.HibernateBundle;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;
import io.federecio.dropwizard.swagger.SwaggerBundle;
import io.federecio.dropwizard.swagger.SwaggerBundleConfiguration;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.validation.Validator;

/**
 * Created by prashant170392 on 01/05/2017
 */
public class CSApplication extends Application<CSConfiguration> {

    private static final Logger logger = LoggerFactory.getLogger(CSApplication.class);

    public static void main(String[] args) throws Exception {
        new CSApplication().run(args);
    }

    private final HibernateBundle<CSConfiguration> hibernate = new HibernateBundle<CSConfiguration>(CategoryNodes.class,
            Products.class, ProductVerticals.class, ProductsHierarchy.class, ServiceItems.class, ProductVariations.class,
            ProductAttributes.class) {
        @Override
        public DataSourceFactory getDataSourceFactory(CSConfiguration csConfiguration) {
            logger.info("Configuring database ...");
            return csConfiguration.getDatabase();
        }
    };


    @Override
    public void initialize(Bootstrap<CSConfiguration> bootstrap) {
        bootstrap.addBundle(hibernate);


        bootstrap.addBundle(new SwaggerBundle<CSConfiguration>() {
            @Override
            public SwaggerBundleConfiguration getSwaggerBundleConfiguration(CSConfiguration configuration) {
                return configuration.getSwagger();
            }
        });
    }

    @Override
    public void run(CSConfiguration config, Environment environment) throws Exception {
        logger.info("Starting Up the bStat CS Application ... ");
        Validator validator = environment.getValidator();

        // ---------- register metrics ---------
        MetricRegistry metricRegistry = environment.metrics();
        MetricsService.setRegistry(metricRegistry);
        JmxReporter.forRegistry(environment.metrics()).build().start();

        Injector injector = Guice.createInjector(new CSModule(hibernate, config, validator, metricRegistry));
        GuiceInjector.assignInjector(injector);

        //------- registering app resources -----------
        environment.jersey().register(injector.getInstance(DataResource.class));

        environment.lifecycle().manage(injector.getInstance(CSManagedService.class));
    }
}