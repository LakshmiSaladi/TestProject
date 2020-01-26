package test;
import java.util.*;
import java.sql.*;
public class RetrieveTrainsDAo {
public ArrayList<TrainBean> al=new ArrayList<TrainBean>();
public ArrayList<TrainBean> retrieve(){
	try {
		Connection con=DBConnection.getCon();
		PreparedStatement ps=con.prepareStatement("select * from Train");
		ResultSet rs=ps.executeQuery();
		while(rs.next()) {
			TrainBean tb=new TrainBean();
			tb.setTno(rs.getString(1));
			tb.setTname(rs.getString(2));
			tb.setFstation(rs.getString(3));
			tb.setTstation(rs.getString(4));
 			tb.setAvl(rs.getInt(5));
 			al.add(tb);
		}
	}catch(Exception e) {
		e.printStackTrace();
	}
	return al;
}
}
