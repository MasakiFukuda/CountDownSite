import java.io.IOException;
import javax.servlet.ServletException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.PrintWriter;

public class MailServlet extends HttpServlet{
	public void doPost(HttpServletRequest req,HttpServletResponse res)throws ServletException,IOException{
		req.setCharacterEncoding("utf-8");
		String toAdd = req.getParameter("toadd");
		String title = req.getParameter("title");
		String mess = req.getParameter("mess");
		
		Mailler mailler = new GMailler();
		mailler.setAddress("rabbit.lover.rop@gmail.com");
		mailler.setAccount("rabbit.lover.rop@gmail.com");
		mailler.setPass("passtest");
		
		String result=mailler.sendMail(toAdd,title,mess);
		
		res.setContentType("text/html;charset=utf-8");
		PrintWriter out = res.getWriter();
		out.println("<html>");
		out.println("<head><title>result</title></head>");
		out.println("<body>");
		
		out.println("<h1>"+result+"</h1>");
		
		out.println("</body>");
		out.println("</html>");
	}
}