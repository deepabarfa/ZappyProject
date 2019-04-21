package connect;

import java.sql.Connection;// for establish the connection
import java.sql.DriverManager;//package for  jdbc driver
import java.sql.PreparedStatement;// for interface
import java.sql.ResultSet;// method that return a resultset object which contains the result returned by the execution query
import java.sql.SQLException;//for eql exception handling
import java.util.ArrayList;// for array list

import zappyinfo.Zeppy;

public class CustomerView {
	
	public Connection start() // function of connection
		{
		Connection con=null;
		try //for handle the exception 
		{	
			 Class.forName("com.mysql.jdbc.Driver"); //load the jdbc suitable connection loads com.mysql.jdbc.Driver into memory
		con=DriverManager.getConnection("jdbc:mysql://localhost:3306/zappy","root",""); //establish the connection with specific language it may be mysql, oracle etc. 
		}
		catch(ClassNotFoundException | SQLException e)// catch ClassNotFoundException and SQLException both type exception and create object
		{
			System.out.println(e);// with object we print the exception in system and solved the problem
		}
		return con;
		}

	public ArrayList<Zeppy> customerview() // create new function with arraylist 
	{
		ArrayList<Zeppy> list=new ArrayList<>();// object of arraylist
		try {	
		    Connection con=start();// call connection function
		    PreparedStatement ps=con.prepareStatement("select * from registration");// query
			ResultSet rs= ps.executeQuery();// method that return a Resultset object which contains the result returned by the execution query
		while(rs.next())
		{
			Zeppy e=new Zeppy();//object creation
			e.setEmail(rs.getString("email"));// get value with resultset object and with zeppy object we call setter function
			e.setName(rs.getString("name"));
			e.setLastname(rs.getString("lastname"));
			e.setCity(rs.getString("city"));
			e.setState(rs.getString("state"));
			e.setPin(rs.getString("pin"));
			e.setAddress(rs.getString("address"));
			e.setMobile(rs.getString("mobile"));
			list.add(e);
		}
			con.close();//connection closing
			  }catch(SQLException  ex)//catch SQL exception
			{
				System.err.println(ex);//print exception 
				ex.printStackTrace();//trace exception
			}
		return list;//return array list
	}

}
