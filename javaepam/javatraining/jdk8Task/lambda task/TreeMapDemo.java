import java.util.TreeMap;

class TreeMapDemo
{
public static void main(String args[])
{
TreeMap<Integer,String>ts=new TreeMap<Integer,String>((a,b)->(a>b)?-1:(a<b)?1:0);
                                            
ts.put(21,"varun");
ts.put(4,"pankaj");
ts.put(29,"shiva");
ts.put(15,"ankit");
ts.put(2,"medha");
System.out.println(ts);
}
}