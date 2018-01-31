package org.nraov.vertx.jersey.binder;

import com.englishtown.vertx.jersey.inject.VertxRequestProcessor;
import com.englishtown.vertx.jersey.inject.VertxResponseProcessor;
import org.glassfish.hk2.utilities.binding.AbstractBinder;
import org.nraov.vertx.jersey.filter.RequestFilter;
import org.nraov.vertx.jersey.filter.ResponseFilter;
import org.nraov.vertx.jersey.proccesor.ExampleVertxRequestProcessor;
import org.nraov.vertx.jersey.proccesor.ExampleVertxResponseProcessor;

import javax.ws.rs.container.ContainerRequestFilter;
import javax.ws.rs.container.ContainerResponseFilter;

/**
 * Yale
 *
 * @create 2018-01-31 14:26
 **/
public class FilterBinder extends AbstractBinder {
    /**
     * Implement to provide binding definitions using the exposed binding
     * methods.
     */
    @Override
    protected void configure() {

        bind(ExampleVertxRequestProcessor.class).to(VertxRequestProcessor.class);
        bind(ExampleVertxResponseProcessor.class).to(VertxResponseProcessor.class);
       // bind(RequestFilter.class).to(ContainerRequestFilter.class);
       // bind(ResponseFilter.class).to(ContainerResponseFilter.class);

    }
}