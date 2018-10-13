package gui;

import helper.LoginAuthentication;

import javax.swing.*;

import java.awt.*;
import java.awt.event.*;
	  
	public class LoginPage extends JFrame implements ActionListener
	 {
	  JButton SUBMIT, CANCEL;
	  JPanel panel;
	  JLabel label1,label2;
	  final JTextField  text1,text2;
	   
	  public LoginPage()
	   {
	   label1 = new JLabel();
	   label1.setText("Username:");
	   text1 = new JTextField(15);

	   label2 = new JLabel();
	   label2.setText("Password:");
	   text2 = new JPasswordField(15);
	  
	   SUBMIT=new JButton("SUBMIT");
	   CANCEL = new JButton("CANCEL");
	   
	   panel=new JPanel(new GridLayout(3,1));
	   panel.add(label1);
	   panel.add(text1);
	   panel.add(label2);
	   panel.add(text2);
	   panel.add(SUBMIT);
	   panel.add(CANCEL);
	   add(panel,BorderLayout.CENTER);
	   SUBMIT.addActionListener(this);
	   CANCEL.addActionListener(this);
	   setTitle("LOGIN FORM");
	   }
	  public void actionPerformed(ActionEvent ae)
	   {
		  if(ae.getSource() == SUBMIT)
		  {
			   String uname=text1.getText();
			   String pwd=text2.getText();
			   int result = LoginAuthentication.authenticate(uname, pwd);
			   
			   switch(result)
			   {
			   case 1:
				   System.out.println("ADMIN");
				   break;
				   
			   case 2:
				   System.out.println("CLIENT");
				   break;
				   
			   default:
				   JOptionPane.showMessageDialog(this,"Invalid username or password",
						   "Error",JOptionPane.ERROR_MESSAGE);
						   
				   break;
					   
			   }			 
		  }
		  else
		  {
			dispose();
		  }
	  }
}