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
 * Servlet implementation class ForgetpasswordController
 */
@WebServlet("/ForgetpasswordController")
public class ForgetpasswordController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ForgetpasswordController() {
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
		String Currentemail=request.getParameter("youremail");
		System.out.println("hiip");
		Zeppy e1=new Zeppy();//admin class object creation
		LoginConnect lc=new LoginConnect();
		e1=lc.checkemailexist(Currentemail);	
		if(e1!=null)
	 		{
			 HttpSession ss=request.getSession();//set session or user identity
		        ss.setAttribute("puser",Currentemail);
	 		  String to=Currentemail;
			  String sub="Account Creation & Password";
		      long p=System.currentTimeMillis();//439807598430759083
		      //String msg="http://localhost:8080/FileUploadDemo/emailconfirmpasswordupdate.jsp";
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
		    	  
		    	  String link ="http://localhost:8080/FileUploadDemo/emailconfirmpasswordupdate.jsp";
		          
		          StringBuilder bodyText = new StringBuilder(); 
		            bodyText.append("<div>")
		                 .append("  Dear User<br/><br/>")
		                 .append("  Thank you for registration. Your mail ("+to+") is under verification<br/>")
		                 .append("  Please click <a href=\""+link+"\">here</a> or open below link in browser<br/>")
		                 .append("  <a href=\""+link+"\">"+link+"</a>")
		                 .append("  <br/><br/>")
		                 .append("  Thanks,<br/>")
		                 .append("  SodhanaLibrary Team")
		                 .append("</div>");
		    	  
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
		         message.setContent(bodyText.toString(),"text/html; charset=utf-8");

		         // Send message
		         
		         Transport.send(message);
		        
		         	
		      } catch (MessagingException e) {
		    	  e.printStackTrace();
		    	     }
		      response.sendRedirect("updatedStatus.jsp");
		 		}
		else
		{
			//response.sendRedirect("updatedStatus.jsp");
			RequestDispatcher rd=request.getRequestDispatcher("Forgetpassword.jsp");
			request.setAttribute("msg","Not updated ,Because email is not exist");
			rd.forward(request, response);
		}
	}

}
