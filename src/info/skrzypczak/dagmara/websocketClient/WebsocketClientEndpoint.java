package info.skrzypczak.dagmara.websocketClient;

import java.io.IOException;
import java.net.URI;

import javax.websocket.ClientEndpoint;
import javax.websocket.CloseReason;
import javax.websocket.ContainerProvider;
import javax.websocket.DeploymentException;
import javax.websocket.OnClose;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.WebSocketContainer;

@ClientEndpoint
public class WebsocketClientEndpoint {

	Session userSession;
	private MessageHandler messageHandler;

	public WebsocketClientEndpoint(URI endpointURI) throws DeploymentException, IOException {
		WebSocketContainer container = ContainerProvider.getWebSocketContainer();
		container.connectToServer(this, endpointURI);
	}

	@OnOpen
	public void onOpen(Session userSession) {
		this.userSession = userSession;
	}

	@OnClose
	public void onClose(Session userSession, CloseReason reason) {
		this.userSession = null;
	}

	@OnMessage
	public void onMessage(String message) {
		if (this.messageHandler == null) {
			System.out.println(message);
			return;
		}
		this.messageHandler.handleMessage(message);
	}

	public void addMessageHandler(MessageHandler msgHandler) {
		this.messageHandler = msgHandler;
	}

	public void sendMessage(String message) {
		this.userSession.getAsyncRemote().sendText(message);
	}

	public static interface MessageHandler {
		public void handleMessage(String message);
	}
}