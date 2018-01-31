package org.nraov.vertx.jersey.resources;

import io.vertx.core.Vertx;
import io.vertx.core.http.HttpServerRequest;
import io.vertx.core.http.HttpServerResponse;
import io.vertx.core.streams.ReadStream;
import org.glassfish.jersey.server.ContainerRequest;
import org.glassfish.jersey.server.mvc.Viewable;

import javax.net.ssl.SSLSession;
import javax.ws.rs.*;
import javax.ws.rs.container.AsyncResponse;
import javax.ws.rs.container.Suspended;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.NewCookie;
import javax.ws.rs.core.Response;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Path("/test1")
@Produces(MediaType.APPLICATION_JSON)
public class Test1Resource {

	@GET
	@Path("hello")
	@Produces(MediaType.TEXT_HTML)
	public Viewable getHello(@CookieParam("name") String name) {
		final Map<String, Object> map = new HashMap<String, Object>();
		map.put("user", "Pavel");
		final List<String> list = new ArrayList<String>();
		list.add("item1");
		list.add("item2");
		list.add("item3");
		map.put("items", list);

		return new Viewable("/templates/hello.ftl", map);
	}
	@GET
	@Path("hello1")
	@Produces(MediaType.TEXT_HTML)
	public String getHello1() {
		return "<html><body>aaa</body></html>";
	}
	@GET
	@Path("id")
	public void getId(@Context Vertx vertx,
						  @Suspended final AsyncResponse response,
						  @Context ContainerRequest jerseyRequest,
						  @Context HttpServerRequest vertxRequest,
						  @CookieParam("name") String value) {
		String helo = (String) jerseyRequest.getProperty("custom.property");
		MyObject o = new MyObject();
		o.setName("Andy");

		response.resume(o);

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

	@GET
	@Path("async1")
	@Produces(MediaType.TEXT_HTML)
	public void getJsonAsync1(@Suspended final AsyncResponse asyncResponse, @Context Vertx vertx) {
		vertx.runOnContext(aVoid -> {
			final Map<String, Object> map = new HashMap<String, Object>();
			map.put("user", "Pavel");
			final List<String> list = new ArrayList<String>();
			list.add("item1");
			list.add("item2");
			list.add("item5");
			map.put("items", list);
			Viewable v= new Viewable("/templates/hello.ftl", map);
			asyncResponse.resume(v);
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
