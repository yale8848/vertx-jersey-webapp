package org.nraov.vertx.jersey.resources;

import io.vertx.core.Vertx;
import io.vertx.core.http.HttpServerRequest;
import io.vertx.core.http.HttpServerResponse;
import io.vertx.core.streams.ReadStream;

import javax.net.ssl.SSLSession;
import javax.ws.rs.*;
import javax.ws.rs.container.AsyncResponse;
import javax.ws.rs.container.Suspended;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.NewCookie;
import javax.ws.rs.core.Response;
import javax.xml.bind.annotation.XmlRootElement;

@Path("/test1")
@Produces(MediaType.APPLICATION_JSON)
public class Test1Resource {

	@GET
	@Path("id")
	public Response getId(@Context Vertx vertx,
						  @Context HttpServerRequest vertxRequest,
						  @Context HttpServerResponse vertxResponse,
						  @Context ReadStream<HttpServerRequest> vertxStream,
						  @CookieParam("name") String value) {
		SSLSession sslSession = vertxRequest.sslSession();
		MyObject o = new MyObject();
		o.setName("Andy");
		return Response.ok(o)
				.cookie(new NewCookie("name", "Helloworld!"))
				.build();
		//return "Id from Test1Resource "+id;
	}
	@GET
	@Path("json")
	@Produces(MediaType.APPLICATION_JSON)
	public MyObject getJson() {
		MyObject o = new MyObject();
		o.setName("Andy");
		return o;
	}

	@GET
	@Path("xml")
	@Produces(MediaType.APPLICATION_XML)
	public MyObject xml() {
		MyObject o = new MyObject();
		o.setName("Andy");
		return o;
	}

	@GET
	@Path("async")
	@Produces(MediaType.APPLICATION_JSON)
	public void getJsonAsync(@Suspended final AsyncResponse asyncResponse, @Context Vertx vertx) {
		vertx.runOnContext(aVoid -> {
			MyObject o = new MyObject();
			o.setName("Andy");
			asyncResponse.resume(o);
		});
	}
	@XmlRootElement
	public static class MyObject {

		private String name;

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}
	}
}
