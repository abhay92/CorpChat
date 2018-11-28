package client;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

public class Client implements Runnable{
	
	private Socket socket = null;
	private ObjectInputStream ois = null;
	private ObjectOutputStream oos = null;
	
	public Client()
	{
		InetAddress host;
		try {
			host = InetAddress.getLocalHost();
			socket = new Socket(host,9880);
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		initiaizeClient();
	}
	
	private void initiaizeClient() {
		try {
			oos = new ObjectOutputStream(socket.getOutputStream());
			ois = new ObjectInputStream(socket.getInputStream());
		} catch (IOException e) {
			e.printStackTrace();
		}
		Thread read = new Thread(this);
		read.start();
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
			ois.close();
			oos.close();
			socket.close();
	}

	@Override
	public void run() {
		while(true)
		{
			try {
				String message = (String)ois.readObject();
				System.out.println("Message recieved " + message);
			} catch (IOException e) {
				e.printStackTrace();
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
		}
	}
			


}
