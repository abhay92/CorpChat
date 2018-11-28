package gui;

import java.awt.BorderLayout;
import java.awt.GridBagConstraints;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import beans.UserMasterBean;
import helper.ServerHelper;
import server.Server;

public class AdminPage extends JFrame implements ActionListener {
	
	private final String pageTitle = "Admin Page";
	private GridBagConstraints gridConstraint;
	private JPanel buttonPanel;
	private JButton startServerButton, stopServerButton, chatButton;
	private UserPage chatWindow;
  	private UserMasterBean userData;
  	
	public AdminPage(UserMasterBean userData)
	{
		initFrame();
		initComponents();
		this.userData = userData;
	}

	private void initFrame()
	{
		try
		{
			setSize(1000,600);
			setTitle(pageTitle);
			setResizable(false);
			setLayout(new GridLayout(2,1));
			addWindowListener(new java.awt.event.WindowAdapter() {
			    @Override
			    public void windowClosing(java.awt.event.WindowEvent windowEvent) {
			    	try {
						ServerHelper.getServer().stopServer();
					} 
					catch (IOException e1) 
					{
						e1.printStackTrace();
					}
			    }
			});	 
		}
		catch(Exception e)
		{
			JOptionPane.showMessageDialog(null, e.getMessage());
		}
	}
		
	private void initComponents()
	{
		   buttonPanel = new JPanel(new GridLayout(3,1));
//		   gridConstraint = new GridBagConstraints();
		   startServerButton = new JButton("Start Server");
//		   gridConstraint.gridx = 5;
//		   gridConstraint.gridy = 3;
		   buttonPanel.add(startServerButton, gridConstraint);
		   
		   stopServerButton = new JButton("Stop Server");
//		   gridConstraint.gridx = 0;
//		   gridConstraint.gridy = 0;
		   buttonPanel.add(stopServerButton, gridConstraint);		
		   
		   chatButton = new JButton("Chat");
//		   gridConstraint.gridx = 0;
//		   gridConstraint.gridy = 0;
		   buttonPanel.add(chatButton, gridConstraint);	
		   
		   add(buttonPanel,BorderLayout.CENTER);
		   
		   startServerButton.addActionListener(this);
		   stopServerButton.addActionListener(this);
		   chatButton.addActionListener(this);
		  
	 }

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Object source = e.getSource();
		
		if(source.equals(startServerButton))
		{
			try {
				ServerHelper.getServer().startServer();
			} 
			catch (ClassNotFoundException | IOException e1) 
			{
				e1.printStackTrace();
			}
		}
		else if (source.equals(stopServerButton))
		{
			try {
				ServerHelper.getServer().stopServer();
			} 
			catch (IOException e1) 
			{
				e1.printStackTrace();
			}
		}
		else
		{
			getChatWindow().setVisible(true);
		}
	}
	
	private UserMasterBean getUserData(){
		return userData;
	}
	
	private UserPage getChatWindow()
	{
		if(chatWindow == null)
		{
			chatWindow = new UserPage(getUserData()); 
		}
		
		return chatWindow;
	}
	
}
