package helper;

import beans.UserMasterBean;
import dbHandler.DbConnection;

public class LoginAuthentication {

	public static int authenticate(String uname, String pwd)
	{
		int resultCode = 0;
		
		UserMasterBean result = DbConnection.getResult(uname, pwd);
		
		if (result != null)
		{
			if (result.getUserType().equals("Administrator"))
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
		return resultCode;
	}
}
