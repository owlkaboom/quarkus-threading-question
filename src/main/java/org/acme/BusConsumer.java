package org.acme;

import io.quarkus.vertx.ConsumeEvent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class BusConsumer {
    private static final Logger LOGGER = LoggerFactory.getLogger(BusProducer.class);

    @ConsumeEvent(value = "my-bus", blocking = true)
    void consumeEvent(String message){
        LOGGER.info("Started Consuming bus message={}", message);

        try {
            Thread.sleep(5000L);
        } catch (InterruptedException e){
            e.printStackTrace();
        }
        LOGGER.info("Finished Consuming bus message={}", message);
    }
}
