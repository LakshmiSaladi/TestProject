package test;
import javax.servlet.http.*;
import javax.servlet.*;
import java.io.*;
@SuppressWarnings("serial")
public class LogoutServlet extends HttpServlet{
public void doPost(HttpServletRequest req,HttpServletResponse res)throws ServletException,IOException{
	PrintWriter pw=res.getWriter();
	res.setContentType("text/html");
	Cookie ck[]=req.getCookies();
	ck[0].setValue("");
    ck[0].setMaxAge(0);
    pw.println("logged out successfully");
    RequestDispatcher rd=req.getRequestDispatcher("Home.html");
    rd.include(req,res);
}
}
