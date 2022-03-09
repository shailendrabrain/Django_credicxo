import java.util.*;
class EmployeeTreeSet
{
int roll;
String name;
EmployeeTreeSet(int roll,String name)
{
this.roll=roll;
this.name=name;
}

public String toString()
{
return name+" "+roll;
}

public static void main(String args[])
{
Comparator<EmployeeTreeSet>c=(e1,e2)->e1.name.compareTo(e2.name);
TreeSet<EmployeeTreeSet>ts=new TreeSet(c);
ts.add(new EmployeeTreeSet(12,"shiva"));
ts.add(new EmployeeTreeSet(10,"raj"));
ts.add(new EmployeeTreeSet(18,"ravi"));
ts.add(new EmployeeTreeSet(5,"durga"));
ts.add(new EmployeeTreeSet(18,"varun"));
ts.add(new EmployeeTreeSet(25,"anchal"));

System.out.println(ts);
}
}
