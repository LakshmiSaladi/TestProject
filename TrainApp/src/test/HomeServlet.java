package test;
import javax.servlet.http.*;
import javax.servlet.*;
import java.io.*;
public class HomeServlet extends HttpServlet {
public void doPost(HttpServletRequest req,HttpServletResponse res)throws ServletException,IOException{
	String sub=req.getParameter("sub");
	ServletContext sct=this.getServletContext();
	sct.setAttribute("sub",sub);
	if(sub.equals("Admin"))
	{
		RequestDispatcher rd=req.getRequestDispatcher("ALogin.html");
		rd.forward(req,res);
	}else {
		RequestDispatcher rd=req.getRequestDispatcher("ULogin.html");
        rd.forward(req,res);
	}
}
}

