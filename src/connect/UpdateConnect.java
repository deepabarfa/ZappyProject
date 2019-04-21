package connect;

import java.sql.Connection; // for establish the connection
import java.sql.DriverManager;//package for  jdbc driver
import java.sql.PreparedStatement; // for interface
import java.sql.ResultSet;// method that return a resultset object which contains the result returned by the execution query
import java.sql.SQLException;//for eql exception handling
import java.util.ArrayList;// for array list;

import zappyinfo.Zeppy;
import zappyinfo.admin;

public class UpdateConnect 
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
	public int delete(int productID)
	{ int x=0;
		try 
		{
		Connection con=start();
		PreparedStatement ps=con.prepareStatement("delete from upload where productID=?");
		ps.setInt(1, productID);
		x=ps.executeUpdate();
		con.close();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return x;
	}

	public Zeppy update(int productID)
	{
		Zeppy e1=new Zeppy();
		try {	
		    Connection con=start();
		    PreparedStatement ps=con.prepareStatement("select * from upload where productID=?");
		    ps.setInt(1, productID);
		    ResultSet rs=ps.executeQuery(); // method that return a Resultset object which contains the result returned by the execution query
		    while(rs.next())
		    {
		    e1.setProductID(rs.getInt("productID"));// get value with resultset object and with zeppy object we call setter function
			e1.setProductname(rs.getString("productname"));
			e1.setPrice(rs.getDouble("price"));
			e1.setWeight(rs.getString("weight"));
			e1.setDetails(rs.getString("details"));
			e1.setImages(rs.getString("images"));
		    }
			con.close();
			  }catch(SQLException  ex)
			{
				System.out.println(ex);
			}
		
		return e1;
		}
	public Zeppy updateimage(int productID)
	{
		Zeppy e1=new Zeppy();
		try {	
		    Connection con=start();
		    PreparedStatement ps=con.prepareStatement("select * from upload where productID=?");
		    ps.setInt(1, productID);
		    ResultSet rs=ps.executeQuery(); // method that return a Resultset object which contains the result returned by the execution query
		    while(rs.next())
		    {
		    e1.setProductID(rs.getInt("productID"));// get value with resultset object and with zeppy object we call setter function
			e1.setProductname(rs.getString("productname"));
			e1.setPrice(rs.getDouble("price"));
			e1.setWeight(rs.getString("weight"));
			e1.setDetails(rs.getString("details"));
			e1.setImages(rs.getString("images"));
		    }
			con.close();
			  }catch(SQLException  ex)
			{
				System.out.println(ex);
			}
		
		return e1;
		}
	/*public int update(String productname,String price,String weight,String details,String images,int productID)
	{
		int x=0;
		try 
		{
		Connection con=start();
		PreparedStatement ps=con.prepareStatement("update upload set productname=?,price=?,weight=?,details=?,images=? where productID=?");
		
		ps.setString(1, productname);
		ps.setString(2, price);
		ps.setString(3, weight);
		ps.setString(4, details);
		ps.setString(5,images);
		ps.setInt(6, productID);
		x=ps.executeUpdate();
		con.close();
		}
		catch(Exception e)
		{
			System.out.println(e);
			e.printStackTrace();
		}
		return x;
	}*/
	public admin adminupdate(String uid) 
	{
		admin e1=new admin();
		try {
			System.out.println("hii");
		    Connection con=start();
		    PreparedStatement ps=con.prepareStatement("select * from login where uid=?");
		    ps.setString(1, uid);
		    System.out.println(uid);
		    ResultSet rs=ps.executeQuery(); // method that return a Resultset object which contains the result returned by the execution query
		    while(rs.next())
		    {
		    e1.setPassword(rs.getString("password"));// get value with resultset object and with admin object we call setter function
		    }
			con.close();
			  }catch(SQLException  ex)
			{
				System.out.println(ex);
			}
		System.out.println("hii1");
		return e1;
		
	}
	
}

