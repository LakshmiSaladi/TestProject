package test;
import javax.servlet.*;
import java.io.*;
import java.util.*;
import java.util.function.Consumer;

import javax.servlet.http.*;
@SuppressWarnings("serial")
public class ViewTrainServlet extends HttpServlet {
public void doGet(HttpServletRequest req,HttpServletResponse res)throws ServletException,IOException {
	PrintWriter pw=res.getWriter();
	res.setContentType("html/text");
	Cookie c[]=req.getCookies();
	if(c==null) {
		pw.println("please! Login first");
		RequestDispatcher rd=req.getRequestDispatcher("ALink.html");
		rd.include(req,res);
	}else {
		RetrieveTrainsDAo rtd=new RetrieveTrainsDAo();
		ArrayList<TrainBean> al=rtd.retrieve();
		String fname=c[0].getValue();
		pw.println("WELCOME"+fname+"<br>");
		RequestDispatcher rd=req.getRequestDispatcher("ALink.html");
		rd.include(req,res);
		if(al.size()==0) {
			pw.println("Sorry! No Trains found");
		}else {
			pw.println("list of trains");
			al.forEach((k)->{
			TrainBean tb=(TrainBean)k;
			pw.println(tb.getTno()+" "+tb.getTname()+" "+tb.getFstation()+" "+tb.getTstation()+" "+tb.getAvl());
		});
	}
	}
}
}
