package info.skrzypczak.dagmara.restfulClient;

import java.math.BigDecimal;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;

public class RestfulClient {

	private Client client = ClientBuilder.newClient();
	private String uri;

	public String doPut(String pair, BigDecimal limit) {
		WebTarget target = client.target(uri);
		Alert alert = new Alert(pair, limit);
		String result = target.request().put(Entity.entity(alert, MediaType.APPLICATION_JSON)).toString();
		return result;
	}

	public String doGet(String pair) {
		WebTarget target = client.target(uri);
		Invocation.Builder builder = target.queryParam("pair", pair).request(MediaType.APPLICATION_JSON);
		String result = builder.get().toString();
		String resultJson = builder.get(String.class);
		return result + " JSON: " + resultJson;
	}

	public String doDelete(String pair, BigDecimal limit) {
		WebTarget target = client.target(uri);
		Invocation.Builder builder = target.queryParam("pair", pair).request(MediaType.APPLICATION_JSON);
		String result = builder.delete().toString();
		String resultJson = builder.delete(String.class);
		return result + " JSON: " + resultJson;
	}

	public void setUri(String uri) {
		this.uri = uri;
	}

}
