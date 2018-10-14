package server;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Server implements Runnable{

	private ServerSocket server = null;
	private Socket socket = null;
	private ObjectInputStream ois = null;
	private ObjectOutputStream oos = null;
	private boolean isStarted = true;
	private Thread readThread = null; 
	
	public Server()
	{
		try {
			server = new ServerSocket(9877);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void startServer() throws IOException, ClassNotFoundException
	{
		while(isStarted)
		{
			System.out.println("Server is waiting for connection");
			socket = server.accept();
			System.out.println("Connection accepted");
			
			readThread = new Thread();
			readThread.start();
		}
	}
		
	public void stopServer() throws IOException
	{
		isStarted = false;
		ois.close();
		oos.close();
		socket.close();
		server.close();
		System.out.println("Server stopped");
	}

	private void broadcastMessage(Object message) throws IOException
	{
		oos = new ObjectOutputStream(socket.getOutputStream());
		oos.writeObject(message);
	}
	
	@Override
	public void run() {
		
		while(true)
		{
			try 
			{
				ois = new ObjectInputStream(socket.getInputStream());
				broadcastMessage(ois.readObject());
			}
			catch (ClassNotFoundException | IOException e) 
			{
				e.printStackTrace();
			}
			
		}
	} 
}
