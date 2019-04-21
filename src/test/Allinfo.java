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

import connect.Addtocartconnect;
import connect.RegistrationConnect;
import zappyinfo.Zeppy;

/**
 * Servlet implementation class Allinfo
 */
@WebServlet("/Allinfo")
public class Allinfo extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Allinfo() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		PrintWriter out=response.getWriter();//Data to write on Console using PrintWriter. Java PrintWriter class is the implementation of Writer class.
		//It is used to print the formatted representation of objects to the text-output stream.and here we create object "out" 
		
		RegistrationConnect cv=new RegistrationConnect();
			HttpSession ss=request.getSession();//The HttpSession object represents a user session.
			//A user session contains information about the user across multiple HTTP requests. 
			//When a user enters your site for the first time, the user is given a unique ID to identify his session by.
			//This ID is typically stored in a cookie or in a request parameter.
		String name=(String) ss.getAttribute("user");
		
		ArrayList<Zeppy> list=cv.registrationview(name);//its reprsent the all user registration details 
		
		Addtocartconnect cv1=new Addtocartconnect();//object creation
		
		ArrayList<Zeppy> list1=cv1.viewaddcartemail(name);//it shows all addtocart (database code here) 
		
			if(list1!=null)
			{
				RequestDispatcher rd1=request.getRequestDispatcher("allinfo.jsp");	//go allingo.jsp 			 
				request.setAttribute("LIST1", list1);//for addtocart		
				request.setAttribute("LIST", list);//for registration
				rd1.forward(request, response);
				
			}
			
		}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
