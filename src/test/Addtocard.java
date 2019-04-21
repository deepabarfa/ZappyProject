package test;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import connect.Addtocartconnect;
import connect.ProductViewConnect;
import connect.UpdateConnect;
import zappyinfo.Zeppy;

/**
 * Servlet implementation class Addtocard
 */
@WebServlet("/Addtocard")
public class Addtocard extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Addtocard() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out=response.getWriter();//Data to write on Console using PrintWriter. Java PrintWriter class is the implementation of Writer class.
		//It is used to print the formatted representation of objects to the text-output stream.and here we create object "out" 
		Addtocartconnect cv=new Addtocartconnect();//class object creation for connecting with database 
		
		InetAddress addr=InetAddress.getLocalHost();
    	String ipadd=addr.getHostAddress();
		// This class represents an Internet Protocol (IP) address. 
    	//Applications should use the methods getLocalHost , getByName , or getAllByName to create a new InetAddress instance. ... 
    	//Determines all the IP addresses of a host, given the host's name.
		HttpSession ss=request.getSession();
		 String x=(String)ss.getAttribute("user");//get identity of user
		 //check user login or not
if(x==null)//if user not login
{
		ArrayList<Zeppy> list=cv.viewaddcart(ipadd);//for view data in jsp page //using ArrayList we get all the data which in the list object. here Zeppy is class where all the getter and setter function define. and productview() id function the is call by ProductViewConnect class object.
		  RequestDispatcher rd=request.getRequestDispatcher("Viewaddtocart.jsp");//servlet2 is the url-pattern of the second servlet
		  request.setAttribute("LIST", list);
		out.println(list);//send the data also
		   rd.forward(request, response);//method may be include or forward
}
else
{
	String email=x;
	ArrayList<Zeppy> list=cv.viewaddcartemail(email);//for view data in jsp page //using ArrayList we get all the data which in the list object. here Zeppy is class where all the getter and setter function define. and productview() id function the is call by ProductViewConnect class object.
	  RequestDispatcher rd=request.getRequestDispatcher("Viewaddtocart.jsp");//servlet2 is the url-pattern of the second servlet
	  request.setAttribute("LIST", list);
	out.println(list);//send the data also
	   rd.forward(request, response);//method may be include or forward	
}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		PrintWriter out=response.getWriter();//Data to write on Console using PrintWriter. Java PrintWriter class is the implementation of Writer class.
		//It is used to print the formatted representation of objects to the text-output stream.and here we create object "out" 

		int p=Integer.parseInt(request.getParameter("productID"));//get data from jsp page it is always in the string
		//Integer.parseInt method use for convert into integer value  
		String quantity=request.getParameter("quantity");
		String y=request.getParameter("work");
		 double price=Double.parseDouble(request.getParameter("price"));//Double.parseDouble method use for convert into string (casting)
	     int quantity1=Integer.parseInt(quantity);
	     
	     double tamount= quantity1*price;//logic for get total amount
	     System.out.println(tamount);
	     
	     InetAddress addr=InetAddress.getLocalHost();
	    	String ipadd=addr.getHostAddress();//this method get the ipaddress
	    	
	    	HttpSession ss=request.getSession();
			 String x=(String)ss.getAttribute("user");//get identity of user
			 //check user login or not
	if(x==null)//if user not login
	{
		if(y.equals("Addtocart"))//if we click addtocart
		{
			Addtocartconnect ac=new Addtocartconnect();
			
			int f=ac.checkpidexist(p,quantity1,ipadd);
			if(f==0) 
			{
			
			int z=ac.addtocart(p,ipadd,quantity1,tamount);//go with class object in database code
			if(z==1)
	         {
				RequestDispatcher rd=request.getRequestDispatcher("index.jsp");//its send url index.jsp page
				request.setAttribute("msg","Successfully add product");//and show massage
				rd.forward(request, response);
	         }
			}
			else 
			{
				
				RequestDispatcher rd=request.getRequestDispatcher("index.jsp");//its send url index.jsp page
				request.setAttribute("msg","not add product");//and show massage
				rd.forward(request, response);
				
			}
			
		}
		
	}
	else//if user login
	{
		if(y.equals("Addtocart"))//if we click addtocart	
		{
			String email=x;//take value in email by session
			Addtocartconnect ac2=new Addtocartconnect();//object creation
			
			int f=ac2.checkpidexistEmail(p,quantity1,email);
			if(f==0) 
			{
			int z=ac2.addtocartemail(p,email,quantity1,tamount);//go with class object in database code
			if(z==1)
			{
				
				RequestDispatcher rd=request.getRequestDispatcher("index.jsp");//its send url index.jsp page
				request.setAttribute("msg","Successfully add product");//and show massage
				rd.forward(request, response);
	         }
			
			}
			else {
				
				RequestDispatcher rd=request.getRequestDispatcher("index.jsp");//its send url index.jsp page
				request.setAttribute("msg","Successfully add product");//and show massage
				rd.forward(request, response);
				}
			}	
	}
	
}
}
