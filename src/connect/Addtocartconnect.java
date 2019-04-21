package connect;

import java.sql.Connection; // for establish the connection
import java.sql.DriverManager;//package for  jdbc driver
import java.sql.PreparedStatement; // for interface
import java.sql.ResultSet;// method that return a resultset object which contains the result returned by the execution query
import java.sql.SQLException;//for eql exception handling
import java.util.ArrayList;// for array list

import zappyinfo.Zeppy;

public class Addtocartconnect 
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
	
	public int addtocart(int productID,String ipaddress, int quantity1, double tamount)//function with some parameter and return the int value
	{ 
		Zeppy e1=new Zeppy();// create an zeppy object 
		int x=0;
		try 
		{System.out.println("hello1");//for testing
		Connection con=start();// call the connection function 
		 PreparedStatement ps=con.prepareStatement("select * from upload where productID=?"); //it is an interface that is used to execute the parameterized query and here we create object of  PreparedStatemen interface
		    ps.setInt(1, productID);//set the productId with  PreparedStatemen object
		    ResultSet rs=ps.executeQuery(); // method that return a Resultset object which contains the result returned by the execution query
		    while(rs.next())
		    {
		    	    e1.setProductID(rs.getInt("productID"));// get value with resultset object and with zeppy object we call setter function 
					e1.setProductname(rs.getString("productname"));// get value with resultset object and with zeppy object we call setter function
					e1.setPrice(rs.getDouble("price"));// get value with resultset object and with zeppy object we call setter function
					e1.setWeight(rs.getString("weight"));// get value with resultset object and with zeppy object we call setter function
					e1.setDetails(rs.getString("details"));// get value with resultset object and with zeppy object we call setter function
					e1.setImages(rs.getString("images"));// get value with resultset object and with zeppy object we call setter function
		}}
		catch(Exception e)//handle exception
		{
			e.printStackTrace();//it trace the exception and print the location of of execution 
		}
		int p=0;
		try { //here with same function we perform another database    
			 Connection con1=start();// call the connection function 
		   	  PreparedStatement ps1=con1.prepareStatement("select productID from addtocart where ipaddress=?");//placeholder
		      ps1.setString(1,ipaddress);//set ipaddress with parameterized 
		   	  ResultSet rs=ps1.executeQuery();// method that return a Resultset object which contains the result returned by the execution query
		  while(rs.next())
		  {
			 p=rs.getInt("productID");//get productid in p variable
		  }
		  if(p!=1)
	  {
		System.out.println("hello");
		Connection con=start();// call the connection function 
		PreparedStatement ps=con.prepareStatement("insert into addtocart values(?,?,?,?,?,?,?,?,?)");//insert query in addtocart table
		ps.setInt(1,e1.getProductID());//get the value in zeppy class getter function and insert with prepareStatement query
		ps.setString(2,e1.getProductname());//get the value in zeppy class getter function and insert with prepareStatement query
		ps.setDouble(3,e1.getPrice());//get the value in zeppy class getter function and insert with prepareStatement query
		ps.setString(4,e1.getWeight());//get the value in zeppy class getter function and insert with prepareStatement query
		ps.setString(5,e1.getDetails());//get the value in zeppy class getter function and insert with prepareStatement query
		ps.setString(6,e1.getImages());//get the value in zeppy class getter function and insert with prepareStatement query
		ps.setString(7,ipaddress);//get the value in zeppy class getter function and insert with prepareStatement query
		ps.setInt(8, quantity1);//get the value in zeppy class getter function and insert with prepareStatement query
		ps.setDouble(9, tamount);//get the value in zeppy class getter function and insert with prepareStatement query
		
		x=ps.executeUpdate();//execute update query
		con.close();//close the connection
		
	}}catch(Exception e)//handle the exception
	{
		System.out.println(e);//print the exception in system
	}
		
		return x;//return the integer value
	}

	public ArrayList<Zeppy> viewaddcart(String ipaddress) //create new function with return array list 
	{
		ArrayList<Zeppy> list=new ArrayList<>();// create ArrayList object
		try {	
		    Connection con=start();//call the connection function
		    PreparedStatement ps=con.prepareStatement("select * from addtocart where ipaddress=?");//write an query
		    ps.setString(1,ipaddress);
		    ResultSet rs= ps.executeQuery();//execute query
		while(rs.next())
		{
			Zeppy e=new Zeppy();//create an zeppy class object
			e.setProductID(rs.getInt("productID"));// get value with resultset object and with zeppy object we call setter function
			e.setImages(rs.getString("images"));
			e.setProductname(rs.getString("productname"));
			e.setPrice(rs.getDouble("price"));
			e.setWeight(rs.getString("weight"));
			e.setDetails(rs.getString("details"));
			e.setIpaddress(rs.getString("ipaddress"));
			e.setQuantity(rs.getInt("quantity"));
			e.setTamount(rs.getDouble("tamount"));
			
			list.add(e);
		}
			con.close();//close connection
			  }catch(SQLException  ex)
			{
				System.err.println(ex);
				ex.printStackTrace();
			}
		return list;
	}

	public int removeProduct(int productID,String ipaddress) //create new function and return integer value 
	{
		int y=0;
		   try {
			   Connection con=start();//call the connection function
			   	  PreparedStatement ps=con.prepareStatement("delete from addtocart where productID=? and ipaddress=?");//write delete query
			   	    ps.setInt(1,productID);// set value with parameterized
					ps.setString(2,ipaddress);
			   	    y=ps.executeUpdate();
			   	    
			     }catch(Exception e)//handle exception
			     {
			   	  System.out.println(e);
			     }

		   return y;
	}
	public int countProduct(String ipaddress)//create new function and it returns integer value 
	{ 
		int e=0;
		try {	
		    Connection con=start();
		    PreparedStatement ps=con.prepareStatement("select count(*) from addtocart where ipaddress=?");//create  query for counting 
			ps.setString(1,ipaddress);// set value with parameterized 
		    ResultSet rs= ps.executeQuery();
		while(rs.next())
		{
			e=rs.getInt(1);
		}
		System.out.println(e);
			con.close();
			  }catch(SQLException  ex)
			{
				System.err.println(ex);
			}
		
		return e;
		}
	
	public int countProductemail(String email)//create new function and it returns integer value 
	{
		int e=0;
		try {	
		    Connection con=start();
		    PreparedStatement ps=con.prepareStatement("select count(*) from addtocart where ipaddress=?");//create  query for counting 
			ps.setString(1,email);// set value with parameterized 
		    ResultSet rs= ps.executeQuery();
		    System.out.println("palelmf");
		while(rs.next())
		{
			e=rs.getInt(1);
		}
		System.out.println(e);
			con.close();
			}catch(SQLException  ex)
			{
				System.err.println(ex);
			}
		
		return e;
		}
	public int countamount(int amount,int productID)//create new function and it returns integer value 
	{
		Zeppy e=new Zeppy();
		int f=0;
		try {	
		    Connection con=start();
		    PreparedStatement ps=con.prepareStatement("select sum(quantity) from addtocart where productID=?");//create  query for counting 
			ps.setInt(1,productID);// set value with parameterized 
			ResultSet rs= ps.executeQuery();
		while(rs.next())
		{
			f=rs.getInt(amount);
			System.out.println("Amount inside"+f);
		}
		System.out.println(e);
			con.close();
			}catch(SQLException  ex)
			{
				System.err.println(ex);
			}
	return f;
	}
	public int addtocartemail(int productID,String email, int quantity, double tamount) 
	{
		Zeppy e1=new Zeppy();// create an zeppy object 
		int x=0;
		try 
		{System.out.println("hello1");//for testing
		Connection con=start();// call the connection function 
		 PreparedStatement ps=con.prepareStatement("select * from upload where productID=?"); //it is an interface that is used to execute the parameterized query and here we create object of  PreparedStatemen interface
		    ps.setInt(1, productID);//set the productId with  PreparedStatemen object
		    ResultSet rs=ps.executeQuery(); // method that return a Resultset object which contains the result returned by the execution query
		    while(rs.next())
		    {System.out.println("hello2");
		    	    e1.setProductID(rs.getInt("productID"));// get value with resultset object and with zeppy object we call setter function 
					e1.setProductname(rs.getString("productname"));// get value with resultset object and with zeppy object we call setter function
					e1.setPrice(rs.getDouble("price"));// get value with resultset object and with zeppy object we call setter function
					e1.setWeight(rs.getString("weight"));// get value with resultset object and with zeppy object we call setter function
					e1.setDetails(rs.getString("details"));// get value with resultset object and with zeppy object we call setter function
					e1.setImages(rs.getString("images"));// get value with resultset object and with zeppy object we call setter function
		}}
		catch(Exception e)//handle exception
		{
			e.printStackTrace();//it trace the exception and print the location of of execution 
		}
		int p=0;
		try { //here with same function we perform another database    
			 Connection con1=start();// call the connection function 
			 //select a.productID,a.productname,a.details,a.price,a.images,a.quantity,a.tamount,r.name,r.mobile,r.address from addtocart a,registration r where ipaddress=? and email=? and productID=?
		   	  PreparedStatement ps1=con1.prepareStatement("select a.productID from addtocart a,registration r where email=?");//placeholder
		      //ps1.setString(1,ipaddress);//set ipaddress with parameterized 
		   	  ps1.setString(1, email);
		      ResultSet rs=ps1.executeQuery();// method that return a Resultset object which contains the result returned by the execution query
		  while(rs.next())
		  {
			 p=rs.getInt("productID");//get productid in p variable
		  }
		  if(p!=1)
	  {
		System.out.println("hello");
		Connection con=start();// call the connection function 
		PreparedStatement ps=con.prepareStatement("insert into addtocart values(?,?,?,?,?,?,?,?,?)");//insert query in addtocart table
		ps.setInt(1,e1.getProductID());//get the value in zeppy class getter function and insert with prepareStatement query
		ps.setString(2,e1.getProductname());
		ps.setDouble(3,e1.getPrice());
		ps.setString(4,e1.getWeight());
		ps.setString(5,e1.getDetails());
		ps.setString(6,e1.getImages());
		ps.setString(7,email);
		ps.setInt(8, quantity);
		ps.setDouble(9, tamount);
		
		x=ps.executeUpdate();//execute update query
		con.close();//close the connection
		
	}}catch(Exception e)//handle the exception
	{
		System.out.println(e);//print the exception in system
	}
		
		return x;//return the integer value
	}

	public ArrayList<Zeppy> viewaddcartemail(String email) 
	{
		ArrayList<Zeppy> list=new ArrayList<>();// create ArrayList object
		try {	
		    Connection con=start();//call the connection function
		    //select a.productID from addtocart a,registration r where email=?
		    PreparedStatement ps=con.prepareStatement("select * from addtocart where ipaddress=?");//write an query
			ps.setString(1, email);
		    ResultSet rs= ps.executeQuery();//execute query
		while(rs.next())
		{
			Zeppy e=new Zeppy();//create an zeppy class object
			
			e.setProductID(rs.getInt("productID"));// get value with resultset object and with zeppy object we call setter function
			e.setImages(rs.getString("images"));
			e.setProductname(rs.getString("productname"));
			e.setPrice(rs.getDouble("price"));
			e.setWeight(rs.getString("weight"));
			e.setDetails(rs.getString("details"));
			e.setIpaddress(rs.getString("ipaddress"));
			e.setQuantity(rs.getInt("quantity"));
			e.setTamount(rs.getDouble("tamount"));
			
			list.add(e);
		}
			con.close();//close connection
			  }catch(SQLException  ex)
			{
				System.err.println(ex);
				ex.printStackTrace();
			}
		return list;
	}


	public int updatecart(String email,String ipaddress) 
	{
		int x=0;
		try{Connection con=start();//call the connection function
		PreparedStatement ps=con.prepareStatement("update addtocart set ipaddress=? where ipaddress=?");
		ps.setString(1, email);
		ps.setString(2, ipaddress);
		x=ps.executeUpdate();	//execute query
		if(x!=0)
		{
			 System.out.println("update");
		}
		}
	catch(SQLException  ex)
	{
		System.err.println(ex);
		ex.printStackTrace();
	}
		return x;
	}

	public int removeProductemail(int productID, String email) 
	{
		int y=0;
	   try {
		   Connection con=start();//call the connection function
		   	  PreparedStatement ps=con.prepareStatement("delete from addtocart where productID=? and ipaddress=?");//write delete query
		   	    ps.setInt(1,productID);// set value with parameterized
				ps.setString(2,email);
		   	    y=ps.executeUpdate();
		   	    
		     }catch(Exception e)//handle exception
		     {
		   	  System.out.println(e);
		     }

	   return y;
	}

	
	public int checkpidexist(int productID,int quantity1, String ipaddress) 
	{
		int x=0;
		try {
			
			 Connection con=start();//call the connection function
		   	  PreparedStatement ps=con.prepareStatement("select * from addtocart where productID=? and ipaddress=?");//write delete query
		   	    ps.setInt(1,productID);// set value with parameterized
				ps.setString(2, ipaddress);
		   	    ResultSet rs=ps.executeQuery();	
			while(rs.next()) 
			{
				x=1;
		int	quantityinnside=quantity1+rs.getInt("quantity");
		
		updateCartquantity( productID, quantityinnside) ;
			}	
		} catch (Exception e) 
		{
			System.out.println(e);
			e.printStackTrace();
		}
		return x;
		}
	
	public int updateCartquantity(int p,int quantityinnside) 
	{
		
		int y=0;
		   try {
			   Connection con=start();//call the connection function
			   	  PreparedStatement ps=con.prepareStatement("update addtocart set quantity=? where productID=?");//write delete query
			   	    ps.setInt(1,quantityinnside);// set value with parameterized
					ps.setInt(2,p);
					
			   	    y=ps.executeUpdate();    
			     }catch(Exception e)//handle exception
			     {
			   	  System.out.println(e);
			     }

		   return y;
	}
	public int checkpidexistEmail(int productID,int quantity1, String email) 
	{
		int x=0;
		try {
			
			 Connection con=start();//call the connection function
		   	  PreparedStatement ps=con.prepareStatement("select * from addtocart where productID=? and ipaddress=?");//write delete query
		   	    ps.setInt(1,productID);// set value with parameterized
				ps.setString(2, email);
		   	    ResultSet rs=ps.executeQuery();	
			while(rs.next()) 
			{
				x=1;
		int	quantityinnside=quantity1+rs.getInt("quantity");
		
		updateCartquantityEmail( productID, quantityinnside) ;
			}	
		} catch (Exception e) 
		{
			System.out.println(e);
			e.printStackTrace();
		}
		return x;
		}
	
	public int updateCartquantityEmail(int p,int quantityinnside) 
	{
		
		int y=0;
		   try {
			   Connection con=start();//call the connection function
			   	  PreparedStatement ps=con.prepareStatement("update addtocart set quantity=? where productID=?");//write delete query
			   	    ps.setInt(1,quantityinnside);// set value with parameterized
					ps.setInt(2,p);
					
			   	    y=ps.executeUpdate();    
			     }catch(Exception e)//handle exception
			     {
			   	  System.out.println(e);
			     }

		   return y;
	}

	public int updatequntityafteradd(int productID,int quantity) {
		int m=0;
		   try {
			   Connection con=start();//call the connection function
			   	  PreparedStatement ps=con.prepareStatement("update addtocart set quantity=? where productID=?");//write delete query
			   	    ps.setInt(1,quantity);// set value with parameterized
					ps.setInt(2,productID);
					
			   	    m=ps.executeUpdate();    
			     }catch(Exception e)//handle exception
			     {
			   	  System.out.println(e);
			     }

		   return m;	
	}

	public int checkwhenpidexist(String email, String ipaddress) 
	{
		int x=0;
		try {
			 Connection con=start();//call the connection function
			 
			 PreparedStatement ps=con.prepareStatement("select productID from addtocart where ipaddress=?");//query
			 ps.setString(1, email);
			 
			 PreparedStatement ps1=con.prepareStatement("select productID from addtocart where ipaddress=?");//query
			 ps1.setString(1, ipaddress);
			 
			 int eid=0;
			 int ipid=0;
			 ResultSet rs=ps.executeQuery();	
			 while(rs.next()) 
				{
				 eid=rs.getInt("productID");
				 
				 ResultSet rs1=ps1.executeQuery();
				 while(rs1.next()) 
					{
					 ipid=rs.getInt("productID");
					 
					 if(eid==ipid)
					 {
						 PreparedStatement ps3=con.prepareStatement("delete from addtocart where ipaddress=? and productID=?");//query
						 ps3.setString(1, email); 
						 ps3.setInt(2, eid);
						 x=ps3.executeUpdate();
					 }
					 
					}
				} 
		}
		catch(Exception e)//handle exception
	     {
	   	  System.out.println(e);
	     }
		return x;
	}
		
}
