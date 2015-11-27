import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.RequestDispatcher;

import java.util.List;
import java.util.Iterator;
import org.apache.commons.fileupload.FileUploadException; 

import org.apache.commons.fileupload.FileItem; 
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import java.io.File;

import java.io.PrintWriter;

public class UploadTestServlet extends HttpServlet{
	public void doPost(HttpServletRequest req,HttpServletResponse res)throws ServletException,IOException{
		
		
		req.setCharacterEncoding("utf-8");
		
		String path = getServletContext().getRealPath("img");
		
		String resultPath = null;
		
		DiskFileItemFactory factory = new DiskFileItemFactory();
		ServletFileUpload sfu = new ServletFileUpload(factory);
		try{
			List list = sfu.parseRequest(req);
			Iterator it = list.iterator();
			while(it.hasNext()){
				FileItem item = (FileItem)it.next();
				
				if(!item.isFormField()){
					String fileName = item.getName();
					if((fileName!=null)&&(!fileName.equals(""))){
						fileName = (new File(fileName)).getName();
						
						item.write(new File(path+"\\"+fileName));
						
						resultPath="img/"+fileName;
					} 
				}
				
			}
		}catch(FileUploadException e){
			e.printStackTrace();
		}catch(Exception e){
			e.printStackTrace();
		}
		
		req.setAttribute("result",resultPath);
		
		RequestDispatcher dis = req.getRequestDispatcher("WEB-INF/jsp/result.jsp");
		dis.forward(req,res);
		
	}
}