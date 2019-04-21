package connect;

import java.sql.Connection; // for establish the connection
import java.sql.DriverManager;//package for  jdbc driver
import java.sql.PreparedStatement; // for interface
import java.sql.ResultSet;// method that return a resultset object which contains the result returned by the execution query
import java.sql.SQLException;//for eql exception handling
import java.util.ArrayList;// for array list

import zappyinfo.Zeppy;

public class RegistrationConnect 
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

public int insert(String email,String name,String lastname,String city,String state,String pin,String address,String mobile,String password)//insert function
{
	 int x=0;
		try {
		Connection con=start();//call connection function
		PreparedStatement ps=con.prepareStatement("insert into registration values(?,?,?,?,?,?,?,?,?)");//insertion query
		
		ps.setString(1, email);//set value
		ps.setString(2, name);
		ps.setString(3, lastname);
		ps.setString(4, city);
		ps.setString(5, state);
		ps.setString(6, pin);
		ps.setString(7, address); 
		ps.setString(8, mobile);
		ps.setString(9, password);
		
	 x= ps.executeUpdate();//execute update querry
	 con.close();
	  }catch(SQLException  e)
		{
			System.out.println(e);
		}
return x;

}

public ArrayList<Zeppy> registrationview(String email) 
{
	ArrayList<Zeppy> list=new ArrayList<>();
	try {	
	    Connection con=start();
	    PreparedStatement ps=con.prepareStatement("select * from registration where email=?");//select query
	    ps.setString(1, email);//set value
		ResultSet rs= ps.executeQuery(); // method that return a Resultset object which contains the result returned by the execution query
	while(rs.next())
	{
		
		Zeppy e=new Zeppy();
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
		con.close();
		  }catch(SQLException  ex)
		{
			System.err.println(ex);
			ex.printStackTrace();
		}
	return list;

}


public ArrayList<Zeppy> viewaddcart() {
	ArrayList<Zeppy> list1=new ArrayList<>();
	try {	
	    Connection con=start();
	    PreparedStatement ps=con.prepareStatement("select * from addtocart");
		ResultSet rs= ps.executeQuery(); // method that return a Resultset object which contains the result returned by the execution query
	while(rs.next())
	{
		Zeppy e=new Zeppy();
		e.setProductID(rs.getInt("productID"));// get value with resultset object and with zeppy object we call setter function
		e.setImages(rs.getString("images"));
		e.setProductname(rs.getString("productname"));
		e.setPrice(rs.getDouble("price"));
		e.setWeight(rs.getString("weight"));
		e.setDetails(rs.getString("details"));
		e.setIpaddress(rs.getString("ipaddress"));
		list1.add(e);
	}
		con.close();
		  }catch(SQLException  ex)
		{
			System.err.println(ex);
			ex.printStackTrace();
		}
	return list1;
}

public int updateprofile(String email, String name, String city, String state, String pin,String  mobile, String address) 
{
	int x=0;
	try {	
		 Connection con=start();
	    PreparedStatement ps=con.prepareStatement("update registration set name=?,city=?,state=?,pin=?,mobile=?,address=? where email=?");
	    
		ps.setString(1,name);
		ps.setString(2,city);
		ps.setString(3,state);
		ps.setString(4,pin);
		ps.setString(5,mobile);
		//ps.setString(6,password);
		ps.setString(6,address);
		ps.setString(7,email);
		 x=ps.executeUpdate();
	
			con.close();
  }catch(SQLException  ex)
{
	System.err.println(ex);
}

	return x;
}


}
