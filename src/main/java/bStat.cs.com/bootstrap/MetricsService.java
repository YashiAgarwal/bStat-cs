package bStat.cs.com.bootstrap;

import com.codahale.metrics.Counter;
import com.codahale.metrics.Meter;
import com.codahale.metrics.MetricRegistry;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by prashant170392 on 01/05/2017
 */

public class MetricsService {

    private static MetricRegistry registry;
    private static final Logger logger = LoggerFactory.getLogger(MetricsService.class);

    public static MetricRegistry getRegistry() {
        return registry;
    }

    public static void setRegistry(MetricRegistry registry) {
        MetricsService.registry = registry;
    }

    public static Counter registerCounter(String counterName) {
        logger.info("Putting metrics counter for : " + counterName);
        return registry.counter(counterName + ".Counter");
    }

    public static Meter registerMeter(String meterName) {
        logger.info("Putting metrics meter for : " + meterName);
        return registry.meter(meterName + ".Meter");
    }

    public static void registerTimer(String meterName, int count) {
        logger.info("Putting metrics timer for : " + meterName);
        registry.timer(meterName).time();
    }

    public static void publishMetrics(String metricsName, int count) {
        try {
            Counter counter = registerCounter(metricsName);
            counter.inc();
            Meter meter = registerMeter(metricsName);
            meter.mark(count);
        } catch (Exception e) {
            logger.error("Failed to push metrics", e);
        }
    }
}
