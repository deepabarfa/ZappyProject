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
import connect.OrderConnect;

/**
 * Servlet implementation class OrderController
 */
@WebServlet("/OrderController")
public class OrderController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public OrderController() {
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
		HttpSession ss=request.getSession();
		String id=(String)ss.getAttribute("user");//get user identity with session
		//if user already login then 
		String y=request.getParameter("op");
		if(y.equals("Order Now"))//if we click order now
		{
			if(id==null)//if user not login then
			{
				response.sendRedirect("CheckoutCLogin.jsp");//first login and user go first checkoutClogin.jsp
				//RequestDispatcher rd=request.getRequestDispatcher("CheckoutCLogin.jsp");
			}
			else//if user already login
			{
				OrderConnect oc=new OrderConnect();
				String email=id;//take value from session
				//String name1=request.getParameter("name");
				//String address1=request.getParameter("address");
				//String mobile1=request.getParameter("mobile");
				//int mobile2=Integer.parseInt(mobile1);
				System.out.println(email);
				String productID1=request.getParameter("productID");//get value from jsp page
				int productID2=Integer.parseInt(productID1);//convert into integer
				System.out.println(productID2);
				
				InetAddress addr=InetAddress.getLocalHost();
		    	String ipadd=addr.getHostAddress();
				//String ipadd=request.getRemoteAddr();
				int p=oc.buyproduct(email,productID2,ipadd);//database code here
				if(p!=0)
		 	     {
			  RequestDispatcher rd=request.getRequestDispatcher("CHome.jsp");
		 	  request.setAttribute("msg", "order successfully placed");//response send with msg in CHome.jsp page
		 	  rd.forward(request, response);
		 	     }
			}
			
		}
		if(y.equals("update"))//if we click update
		{
			int quntity1=Integer.parseInt(request.getParameter("quantity"));
			int pid=Integer.parseInt(request.getParameter("productID"));//string to integer
			 Addtocartconnect cv=new Addtocartconnect();
			 int m=cv.updatequntityafteradd(pid,quntity1);
			 if(m==1)//check condition
		      {
		    	 response.sendRedirect("Allinfo");//jump index.jsp page
		    	 //RequestDispatcher rd=request.getRequestDispatcher("index.jsp");
		 	  //request.setAttribute("LIST","Product removed from cart");
		 	  //rd.forward(request, response);	
		      }
			 else
			 {
				 response.sendRedirect("Allinfo");//jump index.jsp page 
			 }
		}
		if(y.equals("Delete"))//if we click Delete
		{
			String email=id;
			int pid=Integer.parseInt(request.getParameter("productID"));//string to integer
			 Addtocartconnect cv1=new Addtocartconnect();
			    int a=cv1.removeProductemail(pid,email);//database code
			     if(a==1)//check condition
			      {
			    	 response.sendRedirect("Allinfo");//jump index.jsp page
			    	 //RequestDispatcher rd=request.getRequestDispatcher("index.jsp");
			 	  //request.setAttribute("LIST","Product removed from cart");
			 	  //rd.forward(request, response);	
			      }
		}
	}

}
