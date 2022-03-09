import java.util.ArrayList;
import java.util.Collections;
class SortNumber
{

public static void main(String args[])
{
ArrayList<Integer> al=new ArrayList<>();
al.add(21);
al.add(1);
al.add(12);
al.add(5);
al.add(4);
al.add(16);
al.add(2);
System.out.println("before sort "+al);
//sorting in descending order;
Collections.sort(al,(a,b)->a>b?-1:a<b?1:0);
System.out.println("after sort "+al);

}
}