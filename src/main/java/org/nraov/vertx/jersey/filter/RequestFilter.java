package org.nraov.vertx.jersey.filter;

import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerRequestFilter;
import javax.ws.rs.core.UriInfo;
import java.io.IOException;

/**
 * Yale
 *
 * @create 2018-01-31 14:22
 **/
public class RequestFilter implements ContainerRequestFilter {
    @Override
    public void filter(ContainerRequestContext containerRequestContext) throws IOException {

       UriInfo uriInfo =  containerRequestContext.getUriInfo();
       if (uriInfo!=null){
           uriInfo.getAbsolutePath();
        }
        containerRequestContext.setProperty("custom.property","aab");
    }
}
