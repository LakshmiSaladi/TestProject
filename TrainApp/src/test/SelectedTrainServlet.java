package test;
import java.io.*;
import javax.servlet.http.*;
import javax.servlet.*;
import java.util.*;
@SuppressWarnings("serial")
public class SelectedTrainServlet extends HttpServlet {
	public void doGet(HttpServletRequest req,HttpServletResponse res)throws ServletException,IOException
	{
		PrintWriter pw=res.getWriter();
		res.setContentType("text/html");
		Cookie ck[]=req.getCookies();
		if(ck==null) {
			pw.println("please!Login first");
			RequestDispatcher rd=req.getRequestDispatcher("Home.html");
			rd.include(req, res);
		}else {
			String fname=ck[0].getValue();
			pw.println("Welcome"+fname+"<br>");
			RequestDispatcher rd=req.getRequestDispatcher("Home.html");
			rd.include(req,res);
		}
	}
}
