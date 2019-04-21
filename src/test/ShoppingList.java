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
 * Servlet implementation class ShoppingList
 */
@WebServlet("/ShoppingList")
public class ShoppingList extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ShoppingList() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{

		PrintWriter out=response.getWriter();//Data to write on Console using PrintWriter. Java PrintWriter class is the implementation of Writer class.
		//It is used to print the formatted representation of objects to the text-output stream.and here we create object "out" 
		ProductViewConnect cv=new ProductViewConnect();//it is an class where we write database connectivity code and here we create object of that class and use.
		
		ArrayList<Zeppy> list=cv.productview();//using ArrayList we get all the data which in the list object. here Zappy is class where all the getter and setter function define. and productview() id function the is call by ProductViewConnect class object.
		
		  RequestDispatcher rd=request.getRequestDispatcher("Front.jsp");//servlet2 is the url-pattern of the second servlet 
		  request.setAttribute("LIST", list);//send the data also
		   rd.forward(request, response);//method may be include or forward  
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{	
	}

}
