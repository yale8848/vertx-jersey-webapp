package org.nraov.vertx.jersey.proccesor;

import com.englishtown.vertx.jersey.inject.VertxRequestProcessor;
import io.vertx.core.Handler;
import io.vertx.core.http.HttpServerRequest;
import org.glassfish.jersey.server.ContainerRequest;

/**
 * Yale
 *
 * @create 2018-01-31 14:48
 **/
public class ExampleVertxRequestProcessor implements VertxRequestProcessor {

    /**
     * Provide additional async request processing
     *
     * @param vertxRequest  the vert.x http server request
     * @param jerseyRequest the jersey container request
     * @param done          the done async callback handler
     */
    @Override
    public void process(HttpServerRequest vertxRequest, ContainerRequest jerseyRequest, Handler<Void> done) {
        jerseyRequest.setProperty("custom.property", "Hello!");
        done.handle(null);
    }

}