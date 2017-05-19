package bStat.CS.com.bootstrap;

import bStat.CS.com.common.utils.GuiceInjector;
import io.dropwizard.lifecycle.Managed;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by prashant170392 on 01/05/2017
 */
public class CSManagedService implements Managed {

    private static final Logger logger = LoggerFactory.getLogger(CSManagedService.class);

    public CSManagedService() {
        GuiceInjector.getInjector().injectMembers(this);
    }

    public void start() throws Exception {
        logger.info("<<<<<<<<<<============= Starting IMSApplication ===========>>>>>>>>>>");
        logger.info("Initializing all the prerequisites");
    }

    public void stop() throws Exception {
        logger.info("<<<<<<<<<<============= Stopping IMSApplication Gracefully ===========>>>>>>>>>>");
    }
}
