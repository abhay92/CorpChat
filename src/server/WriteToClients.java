package server;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class WriteToClients {
	
	private ObjectOutputStream oos = null;
	private Socket socket;
  
	public WriteToClients(Socket socket) {
		this.socket = socket;
		try {
			oos = new ObjectOutputStream(socket.getOutputStream());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void write(String msg){
		
		try {
			oos.writeObject(msg);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}  
	
	public void close() throws ClassNotFoundException,IOException
	{
			oos.close();
			socket.close();
	}
}
