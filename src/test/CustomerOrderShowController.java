package test;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import connect.OrderConnect;
import connect.ProductViewConnect;
import zappyinfo.Zeppy;

/**
 * Servlet implementation class CustomerOrderShowController
 */
@WebServlet("/CustomerOrderShowController")
public class CustomerOrderShowController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CustomerOrderShowController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		PrintWriter out=response.getWriter();
		//Data to write on Console using PrintWriter. Java PrintWriter class is the implementation of Writer class.
		//It is used to print the formatted representation of objects to the text-output stream.and here we create object "out" 
		OrderConnect oc=new OrderConnect();
		HttpSession ss=request.getSession();
		String id=(String)ss.getAttribute("user");//The HttpSession object represents a user session.
		//A user session contains information about the user across multiple HTTP requests. 
		//When a user enters your site for the first time, the user is given a unique ID to identify his session by.
		//This ID is typically stored in a cookie or in a request parameter.
		ArrayList<Zeppy> list=oc.orderview(id);//for database connectivity
		  RequestDispatcher rd=request.getRequestDispatcher("ShowOrder.jsp"); //go jsp page
		  request.setAttribute("LIST", list);
		   rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
