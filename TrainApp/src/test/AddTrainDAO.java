package test;
import java.sql.*;
import javax.servlet.http.*;

@SuppressWarnings("serial")
public class AddTrainDAO extends HttpServlet {
	public int k;
	public int insert(HttpServletRequest req) {
		try {
			Connection con=DBConnection.getCon();
			PreparedStatement ps=con.prepareStatement("insert into Train values(?,?,?,?,?)");  
			String tno=req.getParameter("tno");
			String tname=req.getParameter("tname");
			String fstation=req.getParameter("fstation");
			String tstation=req.getParameter("tstation");
			int avl=Integer.parseInt(req.getParameter("avl"));
			ps.setString(1,tno);
			ps.setString(2,tname);
			ps.setString(3,fstation);
			ps.setString(4,tstation);
			ps.setInt(5,avl);
			k=ps.executeUpdate();
		}catch(Exception e) {
			e.printStackTrace();
		}
		return k;
	}

}
