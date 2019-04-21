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

/**
 * Servlet implementation class LoginControllerr
 */
@WebServlet("/LoginControllerr")
public class LoginControllerr extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginControllerr() {
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
		PrintWriter out=response.getWriter();
		//Data to write on Console using PrintWriter. Java PrintWriter class is the implementation of Writer class.
		//It is used to print the formatted representation of objects to the text-output stream.and here we create object "out" 
		String user=request.getParameter("uid");//get value
		String pwd=request.getParameter("password");
		HttpSession ss=request.getSession();//admin set identity with session
		ss.setAttribute("uid", user);
		
		LoginConnect lc=new LoginConnect();
		int y=lc.check(user, pwd);//check entered id password by user correct or not
		if(y==1)//if yes
		{
			response.sendRedirect("AdminHome.jsp");//send response to adminhome.jsp
		}
		else//if no
		{
			RequestDispatcher rd=request.getRequestDispatcher("adminlogin.jsp");//we need to try again
			request.setAttribute("msg","login fail,try again");
			rd.forward(request, response);
		}
	  
	}

}
