package test;
import java.sql.*;
import javax.servlet.http.*;
import javax.servlet.*;
public class LoginDAO {
public String fname;
public String validate(HttpServletRequest req,ServletContext sct) {
	String sub=(String)sct.getAttribute("sub");
	try {
		Connection con=DBConnection.getCon();
		if(sub.equals("Admin")) {
			PreparedStatement ps=con.prepareStatement("select * from Admin where uname=? and pword=?");
	        String uname=req.getParameter("uname");
			String pword=req.getParameter("pword");
            ps.setString(1,uname);
            ps.setString(2,pword);
            ResultSet rs=ps.executeQuery();
            while(rs.next()) {
            	fname=rs.getString(3);
            }
		}else {
			PreparedStatement ps=con.prepareStatement("select * from User where uname=? and pword=?");
			        String uname=req.getParameter("uname");
					String pword=req.getParameter("pword");
		            ps.setString(1,uname);
		            ps.setString(2,pword);
		            ResultSet rs=ps.executeQuery();
		            while(rs.next()) {
		            	fname=rs.getString(3);
		            }
		}
	}catch(Exception e) {
		e.printStackTrace();
	}
	return fname;
}
}
