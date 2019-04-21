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

import connect.OrderConnect;
import zappyinfo.Zeppy;

/**
 * Servlet implementation class ViewDispatcheListController
 */
@WebServlet("/ViewDispatcheListController")
public class ViewDispatcheListController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ViewDispatcheListController() {
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
		OrderConnect oc=new OrderConnect();
		
		ArrayList<Zeppy> list=oc.Dispatchallview();//database code, take value from database in arraylist
		  RequestDispatcher rd=request.getRequestDispatcher("ShowDispatchallOrder.jsp");//url
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
