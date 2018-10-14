package helper;

import server.Server;

public class ServerHelper {

	private static Server server = null;
	
	public static Server getServer()
	{
		if (server == null)
		{
			server = new Server();
		}
		
		return server;
	}
	
}
