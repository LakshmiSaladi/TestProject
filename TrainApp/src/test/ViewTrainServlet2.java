package test;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
@SuppressWarnings("serial")
public class ViewTrainServlet2 extends HttpServlet {
public void doGet(HttpServletRequest req,HttpServletResponse res)throws ServletException,IOException{
	PrintWriter pw=res.getWriter();
	res.setContentType("text/html");
	Cookie ck[]=req.getCookies();
	if(ck[0]==null) {
		pw.println("please!login first..");
		RequestDispatcher rd=req.getRequestDispatcher("Home.html");
		rd.include(req,res);
	}else {
		RetrieveTrainsDAo rtd=new RetrieveTrainsDAo();
		ArrayList<TrainBean> al=rtd.retrieve();
		ServletContext sct=this.getServletContext();
		sct.setAttribute("abc",al);
		String fname=ck[0].getValue();
		pw.println("Welcome"+fname+"<br>");
		RequestDispatcher rd=req.getRequestDispatcher("ULink.html");
		rd.include(req, res);
		if(al.size()==0) {
			pw.println("sorry!No trains found");
		}else {
			pw.println("list of trains");
			al.forEach((k)->{
				TrainBean tb=(TrainBean)k;
				//pw.println("<a href=select?tno="+tb.getTno()+" >"+tb.getTname()+"</a>");
				pw.println("&nbsp&nbsp"+tb.getTname());
			});
		}
		
	}
}
}
