package test;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import zappyinfo.Zeppy;

/**
 * Servlet implementation class PicupdateController
 */
@WebServlet("/PicupdateController")
public class PicupdateController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	 private String filePath;
	   private int maxFileSize = 1000 * 4096;
	   private int maxMemSize = 100 * 4096;
	   private File file ;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public PicupdateController() {
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
		 response.setContentType("text/html");
		  PrintWriter out = response.getWriter();
		  Zeppy z=new Zeppy();
		  boolean isMultipart = ServletFileUpload.isMultipartContent(request);
		System.out.println("Heellllllooooo  111");
		  if( !isMultipart ){
          return;}
			//System.out.println("Heellllllooooo  222");		  
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
  String productID=null;
   
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
        if(fieldName.equals("productID"))
        {
   	  productID=fi.getString();
         System.out.println();
        }
        System.out.println("Heellllllooooo  111");
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
       }}
   try 
	{
   	 Class.forName("com.mysql.jdbc.Driver");//load the jdbc suitable connection loads com.mysql.jdbc.Driver into memory
  	  Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/zappy","root","");//establish the connection with specific language it may be mysql, oracle etc.
	PreparedStatement ps=con.prepareStatement("update upload set images=? where productID=?");//write update query
	System.out.print("deee");
	//ps.setString(1, productname);//set value
	//ps.setDouble(2,Double.parseDouble(price));
	//ps.setString(3, weight);
	//ps.setString(4, details);
	ps.setString(1,filename);
	
	System.out.println("product id ======"+productID);
	ps.setInt(2,Integer.parseInt(productID));
	int x=0;
	x=ps.executeUpdate();//query executed
	System.out.println(x);
			 if(x!=0)//if successfully query executed
				{
				response.sendRedirect("ProductView");// send response to productview servlet
				}
			 
	}catch(Exception e)//handle exception
         {
       	 System.out.println(e);
       	 e.printStackTrace();
         }
   }
   catch(Exception ex)
   {
       ex.printStackTrace();
      System.out.println(ex);
  }
	}
	}
