package test;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
@SuppressWarnings("serial")
public class UserServlet extends HttpServlet{
	public void doPost(HttpServletRequest req,HttpServletResponse res)throws ServletException,IOException {
		PrintWriter pw=res.getWriter();
		res.setContentType("text/html");
		ServletContext sct=this.getServletContext();
		LoginDAO ld=new LoginDAO();
		String fname=ld.validate(req,sct);
		if(fname!=null) {
			Cookie ck=new Cookie("fname",fname);
			pw.println("Welcome"+fname+"<br>");
			RequestDispatcher rd=req.getRequestDispatcher("ULink.html");
			rd.include(req,res);
			res.addCookie(ck);
			}else {
				pw.println("Invalid username or password");
				RequestDispatcher rd=req.getRequestDispatcher("ULogin.html");
				rd.include(req, res);
			}
	}
	}


