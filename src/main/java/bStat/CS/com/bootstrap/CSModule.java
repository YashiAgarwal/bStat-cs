package bStat.CS.com.bootstrap;

import bStat.CS.com.config.CSConfiguration;
import com.codahale.metrics.MetricRegistry;
import com.google.inject.AbstractModule;
import io.dropwizard.hibernate.HibernateBundle;
import org.hibernate.SessionFactory;

import javax.validation.Validator;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by prashant170392 on 01/05/2017
 */
public class CSModule extends AbstractModule {

    private HibernateBundle<CSConfiguration> bundle;
    private CSConfiguration config;
    private Validator validator;
    private List<String> buckets;
    private final MetricRegistry metricRegistry;

    public CSModule(HibernateBundle<CSConfiguration> bundle, CSConfiguration config, Validator validator,
                    final MetricRegistry metricRegistry) {
        this.bundle = bundle;
        this.config = config;
        this.validator = validator;
        this.metricRegistry = metricRegistry;
    }

    @Override
    protected void configure() {
        bind(HibernateBundle.class).toInstance(bundle);
        bind(CSConfiguration.class).toInstance(config);
        bind(Validator.class).toInstance(validator);
        bind(SessionFactory.class).toInstance(bundle.getSessionFactory());
        buckets = new ArrayList<String>();
        buckets.add(this.config.getConfigParams().getBucket());
    }

}
