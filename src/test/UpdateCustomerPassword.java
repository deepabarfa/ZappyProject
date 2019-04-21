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
 * Servlet implementation class UpdateCustomerPassword
 */
@WebServlet("/UpdateCustomerPassword")
public class UpdateCustomerPassword extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateCustomerPassword() {
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
		HttpSession ss=request.getSession();
		String email=(String)ss.getAttribute("user");
		
		String Currentpassword=request.getParameter("current");
		String pwd=request.getParameter("password");
	    String pass="";
		System.out.println("hiip");
		LoginConnect lc=new LoginConnect();
		int y=lc.updateCustomerPassword(email, pwd,pass,Currentpassword);
		if(y==1)
		{
			//response.sendRedirect("updatedStatus.jsp");
			RequestDispatcher rd=request.getRequestDispatcher("Customerpasswordupdate.jsp");
			request.setAttribute("msg1","Successfully updated password");
			rd.forward(request, response);
		}
		else
		{
			//response.sendRedirect("adminprofileupdate.jsp");
			RequestDispatcher rd=request.getRequestDispatcher("Customerpasswordupdate.jsp");
			request.setAttribute("msg1","Not updated ,Because old password is Wrong enterd");
			rd.forward(request, response);
		}
	  
		
		
	}

}
