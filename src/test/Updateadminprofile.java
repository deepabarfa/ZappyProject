package test;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import connect.LoginConnect;
import connect.UpdateConnect;
import zappyinfo.admin;

/**
 * Servlet implementation class Updateadminprofile
 */
@WebServlet("/Updateadminprofile")
public class Updateadminprofile extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Updateadminprofile() {
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
		//String uid1=request.getParameter("uid");
		HttpSession ss=request.getSession();
	    String uid1=(String) ss.getAttribute("uid");
	    //The HttpSession object represents a user session.
	   // A user session contains information about the user across multiple HTTP requests.
	    //When a user enters your site for the first time, the user is given a unique ID to identify his session by.
	    //This ID is typically stored in a cookie or in a request parameter.
		UpdateConnect uc=new UpdateConnect();
		admin z=new admin();
		z=uc.adminupdate(uid1);//datbase code
		RequestDispatcher rd=request.getRequestDispatcher("adminprofileupdate.jsp");
		  request.setAttribute("msg",z);
		  rd.forward(request, response);
	}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		PrintWriter out=response.getWriter();
		//String user=request.getParameter("uid");
		String Currentpassword=request.getParameter("current");
		String pwd=request.getParameter("password");
		HttpSession ss=request.getSession();
	    String uid1=(String) ss.getAttribute("uid");
	    String pass="";
		System.out.println("hiip");
		LoginConnect lc=new LoginConnect();
		int y=lc.updateap(uid1, pwd,pass,Currentpassword);
		if(y==1)
		{
			//response.sendRedirect("updatedStatus.jsp");
			RequestDispatcher rd=request.getRequestDispatcher("adminprofileupdate.jsp");
			request.setAttribute("msg","Successfully updated password");
			rd.forward(request, response);
		}
		else
		{
			//response.sendRedirect("adminprofileupdate.jsp");
			RequestDispatcher rd=request.getRequestDispatcher("adminprofileupdate.jsp");
			request.setAttribute("msg","Not updated ,Because old password is Wrong enterd");
			rd.forward(request, response);
		}
	  
	}
	}
