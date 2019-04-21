package test;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import connect.OrderConnect;

/**
 * Servlet implementation class AdminApproveOperation
 */
@WebServlet("/AdminApproveOperation")
public class AdminApproveOperation extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminApproveOperation() {
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
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String op=request.getParameter("op");//get value from jsp
	    if(op.equals("Dispatch"))//if we want to dispatch
	    { 
	    	int y=0;
	    	int pid=Integer.parseInt(request.getParameter("productID"));//get product id
	    	String pname=request.getParameter("productname");//product name
	    	String email=request.getParameter("email");
	    	int oid=Integer.parseInt(request.getParameter("orderID"));//get orderid id
	    	int status=1;
	    	OrderConnect oc=new OrderConnect();//class object
	         y=oc.dispatchProduct(status,oid);//database code
	       if(y!=0)
	       {
		  	 RequestDispatcher rd=request.getRequestDispatcher("DispatcheListController");
		  	 request.setAttribute("msg", pname+" Order is dispatched");
		  	 rd.forward(request,response);
	       }
	    }
	    else if(op.equals("Cancel"))//if we want to cancle product
	    {
	    	int pid=Integer.parseInt(request.getParameter("productID"));//get product id
	     	String pname=request.getParameter("productname");
	     	String email=request.getParameter("email");
	     	int oid=Integer.parseInt(request.getParameter("orderID"));//get orderid id
	    	int status=2;
	        int y=0;
	        OrderConnect oc=new OrderConnect();
	         y=oc.cancelProduct(status,oid);//database code
	       if(y!=0)
	       {
		 	
	    	   RequestDispatcher rd=request.getRequestDispatcher("DispatcheListController");
			  	 request.setAttribute("msg", pname+" Order is cancelled");
			  	 rd.forward(request,response); }	
	    }
	    
	}

}
