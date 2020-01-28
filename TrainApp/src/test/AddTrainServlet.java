package test;
import javax.servlet.*;
import java.io.*;
import javax.servlet.http.*;
@SuppressWarnings("serial")
public class AddTrainServlet extends HttpServlet {
	public void doPost(HttpServletRequest req,HttpServletResponse res)throws ServletException,IOException{
PrintWriter pw=res.getWriter();
res.setContentType("text/html");
Cookie ck[]=req.getCookies();
if(ck==null) {
	pw.println("please!Login First");
	RequestDispatcher rd=req.getRequestDispatcher("Home.html");
	rd.include(req,res);
}else {
	String fname=ck[0].getValue();
	pw.println("welcome"+fname+"<br>");
	RequestDispatcher rd=req.getRequestDispatcher("ALink.html");
	rd.include(req, res);
	AddTrainDAO atd=new AddTrainDAO();
	int k=atd.insert(req);
	if(k>0) {
		pw.println("<br>Train Added Successfully");
		
	}
}
	}
}
