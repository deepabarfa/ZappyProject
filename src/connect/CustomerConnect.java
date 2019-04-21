package connect;

import java.sql.Connection;// for establish the connection
import java.sql.PreparedStatement;// for interface
import java.sql.ResultSet;// method that return a resultset object which contains the result returned by the execution query
import java.sql.SQLException;//for eql exception handling
import zappyinfo.Zeppy;

public class CustomerConnect 
{

	public Zeppy viewProfileUpdate(String email)// create new function with parameter return zeppy object
	{
		Zeppy e=new Zeppy();//object creation
		try {	
			System.out.println(email);
		    Connection con=new LoginConnect().start();// call connection function from loginconnect class available in the connect package
		    PreparedStatement ps=con.prepareStatement("select * from registration where email=?");//create query 
			ps.setString(1,email);//set value
		    ResultSet rs= ps.executeQuery();
		while(rs.next())
		{
			
			e.setName(rs.getString("name"));
			e.setLastname(rs.getString("lastname"));//// get value with resultset object and with zeppy object we call setter function
			e.setCity(rs.getString("city"));
			e.setState(rs.getString("state"));
			e.setPin(rs.getString("pin"));
			e.setAddress(rs.getString("address"));
			e.setEmail(rs.getString("email"));
			e.setMobile(rs.getString("mobile"));
			e.setPassword(rs.getString("password"));
			
		}
		System.out.println(e);
			con.close();//close connection
			  }catch(SQLException  ex)// catch SQLexception 
			{
				System.err.println(ex);// print exception in system
			}
		
		return e;// return zeppy object
	}

}
