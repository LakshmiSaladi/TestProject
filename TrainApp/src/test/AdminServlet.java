package test;
import javax.servlet.http.*;
import java.io.*;
import javax.servlet.*;
@SuppressWarnings("serial")
public class AdminServlet extends HttpServlet {
public void doPost(HttpServletRequest req,HttpServletResponse res)throws ServletException,IOException {
	PrintWriter pw=res.getWriter();
	res.setContentType("text/html");
	ServletContext sct=this.getServletContext();
	LoginDAO ld=new LoginDAO();
	String fname=ld.validate(req,sct);
	if(fname!=null) {
		Cookie ck=new Cookie("fname",fname);
		pw.println("Welcome"+fname+"<br>");
		RequestDispatcher rd=req.getRequestDispatcher("Alink.html");
		rd.include(req,res);
		res.addCookie(ck);
		}else {
			pw.println("Invalid username or password");
			RequestDispatcher rd=req.getRequestDispatcher("ALogin.html");
			rd.include(req, res);
		}
}
}
