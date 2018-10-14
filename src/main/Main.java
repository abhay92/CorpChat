package main;

import gui.LoginPage;

import javax.swing.JOptionPane;

public class Main {
	public static void main(String arg[])
	   {
	   try
	   {
	   LoginPage frame=new LoginPage();
	   frame.setSize(500,200);
	   frame.setVisible(true);
	   frame.setDefaultCloseOperation(javax.swing.
			   WindowConstants.DISPOSE_ON_CLOSE);	 
	   }
	   catch(Exception e)
	   {JOptionPane.showMessageDialog(null, e.getMessage());}
	   }
}
