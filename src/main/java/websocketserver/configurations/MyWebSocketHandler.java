package websocketserver.configurations;

import org.springframework.web.socket.*;

public class MyWebSocketHandler implements WebSocketHandler {

  @Override
  public void afterConnectionEstablished(WebSocketSession session) throws Exception {
    session.sendMessage(new TextMessage("você está conectado!"));
    System.out.println("Conexão estabelecida: " + session.getId());
  }

  @Override
  public void handleMessage(WebSocketSession session, WebSocketMessage<?> message) throws Exception {
    String payload = (String) message.getPayload();
    System.out.println("Mensagem recebida: " + payload);

    session.sendMessage(new TextMessage("Mensagem do servidor"));
  }

  @Override
  public void handleTransportError(WebSocketSession session, Throwable exception) throws Exception {

  }

  @Override
  public void afterConnectionClosed(WebSocketSession session, CloseStatus closeStatus) throws Exception {

  }

  @Override
  public boolean supportsPartialMessages() {
    return false;
  }

  // ... outros métodos da interface WebSocketHandler
}
