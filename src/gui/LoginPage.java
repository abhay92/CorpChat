package gui;

import helper.LoginAuthentication;

import javax.swing.*;

import java.awt.*;
import java.awt.event.*;
	  
	public class LoginPage extends JFrame implements ActionListener
	 {
	  private JButton SUBMIT, CANCEL;
	  private JPanel detailsPanel;
	  private JPanel buttonPanel;
	  private JLabel usernameLbl,passwordLbl;
	  private JTextField  usernameTf,passwordTf;
	  private GridBagConstraints gridConstraint;
	   
	  public LoginPage()
	   {
	   usernameLbl = new JLabel();
	   usernameLbl.setText("Username:");
	   usernameLbl.setFont(new Font("Courier New", Font.BOLD, 40));
	   usernameLbl.setForeground(Color.GRAY);
	   
	   usernameTf = new JTextField(15);
	   
	   passwordLbl = new JLabel();
	   passwordLbl.setText("Password:");
	   passwordLbl.setFont(new Font("Courier New", Font.BOLD, 40));
	   passwordLbl.setForeground(Color.GRAY);
  	   
	   passwordTf = new JPasswordField(15);
	   
	   detailsPanel = new JPanel(new GridLayout(2,2));
	   detailsPanel.add(usernameLbl);
	   detailsPanel.add(usernameTf);
	   detailsPanel.add(passwordLbl);
	   detailsPanel.add(passwordTf);
	   add(detailsPanel,BorderLayout.CENTER);
	   
	   buttonPanel = new JPanel(new GridLayout(1,2));
	   gridConstraint = new GridBagConstraints();
	   SUBMIT = new JButton("SUBMIT");
	   gridConstraint.gridx = 5;
	   gridConstraint.gridy = 3;
	   gridConstraint.insets = new Insets(10,10,10,10);
	   buttonPanel.add(SUBMIT, gridConstraint);
	   
	   CANCEL = new JButton("CANCEL");
	   gridConstraint.gridx = 0;
	   gridConstraint.gridy = 0;
	   buttonPanel.add(CANCEL, gridConstraint);
	   
	   add(buttonPanel,BorderLayout.CENTER);
	   
	   SUBMIT.addActionListener(this);
	   CANCEL.addActionListener(this);
	   setTitle("LOGIN FORM");
	   
	   setSize(1000, 600);
	   setResizable(false);
	  
	   setLayout(new GridLayout(2,1));
       
	   }
	  public void actionPerformed(ActionEvent ae)
	   {
		  if(ae.getSource() == SUBMIT)
		  {
			   String uname=usernameTf.getText();
			   String pwd=passwordTf.getText();
			   Frame nextPage = LoginAuthentication.authenticate(uname, pwd);
			   
			   if(nextPage == null)
			   {
			   	   JOptionPane.showMessageDialog(this,"Invalid username or password",
						   "Error",JOptionPane.ERROR_MESSAGE);
			   }
			   else
			   {
				   this.setVisible(false);
				   dispose();
				   nextPage.setVisible(true);
			   }
		  }
	  }
}