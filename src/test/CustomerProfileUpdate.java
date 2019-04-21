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

import connect.RegistrationConnect;

/**
 * Servlet implementation class CustomerProfileUpdate
 */
@WebServlet("/CustomerProfileUpdate")
public class CustomerProfileUpdate extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CustomerProfileUpdate() {
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
		PrintWriter out=response.getWriter();
		String email1=request.getParameter("email");//get value from jsp page
		System.out.println("Parameter"+email1);
		String name1=request.getParameter("name");
		String city1=request.getParameter("city");
		String state1=request.getParameter("state");
		String pin1=request.getParameter("pin");
		String mobile1=request.getParameter("mobile");
		//String password1=request.getParameter("password");
		String address1=request.getParameter("address");
		System.out.println("email1"+email1);
		HttpSession ss=request.getSession();
		String email=(String)ss.getAttribute("user");
		System.out.println("email"+email);
	    RegistrationConnect cc=new RegistrationConnect();//class object creation
	    int y=cc.updateprofile(email1,name1,city1,state1,pin1,mobile1,address1);//this method used to connect database and here write update query 
	    if(y==1)
	    {
	    	RequestDispatcher rd=request.getRequestDispatcher("CHome.jsp");
	    	//Defines an object that receives requests from the client and sends them to any resource (such as a servlet, HTML file, or JSP file) on the server. 
	    	//The servlet container creates the RequestDispatcher object,
	    	// which is used as a wrapper around a server resource located at a particular path or given by a particular name.
	    	
			  request.setAttribute("msg","profile updated");//show msg
			  rd.forward(request, response);
		}
		else
		{
			 RequestDispatcher rd=request.getRequestDispatcher("editprofile.jsp");//go url in editprofile.sp page with massage 
			  request.setAttribute("msg","not updated");
			  rd.forward(request, response);
		}
	}

}
