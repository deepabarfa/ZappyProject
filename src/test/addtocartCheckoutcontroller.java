package test;

import java.io.IOException;
import java.net.InetAddress;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import connect.Addtocartconnect;
import connect.UpdateConnect;

/**
 * Servlet implementation class addtocartCheckoutcontroller
 */
@WebServlet("/addtocartCheckoutcontroller")
public class addtocartCheckoutcontroller extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public addtocartCheckoutcontroller() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		
		String y=request.getParameter("op");
		
		
		if(y.equals("Checkout"))//if we click checkout button
		{
			 HttpSession ss=request.getSession();//if user already login 
			 String x=(String)ss.getAttribute("user");
			if(x==null)//check if its not then send url CheckoutCLogin.jsp
			{
			response.sendRedirect("CheckoutCLogin.jsp");
			}
			else// if user login then it go with servlet
			{
			response.sendRedirect("Allinfo");	
			}
		}
		if(y.equals("Delete"))//if we click delete button
		{	
			 HttpSession ss=request.getSession();//if user already login 
			 String x=(String)ss.getAttribute("user");
			if(x==null)//check if its not then send url CheckoutCLogin.jsp
			{
				InetAddress addr=InetAddress.getLocalHost();
		    	String ipadd=addr.getHostAddress();
				//String ipadd=request.getRemoteAddr();
				int p=Integer.parseInt(request.getParameter("productID"));//string to integer
				 Addtocartconnect cv=new Addtocartconnect();
				    int z=cv.removeProduct(p,ipadd);//database code
				     if(z==1)//check condition
				      {
				    	 System.out.println("hiiiiwrejw");
				    	 response.sendRedirect("index.jsp");//jump index.jsp page
				    	 //RequestDispatcher rd=request.getRequestDispatcher("index.jsp");
				 	  //request.setAttribute("LIST","Product removed from cart");
				 	  //rd.forward(request, response);	
				      }
			}
			else
			{
				String email=x;
				int pid=Integer.parseInt(request.getParameter("productID"));//string to integer
				 Addtocartconnect cv1=new Addtocartconnect();
				    int a=cv1.removeProductemail(pid,email);//database code
				     if(a==1)//check condition
				      {
				    	 response.sendRedirect("index.jsp");//jump index.jsp page
				    	 //RequestDispatcher rd=request.getRequestDispatcher("index.jsp");
				 	  //request.setAttribute("LIST","Product removed from cart");
				 	  //rd.forward(request, response);	
				      }
		 }
	}
		if(y.equals("update"))//if we click delete button
		{
			int quntity1=Integer.parseInt(request.getParameter("quantity"));
			int pid=Integer.parseInt(request.getParameter("productID"));//string to integer
			 Addtocartconnect cv=new Addtocartconnect();
			 int m=cv.updatequntityafteradd(pid,quntity1);
			 if(m==1)//check condition
		      {
		    	 response.sendRedirect("Addtocard");//jump index.jsp page
		    	 //RequestDispatcher rd=request.getRequestDispatcher("index.jsp");
		 	  //request.setAttribute("LIST","Product removed from cart");
		 	  //rd.forward(request, response);	
		      }
			 else
			 {
				 response.sendRedirect("Addtocard");//jump index.jsp page 
			 }
		}
		
	}}

