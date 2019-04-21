package test;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Iterator;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

/**
 * Servlet implementation class UploadProduct
 */
@WebServlet("/UploadProduct")
public class UploadProduct extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	
	   private String filePath;
	   private int maxFileSize = 1000 * 4096;
	   private int maxMemSize = 100 * 4096;
	   private File file ;


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		  response.setContentType("text/html");
		  PrintWriter out = response.getWriter();
		  //Data to write on Console using PrintWriter. Java PrintWriter class is the implementation of Writer class.
//It is used to print the formatted representation of objects to the text-output stream.and here we create object "out" 
		  boolean isMultipart = ServletFileUpload.isMultipartContent(request);
      
	  if( !isMultipart ){
             return;
      }
		  
      DiskFileItemFactory factory = new DiskFileItemFactory();
      // maximum size that will be stored in memory
      factory.setSizeThreshold(maxMemSize);
      // Location to save data that is larger than maxMemSize.
     
      // Create a new file upload handler
      ServletFileUpload upload = new ServletFileUpload(factory);
      // maximum file size to be uploaded.
      upload.setSizeMax( maxFileSize );

      try{

      // Parse the request to get file items.
      List fileItems = upload.parseRequest(request);

      // Process the uploaded file items
      Iterator i = fileItems.iterator();
      
      String productname=null;
      String price=null;
      String weight=null;
      String details=null;
     String filename=null;
      
      while ( i.hasNext())
      {

         FileItem fi = (FileItem)i.next();
         if ( fi.isFormField () )
         {
            // Get the uploaded file parameters
           String  fieldName = fi.getFieldName();
           if(fieldName.equals("productname"))
             {
        	  productname=fi.getString();
              System.out.println(productname);
             }
           if(fieldName.equals("price"))
           {
        	   price=fi.getString();
            System.out.println(price);
           }
           if(fieldName.equals("weight"))
           {
      	  weight=fi.getString();
            System.out.println(weight);
           }
           if(fieldName.equals("details"))
           {
      	  details=fi.getString();
            System.out.println(details);
           }
         }
         else
          {    
        	 String fieldName = fi.getFieldName();

            if(fieldName.equals("file"))
            {
             ServletConfig sc=getServletConfig();
             String field=fi.getString();
             String contentType = fi.getContentType();
             filename=fi.getName();
              boolean isInMemory = fi.isInMemory();
              long sizeInBytes = fi.getSize();

              //create folder
              File f = new File(sc.getServletContext().getRealPath("/")+"images/") ;
                 if(!f.exists())
                	 f.mkdir();
              // Write the file
              file = new File(sc.getServletContext().getRealPath("/")+"images/"+filename) ;
               fi.write( file ) ;
              out.println("Uploaded Filename: " +filename + "<br>");
            System.out.println("PATH="+file.getPath());
            }
         }
      }

   
      try {
    	  Class.forName("com.mysql.jdbc.Driver");//load the jdbc suitable connection loads com.mysql.jdbc.Driver into memory
       	  //below establish the connection with specific language it may be mysql, oracle etc.
    	  Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/zappy","root","");

    	  PreparedStatement ps=con.prepareStatement("insert into upload(productname,price,weight,details,images) value(?,?,?,?,?)");//insert query
    	    ps.setString(1,productname);//set value
    	    ps.setDouble(2,Double.parseDouble(price));
    	    ps.setString(3,weight);
    	    ps.setString(4,details);
    	    ps.setString(5,filename);
    	    int y=0;y=ps.executeUpdate();
    	    if(y!=0)
    	    {
    	    	RequestDispatcher rd=request.getRequestDispatcher("upload.jsp");
			request.setAttribute("msg","Sucssesfully product upload");
			rd.forward(request, response);
    	    }
      }catch(Exception e)
      {
    	  System.out.println(e);
      }
      }
      catch(Exception ex)
      {
        ex.printStackTrace();
       System.out.println(ex);
       }
	}
}
