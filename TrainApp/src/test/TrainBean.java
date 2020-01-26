package test;
import java.io.*;
@SuppressWarnings("serial")
public class TrainBean implements Serializable {
private String tno,tname,fstation,tstation;
private int avl;
public TrainBean() {}
public String getTno() {
	return tno;
}
public void setTno(String tno) {
	this.tno = tno;
}
public String getTname() {
	return tname;
}
public void setTname(String tname) {
	this.tname = tname;
}
public String getFstation() {
	return fstation;
}
public void setFstation(String fstation) {
	this.fstation = fstation;
}
public String getTstation() {
	return tstation;
}
public void setTstation(String tstation) {
	this.tstation = tstation;
}
public int getAvl() {
	return avl;
}
public void setAvl(int avl) {
	this.avl = avl;
}
 
}
