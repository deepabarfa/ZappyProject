package connect;

import java.sql.Connection; // for establish the connection
import java.sql.DriverManager;//package for  jdbc driver
import java.sql.PreparedStatement; // for interface
import java.sql.ResultSet;// method that return a resultset object which contains the result returned by the execution query
import java.sql.SQLException;//for eql exception handling

import zappyinfo.Zeppy;
import zappyinfo.admin;


public class LoginConnect 
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
	
	public int check(String uid,String password)
	{ int x=0;
		try {
		Connection con=start();
		PreparedStatement ps=con.prepareStatement("select * from login where uid=? and password=?");
		ps.setString(1, uid);
		ps.setString(2, password);
	 ResultSet rs= ps.executeQuery();
	
	    if(rs.next())
	    	  x=1;
	  }catch(SQLException  e)
		{
			System.out.println(e);
		}
return x;
	}

	public int Ccheck(String email, String password) 
	{
		int x=0;
		try {	 
			Connection con=start();
		    PreparedStatement ps=con.prepareStatement("select * from registration where email=? and password=?");
			ps.setString(1,email);
			ps.setString(2,password);
			
 	        ResultSet rs= ps.executeQuery();
			    if(rs.next())
			    	  x=1;
			  }catch(SQLException  e)
			{
				System.out.println(e);
			}

	return x;
	}

	public int updateap(String uid,String password, String pass, String currentpassword) //create function with parameter return integer value
	{
		int x=0;
		admin e1=new admin();//admin class object creation
		try 
		{
			Connection con=start();//call connection function
		PreparedStatement ps1=con.prepareStatement("select * from login where password='"+currentpassword+"'");//query for check old password
		ResultSet rs= ps1.executeQuery();// method that return a Resultset object which contains the result returned by the execution query
	    while(rs.next())
	    {
	    	uid=rs.getString("uid");//get value 
	    	pass=rs.getString("Password");
	    }
	    if(pass.equals(currentpassword)) //check condition
	    {
		PreparedStatement ps=con.prepareStatement("update login set password=? where uid=?");//update query
		ps.setString(1,password);//set value
		ps.setString(2,uid);
		//System.out.println("123");
		//System.out.println(uid);
		//System.out.println(password);
		x=ps.executeUpdate();	//execute query
		if(x!=0)
		{
			 System.out.println("update");
		}}
		 con.close();//close connection
		}catch(SQLException  ex)//catch SQLException
		{
			System.err.println(ex);// print exception in system
			ex.printStackTrace();//trace exception
		}
	return x;//return integer x
	}

	

	public Zeppy checkemailexist(String currentemail) 
	{
		Zeppy e1=new Zeppy();//admin class object creation
		try 
		{
			Connection con=start();//call connection function
		PreparedStatement ps1=con.prepareStatement("select * from registration where email='"+currentemail+"'");//query for check old password
		ResultSet rs= ps1.executeQuery();// method that return a Resultset object which contains the result returned by the execution query
	    while(rs.next())
	    {
	    	e1.setEmail(rs.getString("email"));
	    }
	    con.close();
	}catch(SQLException  ex)//catch SQLException
	{
		System.err.println(ex);// print exception in system
		ex.printStackTrace();//trace exception
	}
return e1;//return integer x
	
}
	public int forgetpassword(String pwd,String email) 
	{
		int y=0;
		   try {
			   Connection con=new LoginConnect().start();//call connection
			   PreparedStatement ps=con.prepareStatement("update registration set password=? where email=?");//placeholder
		   	    ps.setString(1,pwd);//set value
		   	    ps.setString(2,email);
			    y=ps.executeUpdate();//execute update query
			   	   
	         }catch(Exception e)
		     {
		   	  System.out.println(e);
		     }

	   return y;//return integer value
	}

	public int updateCustomerPassword(String email, String password, String pass, String currentpassword) 
	{
		int x=0;
		Zeppy e1=new Zeppy();//admin class object creation
		try 
		{
			Connection con=start();//call connection function
		PreparedStatement ps1=con.prepareStatement("select * from registration where password='"+currentpassword+"'");//query for check old password
		ResultSet rs= ps1.executeQuery();// method that return a Resultset object which contains the result returned by the execution query
	    while(rs.next())
	    {
	    	email=rs.getString("email");//get value 
	    	pass=rs.getString("Password");
	    }
	    if(pass.equals(currentpassword)) //check condition
	    {
		PreparedStatement ps=con.prepareStatement("update registration set password=? where email=?");//update query
		ps.setString(1,password);//set value
		ps.setString(2,email);
		//System.out.println("123");
		//System.out.println(uid);
		//System.out.println(password);
		x=ps.executeUpdate();	//execute query
		if(x!=0)
		{
			 System.out.println("update");
		}}
		 con.close();//close connection
		}catch(SQLException  ex)//catch SQLException
		{
			System.err.println(ex);// print exception in system
			ex.printStackTrace();//trace exception
		}
	return x;//return integer x
	}
	
}
