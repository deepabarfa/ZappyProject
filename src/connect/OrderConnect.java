package connect;

import java.sql.Connection; // for establish the connection
import java.sql.PreparedStatement; // for interface
import java.sql.ResultSet;// method that return a resultset object which contains the result returned by the execution query
import java.sql.SQLException;//for eql exception handling
import java.util.ArrayList;// for array list

import zappyinfo.Zeppy;


public class OrderConnect
{

	public int buyproduct(String email, int productID, String ipaddress) //create function with some parameter return integer value
	{
		Connection con=new LoginConnect().start();//call connection function from loginconnect function
		
	int y=0,x=0,z=0;
	try {	
	    
	    PreparedStatement ps=con.prepareStatement("select a.productID,a.productname,a.details,a.price,a.images,a.quantity,a.tamount,r.name,r.mobile,r.address from addtocart a,registration r where email=? and productID=?");
		//create query (joint query) because we need to use two table
	   // ps.setString(1,ipaddress); // set value
		ps.setInt(2,productID);
		ps.setString(1,email);
	    ResultSet rs= ps.executeQuery();// method that return a Resultset object which contains the result returned by the execution query
	    
	    ArrayList<Zeppy> list=new ArrayList<>();//create object of arraylist
	while(rs.next())
	{   
		Zeppy ze=new Zeppy();//object creation
		ze.setProductID(rs.getInt("productID"));// get value with resultset object and with zeppy object we call setter function 
		ze.setProductname(rs.getString("productname"));
		ze.setDetails(rs.getString("details"));
		ze.setPrice(rs.getDouble("price"));
		ze.setImages(rs.getString("images"));
		ze.setQuantity(rs.getInt("quantity"));
		ze.setTamount(rs.getDouble("tamount"));
		ze.setEmail(email);
		ze.setName(rs.getString("name"));
		ze.setMobile(rs.getString("mobile"));
		ze.setAddress(rs.getString("address"));
		list.add(ze);
	}
	
	for(Zeppy zc:list)//for each loop
	{
		PreparedStatement ps1=con.prepareStatement("insert into order1 (productID,productname,details,price,images,quantity,tamount,email,name,mobile,address) values(?,?,?,?,?,?,?,?,?,?,?)");//placeholder
		ps1.setInt(1,zc.getProductID());//set value for insert into order1 table with parameter (get value by getter function)
		ps1.setString(2,zc.getProductname());
		ps1.setString(3,zc.getDetails());
		ps1.setDouble(4,zc.getPrice());
		ps1.setString(5,zc.getImages());
		ps1.setInt(6,zc.getQuantity());
		ps1.setDouble(7,zc.getTamount());
        ps1.setString(8,zc.getEmail());
        ps1.setString(9,zc.getName());
        ps1.setString(10,zc.getMobile());
        ps1.setString(11,zc.getAddress());
        
//when data insert into order1 table when data delete from addtocart table
        PreparedStatement ps2=con.prepareStatement("delete from addtocart where productID=? and ipaddress=?");//placeholder
	   	ps2.setInt(1,productID);//for delete query we set value
        ps2.setString(2, email);   
   	   con.setAutoCommit(false);//autoCommit code when query finish connection will close
	   	 y=ps1.executeUpdate();//execute query
   	     z=ps2.executeUpdate();//execute query
   	     con.commit();
   	     
	}    

	       }catch(Exception ex)//handle exception keyword
		     {
		   	 ex.printStackTrace();//trace exception
		     }
	
	System.out.println("y ="+y+"z="+z);
	if(y!=0)
	{
		x=1;
		System.out.println(x);
	}
	
	   return x;//return integer

	}

