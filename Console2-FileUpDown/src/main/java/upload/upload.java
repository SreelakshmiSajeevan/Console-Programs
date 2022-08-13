package upload;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

/**
 * Servlet implementation class upload
 */
@WebServlet("/upload")
public class upload extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public upload() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	String U = System.getProperty("user.home") ;
	File f=new File(U+ File.separator +"image"+File.separator);
    if(!f.exists())
    {
      f.mkdir();
    }
    else{
        System.out.println("Already present!");
    }
	 System.out.println(U);
	
		if(ServletFileUpload.isMultipartContent(request)){
		try {
		List<FileItem> multiparts = new ServletFileUpload(new DiskFileItemFactory()).parseRequest(request);
		for(FileItem item : multiparts){
		if(!item.isFormField()){
		String name = new File(item.getName()).getName();
		 System.out.println(U);
		item.write( new File(U+ File.separator +"image"+File.separator + name));
		 System.out.println(U);
		}else{
			String n=item.getFieldName();
			if(n.equals("age")){
				item.getString();
			}
		}
		}
		//File uploaded successfully
		System.out.println("File Uploaded Successfully");
		request.setAttribute("message", "File Uploaded Successfully");
        response.sendRedirect("fileupload.html");
		} catch (Exception ex) {
		request.setAttribute("message", "File Upload Failed due to " + ex);
		}
		}
		else
		{
		request.setAttribute("message","Sorry this Servlet only handles file upload request");
		}
	}
	/*https://www.codejava.net/coding/upload-files-to-database-servlet-jsp-mysql -another way to file upload*/

}
