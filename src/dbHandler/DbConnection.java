package dbHandler;

import java.sql.*;  

import beans.UserMasterBean;

public class DbConnection {

	private static Connection con = null;
	private static PreparedStatement stmt = null;
	private final static String DB_NAME = "corpchat";
	
	public static Connection getConnection()
	{  
	  try
	   {  
//	     Class.forName("com.mysql.jdbc.Driver");  
	     con=DriverManager.getConnection(  
	    		 "jdbc:mysql://localhost:3306/"+DB_NAME,"root","root");  
	   }
	  catch(Exception e)
	  { 
		System.out.println(e);
	  }  
	  return con;
	}  

    public static UserMasterBean getResult(String uname, String pwd)
    {
    	ResultSet rs = null;
    	Connection con = getConnection();
    	UserMasterBean userData = null;
    	try
    	{
    	   stmt=con.prepareStatement("select * from usermaster where Username=? and Password=?");  
    	   stmt.setString(1, uname);
    	   stmt.setString(2, pwd);
    	   rs = stmt.executeQuery(); 
    	   if(rs.next()) 
    	   {
    		   userData = new UserMasterBean(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6));
    	   }
    	}
    	catch(SQLException e)
    	{
    		e.printStackTrace();
    	}
    	
    	return userData;
    }
    
    public void finalize()
    {
    	try {
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}  
    }
    
}
	 
