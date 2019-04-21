package test;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import connect.CustomerConnect;
import zappyinfo.Zeppy;

/**
 * Servlet implementation class ViewCustomerProfile
 */
@WebServlet("/ViewCustomerProfile")
public class ViewCustomerProfile extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ViewCustomerProfile() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		CustomerConnect ed=new CustomerConnect();//create clas object
	    Zeppy p=new Zeppy();
	     HttpSession ss=request.getSession();
	     String email1=(String)ss.getAttribute("user");
	     System.out.println("Edit profile"+email1);
	     p=ed.viewProfileUpdate(email1);//in viewProfileupdate method write update code(database code)
	  RequestDispatcher rd=request.getRequestDispatcher("ViewCustomerprofile.jsp");//send response to jsp page
	  request.setAttribute("c", p);
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
