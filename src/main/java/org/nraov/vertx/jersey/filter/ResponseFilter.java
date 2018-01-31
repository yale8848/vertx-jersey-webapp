package org.nraov.vertx.jersey.filter;

import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerResponseContext;
import javax.ws.rs.container.ContainerResponseFilter;
import java.io.IOException;
import java.lang.annotation.Annotation;

/**
 * Yale
 *
 * @create 2018-01-31 14:22
 **/
public class ResponseFilter implements ContainerResponseFilter {
    @Override
    public void filter(ContainerRequestContext containerRequestContext, ContainerResponseContext containerResponseContext) throws IOException {
        Annotation[] annotations =  containerResponseContext.getEntityAnnotations();
        containerResponseContext.getHeaders().add("aaa", "bbb");

    }
}