	public ArrayList<Zeppy> orderview(String email) {
		ArrayList<Zeppy> list=new ArrayList<>();
		try {	
		    Connection con=new LoginConnect().start();
		    PreparedStatement ps=con.prepareStatement("select * from order1 where email=?");
		    ps.setString(1,email);
			ResultSet rs= ps.executeQuery();// method that return a Resultset object which contains the result returned by the execution query
		while(rs.next())
		{
			Zeppy e=new Zeppy();
			e.setProductID(rs.getInt("productID"));// get value with resultset object and with zeppy object we call setter function 
			e.setProductname(rs.getString("productname"));
			e.setPrice(rs.getDouble("price"));
			e.setDetails(rs.getString("details"));
			e.setImages(rs.getString("images"));
			e.setQuantity(rs.getInt("quantity"));
			e.setTamount(rs.getDouble("tamount"));
			e.setEmail(rs.getString("email"));
			e.setName(rs.getString("name"));
			e.setMobile(rs.getString("mobile"));
			e.setAddress(rs.getString("address"));
			e.setDate(rs.getString("Date"));
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

	public ArrayList<Zeppy> orderallview() 
	{
		ArrayList<Zeppy> list=new ArrayList<>();
		try {	
		    Connection con=new LoginConnect().start();
		    PreparedStatement ps=con.prepareStatement("SELECT * FROM order1 ORDER BY orderId ASC");
			ResultSet rs= ps.executeQuery();// method that return a Resultset object which contains the result returned by the execution query
		while(rs.next())
		{
			Zeppy e=new Zeppy();
			e.setProductID(rs.getInt("productID"));//// get value with resultset object and with zeppy object we call setter function 
			e.setProductname(rs.getString("productname"));
			e.setPrice(rs.getDouble("price"));
			e.setDetails(rs.getString("details"));
			e.setImages(rs.getString("images"));
			e.setQuantity(rs.getInt("quantity"));
			e.setTamount(rs.getDouble("tamount"));
			e.setEmail(rs.getString("email"));
			e.setName(rs.getString("name"));
			e.setMobile(rs.getString("mobile"));
			e.setAddress(rs.getString("address"));
			e.setDate(rs.getString("Date"));
			e.setStatus(rs.getInt("Status"));
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

	public ArrayList<Zeppy> orderDispatchecancelview(int status) 
	{
		ArrayList<Zeppy> list=new ArrayList<>();
		try {	
		    Connection con=new LoginConnect().start();
		    PreparedStatement ps=con.prepareStatement("select * from order1 where status=? ORDER BY orderId ASC");
		    ps.setInt(1,status);
			ResultSet rs= ps.executeQuery();// method that return a Resultset object which contains the result returned by the execution query
		while(rs.next())
		{
			Zeppy e=new Zeppy();
			e.setProductID(rs.getInt("productID"));// get value with resultset object and with zeppy object we call setter function 
			e.setProductname(rs.getString("productname"));
			e.setPrice(rs.getDouble("price"));
			e.setDetails(rs.getString("details"));
			e.setImages(rs.getString("images"));
			e.setQuantity(rs.getInt("quantity"));
			e.setTamount(rs.getDouble("tamount"));
			e.setEmail(rs.getString("email"));
			e.setName(rs.getString("name"));
			e.setMobile(rs.getString("mobile"));
			e.setAddress(rs.getString("address"));
			e.setDate(rs.getString("Date"));
			e.setStatus(rs.getInt("status"));
			e.setOrderID(rs.getInt("orderID"));
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

	public int dispatchProduct(int status,int orderID) 
	{
		int y=0;
		   try {
			   Connection con=new LoginConnect().start();
			   	  PreparedStatement ps=con.prepareStatement("update order1 set status=? where orderId=?");//placeholder
			   	    ps.setInt(1,status);
			   	    ps.setInt(2, orderID);
				    y=ps.executeUpdate();
				   	   
		         }catch(Exception e)
			     {
			   	  System.out.println(e);
			     }

		   return y;
		
	}

	public int cancelProduct(int status,int orderID) //create function
	{
		int y=0;
		   try {
			   Connection con=new LoginConnect().start();//call connection
			   PreparedStatement ps=con.prepareStatement("update order1 set status=? where orderID=?");//placeholder
		   	    ps.setInt(1,status);//set value
		   	    ps.setInt(2, orderID);
			    y=ps.executeUpdate();//execute update query
			   	   
	         }catch(Exception e)
		     {
		   	  System.out.println(e);
		     }

	   return y;//return integer value
	}

	public ArrayList<Zeppy> Dispatchallview()//create function 
	{
		ArrayList<Zeppy> list=new ArrayList<>();//object creation
	try {	
	    Connection con=new LoginConnect().start();//call connection function
	    PreparedStatement ps=con.prepareStatement("select * from order1 where status='1' ORDER BY orderId ASC");//query
		ResultSet rs= ps.executeQuery();// method that return a Resultset object which contains the result returned by the execution query
	while(rs.next())
	{
		Zeppy e=new Zeppy();
		e.setProductID(rs.getInt("productID"));// get value with resultset object and with zeppy object we call setter function 
		e.setProductname(rs.getString("productname"));
		e.setPrice(rs.getDouble("price"));
		e.setDetails(rs.getString("details"));
		e.setImages(rs.getString("images"));
		e.setQuantity(rs.getInt("quantity"));
		e.setTamount(rs.getDouble("tamount"));
		e.setEmail(rs.getString("email"));
		e.setName(rs.getString("name"));
		e.setMobile(rs.getString("mobile"));
		e.setAddress(rs.getString("address"));
		e.setDate(rs.getString("Date"));
		e.setStatus(rs.getInt("Status"));
		
		list.add(e);
	}
		con.close();
		  }catch(SQLException  ex)
		{
			System.err.println(ex);
			ex.printStackTrace();
		}
	return list;//return list	
		
	}

	public ArrayList<Zeppy> CustomerViewStatus(String email) // create function
	{
		ArrayList<Zeppy> list=new ArrayList<>();//object creation
		try {	
		    Connection con=new LoginConnect().start();//call connection function
		    PreparedStatement ps=con.prepareStatement("select * from order1 where email=?");
		    ps.setString(1,email);
			ResultSet rs= ps.executeQuery();// method that return a Resultset object which contains the result returned by the execution query
		while(rs.next())
		{
			Zeppy e=new Zeppy();
			e.setProductID(rs.getInt("productID"));// get value with resultset object and with zeppy object we call setter function 
			e.setProductname(rs.getString("productname"));
			e.setPrice(rs.getDouble("price"));
			e.setDetails(rs.getString("details"));
			e.setImages(rs.getString("images"));
			e.setQuantity(rs.getInt("quantity"));
			e.setTamount(rs.getDouble("tamount"));
			e.setEmail(rs.getString("email"));
			e.setName(rs.getString("name"));
			e.setMobile(rs.getString("mobile"));
			e.setAddress(rs.getString("address"));
			e.setDate(rs.getString("Date"));
			e.setStatus(rs.getInt("Status"));
			
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

	public ArrayList<Zeppy> todayorderallview() //create function
	{
		ArrayList<Zeppy> list=new ArrayList<>();//object creation
		try {	
		    Connection con=new LoginConnect().start();
		    PreparedStatement ps=con.prepareStatement("select * from order1 where status='0' ORDER BY orderId ASC");//query
			ResultSet rs= ps.executeQuery();// method that return a Resultset object which contains the result returned by the execution query
		while(rs.next())
		{System.out.println("1dwdqwd");
			Zeppy e=new Zeppy();//object creation
			e.setProductID(rs.getInt("productID"));// get value with resultset object and with zeppy object we call setter function 
			e.setProductname(rs.getString("productname"));
			e.setPrice(rs.getDouble("price"));
			e.setDetails(rs.getString("details"));
			e.setImages(rs.getString("images"));
			e.setQuantity(rs.getInt("quantity"));
			e.setTamount(rs.getDouble("tamount"));
			e.setEmail(rs.getString("email"));
			e.setName(rs.getString("name"));
			e.setMobile(rs.getString("mobile"));
			e.setAddress(rs.getString("address"));
			e.setDate(rs.getString("Date"));
			e.setStatus(rs.getInt("Status"));
			
			list.add(e);//list add
		}
			con.close();//close connection
			  }catch(SQLException  ex)//handle exception
			{
				System.err.println(ex);//print exception
				ex.printStackTrace();//trace exception
			}
		return list;	
			
	}


}
