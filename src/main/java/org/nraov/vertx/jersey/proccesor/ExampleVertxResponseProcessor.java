package org.nraov.vertx.jersey.proccesor;

import com.englishtown.vertx.jersey.inject.VertxResponseProcessor;
import io.vertx.core.http.HttpServerResponse;
import org.glassfish.jersey.server.ContainerResponse;

/**
 * Yale
 *
 * @create 2018-01-31 15:11
 **/
public class ExampleVertxResponseProcessor implements VertxResponseProcessor {
    /**
     * <p>
     * Provide additional response processing
     * </p>
     * Note: This method is synchronous and must not block!
     *
     * @param vertxResponse  the vert.x http server response
     * @param jerseyResponse the jersey container response
     */
    @Override
    public void process(HttpServerResponse vertxResponse, ContainerResponse jerseyResponse) {
        vertxResponse.headers().add("x-example-response-processor", "ok");
        vertxResponse.write("ddd").end();
    }
}
