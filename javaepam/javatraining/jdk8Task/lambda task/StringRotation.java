import java.util.*;
interface Rotation
{
public boolean rotate(String s1,String s2);
}

class StringRotation
{
public static void main(String args[])
{
Rotation r=(s1,s2)->
{
if(s1.length()!=s2.length()) return false;

Queue<Character>q1=new LinkedList<>();
for(int i=0;i<s1.length();i++)
   q1.add(s1.charAt(i));

Queue<Character>q2=new LinkedList<>();
for(int i=0;i<s2.length();i++)
   q2.add(s2.charAt(i));

int k=s1.length();
while(k>0)
{
k--;
char c=q2.peek();
q2.remove();
q2.add(c);
if(q2.equals(q1)) return true;
}
return false;
};

String s1="hello";
String s2="lloee";
System.out.println(s1+ " and "+s2+ " to check rotation "+r.rotate(s1,s2));
}
}















