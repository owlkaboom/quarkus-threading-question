package org.acme;

import io.quarkus.runtime.StartupEvent;
import io.vertx.core.eventbus.EventBus;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.event.Observes;
import javax.inject.Inject;

@ApplicationScoped
public class BusProducer {

    private static final Logger LOGGER = LoggerFactory.getLogger(BusProducer.class);

    @Inject
    EventBus eb;

    void onStart(@Observes StartupEvent ev) {
        LOGGER.info("Started producing to eventbus");
        for(int i = 0; i < 500; i++){
            eb.send("my-bus","Hello-" + i);
        }
        LOGGER.info("Finished producing to eventbus");
    }
}
