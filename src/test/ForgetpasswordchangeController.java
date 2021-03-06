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

import connect.LoginConnect;
import zappyinfo.Zeppy;

/**
 * Servlet implementation class ForgetpasswordchangeController
 */
@WebServlet("/ForgetpasswordchangeController")
public class ForgetpasswordchangeController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ForgetpasswordchangeController() {
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
		String pwd=request.getParameter("password");
		System.out.println("hiip");
		HttpSession ss=request.getSession();
		String email=(String)ss.getAttribute("puser");
		Zeppy e1=new Zeppy();//admin class object creation
		LoginConnect lc=new LoginConnect();
		int y=lc.forgetpassword(pwd,email);
		if(y!=0)
		{
			String to=email;
			  String sub="Account Creation & Password";
		      long p=System.currentTimeMillis();//439807598430759083
		      String msg="Welcome at out site and your password is reset="+pwd;
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
		      RequestDispatcher rd=request.getRequestDispatcher("CutomerLogin.jsp");
				request.setAttribute("msg1","password is changed sussessfully....you can check your mail");
				rd.forward(request, response);
		 		}
		else
		{
			RequestDispatcher rd=request.getRequestDispatcher("emailconfirmpasswordupdate.jsp");
			request.setAttribute("msg1","Not updated password");
			rd.forward(request, response);
		}
	}

}
