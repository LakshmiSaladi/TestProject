import java.util.*;
public class CollectionDemo {
public static void main(String arg[]) {
	List l=new ArrayList();
	l.add(300);
	l.add(200);
	l.add(900);
	Collections.sort(l);
	System.out.println(l);
}
}
