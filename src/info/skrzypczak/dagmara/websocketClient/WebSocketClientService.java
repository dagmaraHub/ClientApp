package info.skrzypczak.dagmara.websocketClient;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

import javax.websocket.DeploymentException;

public class WebSocketClientService {

	public URI serviceURI;

	public WebSocketClientService() throws URISyntaxException {
		serviceURI = new URI("ws://localhost:8080/BitcoinNotify/alerts/Dagusia"); // 192.168.8.104
	}

	public static void main(String[] args)
			throws InterruptedException, DeploymentException, IOException, URISyntaxException {
		WebSocketClientService wcs = new WebSocketClientService();
		WebsocketClientEndpoint clientEndPoint = new WebsocketClientEndpoint(wcs.getServiceURI());
		clientEndPoint.addMessageHandler(new WebsocketClientEndpoint.MessageHandler() {
			public void handleMessage(String message) {
				System.out.println(message);
			}
		});
		clientEndPoint.sendMessage("Please subscribe me");
		Thread.sleep(500000);
	}

	public URI getServiceURI() {
		return serviceURI;
	}

	public void setServiceURI(URI serviceURI) {
		this.serviceURI = serviceURI;
	}
}
