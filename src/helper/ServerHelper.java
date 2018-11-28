package helper;

import java.io.IOException;

import server.Server;

public class ServerHelper {

	
	private static Server server = null;
	
	public static Server getServer()
	{
		if (server == null)
		{
			try {
				server = new Server();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		return server;
	}
}
