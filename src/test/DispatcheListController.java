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
 * Servlet implementation class DispatcheListController
 */
@WebServlet("/DispatcheListController")
public class DispatcheListController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DispatcheListController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out=response.getWriter();
		//Data to write on Console using PrintWriter. Java PrintWriter class is the implementation of Writer class.
		//It is used to print the formatted representation of objects to the text-output stream.
		//and here we create object "out" 
		OrderConnect oc=new OrderConnect();
		int status=0;
		ArrayList<Zeppy> list=oc.orderDispatchecancelview(status);//show the list of value which is pending 
		String msg=(String)request.getAttribute("msg");
		  RequestDispatcher rd=request.getRequestDispatcher("Dispatchcancel.jsp");//send response to jsp page
		  request.setAttribute("LIST", list);
		  request.setAttribute("msg", msg);
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
