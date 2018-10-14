package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import beans.UserMasterBean;

public class UserPage extends JFrame {
	
	private final String pageTitle = "Chat";
	private JLabel welcomeLbl;
	private UserMasterBean uname;
	private JPanel welcomePanel;
	  	  
	public UserPage()
	{
		initFrame();
		initComponents();
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
		uname = new UserMasterBean();
		welcomeLbl = new JLabel();
		welcomeLbl.setText("Welecome " + uname.getUserName());
		welcomeLbl.setFont(new Font("Courier New", Font.BOLD, 100));
		welcomeLbl.setForeground(Color.BLUE);
		   
		
		welcomePanel = new JPanel(new GridLayout(1,2));
		welcomePanel.add(welcomeLbl);
		add(welcomePanel,BorderLayout.CENTER);
		   
	}

}
