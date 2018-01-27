package org.nraov.vertx.jersey.resources;

import io.vertx.core.Vertx;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.container.AsyncResponse;
import javax.ws.rs.container.Suspended;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;

@Path("/test1")
@Produces(MediaType.APPLICATION_JSON)
public class Test1Resource {

	@GET
	@Path("id")
	public String getId() {
		return "Id from Test1Resource";
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
