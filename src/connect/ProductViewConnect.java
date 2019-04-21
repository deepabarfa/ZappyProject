package connect;

import java.sql.Connection; // for establish the connection
import java.sql.DriverManager;//package for  jdbc driver
import java.sql.PreparedStatement; // for interface
import java.sql.ResultSet;// method that return a resultset object which contains the result returned by the execution query
import java.sql.SQLException;//for eql exception handling
import java.util.ArrayList;// for array list

import zappyinfo.Zeppy;

public class ProductViewConnect 
{

	public Connection start()// function of connection
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
	public ArrayList<Zeppy> productview() //database code new function for view data with arraylist
	{
		ArrayList<Zeppy> list=new ArrayList<>();
		try {	
		    Connection con=start();//call connection function for establish connection
		    PreparedStatement ps=con.prepareStatement("select * from upload");//query
			ResultSet rs= ps.executeQuery(); // method that return a Resultset object which contains the result returned by the execution query
		while(rs.next())
		{
			Zeppy e=new Zeppy();
			e.setProductID(rs.getInt("productID"));// get value with resultset object and with zappy object we call setter function
			e.setProductname(rs.getString("productname"));
			e.setPrice(rs.getDouble("price"));
			e.setWeight(rs.getString("weight"));
			e.setDetails(rs.getString("details"));
			e.setImages(rs.getString("images"));
			list.add(e);
		}
			con.close();
			  }catch(SQLException  ex)
			{
				System.err.println(ex);
				ex.printStackTrace();
			}
		return list;	
}
	
	public ArrayList<Zeppy> productDetailsview(int productID) 
	{

		ArrayList<Zeppy> list=new ArrayList<>();
		try {	
		    Connection con=start();
		    PreparedStatement ps=con.prepareStatement("select * from upload where productID=?");
		    ps.setInt(1,productID);
			ResultSet rs= ps.executeQuery(); // method that return a Resultset object which contains the result returned by the execution query
		while(rs.next())
		{
			Zeppy e=new Zeppy();
			e.setProductID(rs.getInt("productID"));// get value with resultset object and with zeppy object we call setter function
			e.setProductname(rs.getString("productname"));
			e.setPrice(rs.getDouble("price"));
			e.setWeight(rs.getString("weight"));
			e.setDetails(rs.getString("details"));
			e.setImages(rs.getString("images"));
			list.add(e);
		}
			con.close();
			  }catch(SQLException  ex)
			{
				System.err.println(ex);
				ex.printStackTrace();
			}
		return list;
	
		
	}
	
}
