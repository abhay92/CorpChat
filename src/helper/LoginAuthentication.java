package helper;

import javax.swing.JFrame;
import beans.UserMasterBean;
import dbHandler.DbConnection;
import gui.AdminPage;
import gui.UserPage;

public class LoginAuthentication {

	public static JFrame authenticate(String uname, String pwd)
	{
		int resultCode = 0;
		
		UserMasterBean userData = DbConnection.getResult(uname, pwd);
		
		if (userData != null)
		{
			if (userData.getUserType().equals("Administrator"))
			{
				resultCode = 1;
			}
			else
			{
				resultCode = 2;
			}
		}
		else
		{
			resultCode = 0;
		}
		return getNextWindow(resultCode, userData);
	}
	
	private static JFrame getNextWindow(int result, UserMasterBean userData)
	{
		if (result == 1)
		{
			return new AdminPage(userData);
		}
		else if(result == 2)
		{
			return new UserPage(userData);
		}
			
		return null;
	}
}
