package test;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import connect.RegistrationConnect;




@WebServlet("/Registration")
public class Registration extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Registration() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		  // Recipient's email ID needs to be mentioned.
		
		PrintWriter out=response.getWriter();
		////Data to write on Console using PrintWriter. Java PrintWriter class is the implementation of Writer class.
		//It is used to print the formatted representation of objects to the text-output stream.and here we create object "out" 
		String to1=request.getParameter("email");//get all value from jsp page for insert database which is given by user self identity
		String name1=request.getParameter("name");
		String lastname1=request.getParameter("lastname");
		String city1=request.getParameter("city");
		String state1=request.getParameter("state");
		String pin1=request.getParameter("pin");
		String address1=request.getParameter("address");
		String mobile1=request.getParameter("mobile");
		String password1=request.getParameter("password");
		
	    
	    HttpSession ss=request.getSession();//set session
	    //The HttpSession object represents a user session.
	    // A user session contains information about the user across multiple HTTP requests. 
	    //When a user enters your site for the first time, the user is given a unique ID to identify his session by. 
	    //This ID is typically stored in a cookie or in a request parameter.
	    ss.setAttribute("user",to1);
		
	    RegistrationConnect cc=new RegistrationConnect();
	    int y=cc.insert(to1,name1,lastname1, city1, state1, pin1,address1, mobile1,password1);
	    if(y==1)//if query successfully execute then
 		{//we want to send a massage after registration
 		  String to=to1;
		  String sub="Account Creation & Password";
	      long p=System.currentTimeMillis();//439807598430759083
	      String msg="Welcome at out site and your password="+password1;
	      // Sender's email ID needs to be mentioned
	      String from = "deepapatel1920@gmail.com";
	      final String username = "deepapatel1920@gmail.com";//change accordingly
	      final String password = "d&$@769491";//change accordingly

	      // Assuming you are sending email through relay.jangosmtp.net
	      String host = "smtp.gmail.com";

	      Properties props = new Properties();
	      props.put("mail.smtp.auth", "true");
	      props.put("mail.smtp.starttls.enable", "true");
	      props.put("mail.smtp.host", host);
	      props.put("mail.smtp.port", "587");

	      // Get the Session object.
	      Session session = Session.getInstance(props,
	      new javax.mail.Authenticator() {
	         protected PasswordAuthentication getPasswordAuthentication() {
	            return new PasswordAuthentication(username, password);
	         }
	      });

	      try {	    	  
	    	// Create a default MimeMessage object.
		         Message message = new MimeMessage(session);

		         // Set From: header field of the header.
		         message.setFrom(new InternetAddress(from));

		         // Set To: header field of the header.
		         message.setRecipients(Message.RecipientType.TO,
		         InternetAddress.parse(to));

		         // Set Subject: header field
		         message.setSubject(sub);

		         // Now set the actual message
		         message.setText(msg);

		         // Send message
		         
		         Transport.send(message);
	      } catch (MessagingException e) {
	    	  e.printStackTrace();
	    	     }
			//response.sendRedirect("CheckoutCLogin.jsp");
			RequestDispatcher rd=request.getRequestDispatcher("CutomerLogin.jsp");
			request.setAttribute("msg", "succesfully register");
			rd.forward(request, response);
		}
		else
		{
			RequestDispatcher rd=request.getRequestDispatcher("registration.jsp");
			request.setAttribute("msg", "please carefully insert");
			rd.forward(request, response);
		}
	    }
}
