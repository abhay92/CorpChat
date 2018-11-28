package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import beans.UserMasterBean;
import client.Client;

public class UserPage extends JFrame {
	
	private final String pageTitle = "Chat";
	private JLabel welcomeLbl;
	private UserMasterBean uname;
	private JPanel welcomePanel, chatBoxPanel, buttonPanel;
	private UserMasterBean userData;
	private JTextField chatBoxTf;
	private JTextArea chatAreaTb, onlineUserTb;
	private JButton sendButton;
	private Client client;
	
	public UserPage(UserMasterBean userData)
	{
		this.userData = userData;
		initFrame();
		initComponents();
		client = new Client();
	}

    private void initFrame()
	{
		try
		{
			setTitle(pageTitle);
			setSize(1000,600);
			setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);	 
		}
		catch(Exception e)
		{
			JOptionPane.showMessageDialog(null, e.getMessage());
		}
	}

	private void initComponents()
	{
		welcomeLbl = new JLabel();
		welcomeLbl.setText("Welcome " + getUserData().getUserName());
		welcomeLbl.setFont(new Font("Courier New", Font.BOLD, 100));
		welcomeLbl.setForeground(Color.BLUE);
		   
		welcomePanel = new JPanel(new GridLayout(1,2));
		welcomePanel.add(welcomeLbl);
		add(welcomePanel,BorderLayout.NORTH);
		
		chatAreaTb = new JTextArea();
		onlineUserTb = new JTextArea();
		chatBoxPanel = new JPanel(new GridLayout(1,2));
		chatBoxPanel.add(chatAreaTb);
		chatBoxPanel.add(onlineUserTb);
		add(chatBoxPanel,BorderLayout.CENTER);
		
		chatBoxTf = new JTextField("Enter text");
		sendButton = new JButton("Send");
		buttonPanel = new JPanel(new GridLayout(1,2));
		buttonPanel.add(chatBoxTf);
		buttonPanel.add(sendButton);
		add(buttonPanel,BorderLayout.SOUTH);
		   
		setLayout(new GridLayout(3,2));
		
		sendButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				client.write(chatBoxTf.getText());
			}
		});
	       
	}
	
	private UserMasterBean getUserData(){
		return userData;
	}

}
