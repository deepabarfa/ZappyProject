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

import connect.ProductViewConnect;
import zappyinfo.Zeppy;

/**
 * Servlet implementation class ViewproductDetailsController
 */
@WebServlet("/ViewproductDetailsController")
public class ViewproductDetailsController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ViewproductDetailsController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out=response.getWriter();
		//Data to write on Console using PrintWriter. Java PrintWriter class is the implementation of Writer class.
		//It is used to print the formatted representation of objects to the text-output stream.and here we create object "out" 
		
		int pid=Integer.parseInt(request.getParameter("productID"));//get value from jsp and convert into integer value because it store in database integer form 
		ProductViewConnect cv=new ProductViewConnect();
		ArrayList<Zeppy> list=cv.productDetailsview(pid);//database code, its take value from database
		  RequestDispatcher rd=request.getRequestDispatcher("ViewproductDetails.jsp");
		  request.setAttribute("LIST", list);
		out.println(list);
		  
		   rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		
	}

}
