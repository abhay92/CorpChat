package server;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class Server {

	private ServerSocket server = null;
	private Socket socket = null;
	private ObjectInputStream ois = null;
	private ObjectOutputStream oos = null;
	private boolean isStarted = false;
	private Thread serverSocketThread = null; 
	private List<WriteToClients> socketList;
	
	public Server() throws IOException
	{
		ois = new ObjectInputStream(socket.getInputStream());
		socketList = new ArrayList<>();
		try {
			server = new ServerSocket(9880);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void startServer() throws IOException, ClassNotFoundException
	{
		isStarted = true;
		serverSocketThread = new Thread() {

            public synchronized void run() {
            	        
            	while(isStarted)
            	{
            		System.out.println("Server is waiting for connection");
            		
            		try {
						socket = server.accept();
						socketList.add(new WriteToClients(socket));
					} catch (IOException e) {
						e.printStackTrace();
					}
            		
            	}
            }

        };
        serverSocketThread.start();
	}
		
	public void stopServer() throws IOException
	{
		if (!isStarted)
		{
			return;
		}
		
		isStarted = false;
		if(socket != null)
		{
			socket.close();
		}
		if(server != null)
		{
			server.close();
		}
		System.out.println("Server stopped");
	}

	private void broadcastMessage(Object message) throws IOException
	{
		for(WriteToClients obj : socketList)
		{
			obj.write((String)message);
		}
	}
	
//	@Override
//	public void run() {
//		
//		while(true)
//		{
//			try 
//			{
//				broadcastMessage(ois.readObject());
//			}
//			catch (ClassNotFoundException | IOException e) 
//			{
//				e.printStackTrace();
//			}
//			
//		}
//	}
	
	public void finalize()
	{
		try {
			if(ois != null)
			{
				ois.close();
			}
			if(oos != null)
			{
			    oos.close();
			}
		} catch (IOException e) {
	//		e.printStackTrace();
		}
		
	}
	
}
