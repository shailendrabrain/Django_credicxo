import java.util.TreeSet;
import java.util.Collections;
class TreeSetDemo
{
public static void main(String args[])
{
TreeSet<Integer>ts=new TreeSet<Integer>((a,b)->(a>b)?-1:(a<b)?1:0);
ts.add(10);
ts.add(13);
ts.add(7);
ts.add(6);
ts.add(24);
ts.add(12);


System.out.println("after sort "+ts);
}
}
