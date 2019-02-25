package info.skrzypczak.dagmara.restfulClient;

import java.math.BigDecimal;
import java.util.List;

import jersey.repackaged.com.google.common.collect.Lists;

public class ClientApp {

	private static List<String> pairs;
	private String serviceURI;

	public ClientApp() {
		serviceURI = "http://localhost:8080/BitcoinNotify/alert"; // 192.168.8.104
		pairs = Lists.newArrayList("BTC/USD", "BIT/UK", "BIT/APAC");
	}

	public static void main(String[] args) {
		ClientApp ca = new ClientApp();
		RestfulClient client = new RestfulClient();
		client.setUri(ca.getServiceURI());

		System.out.println("Do PUT: ");
		System.out.println(client.doPut(pairs.get(0), new BigDecimal(3.7600000000002)));
		System.out.println(client.doPut(pairs.get(1), new BigDecimal(4.38364568)));
		System.out.println(client.doPut(pairs.get(2), new BigDecimal(1.34)));

		System.out.println("Do DELETE: ");
		System.out.println(client.doDelete(pairs.get(1), new BigDecimal(1098.34)));

		System.out.println("Do GET: ");
		System.out.println(client.doGet(pairs.get(0)));
	}

	public static List<String> getPairs() {
		return pairs;
	}

	public static void setPairs(List<String> pairs) {
		ClientApp.pairs = pairs;
	}

	public String getServiceURI() {
		return serviceURI;
	}

	public void setServiceURI(String serviceURI) {
		this.serviceURI = serviceURI;
	}

}
