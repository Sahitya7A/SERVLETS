import javax.websocket.EndpointConfig;
import javax.websocket.OnClose;
import javax.websocket.OnError;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;

@ServerEndpoint("/SEP")
public class ServerEP {
	
	@OnOpen//telling to JVM it is annotation
	public void handleOpen(Session use,EndpointConfig config)
	{
		
	}
	@OnMessage
	public void handleMessage(String Message,Session use)
	{
		try
		{
			use.getBasicRemote().sendText(Message);
		}
		catch(Exception e) {}
	}
	@OnClose
	public void handleClose()
	{
		
	}
	@OnError
	public void handleError(Throwable t)
	{
		
	}

}
