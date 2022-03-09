import java.util.TreeMap;
import java.util.Comparator;
class Employee
{
int id;
String name;

Employee(int i,String n)
{
id=i;
name=n;
}

public String toString()
{
return id+"  "+name;
}

}

class EmployeeTreeMapDemo
{
public static void main(String args[])

{

Comparator<String> c=(e1,e2)->e1.compareTo(e2);
TreeMap<String,Employee>tm=new TreeMap<String,Employee>(c);
Employee e1=new Employee(11,"raj");
Employee e2=new Employee(4,"varun");
Employee e3=new Employee(17,"medha");
Employee e4=new Employee(26,"anchal");
Employee e5=new Employee(3,"shiva");


tm.put(e1.name,e1);
tm.put(e2.name,e2);
tm.put(e3.name,e3);
tm.put(e4.name,e4);
tm.put(e5.name,e5);

System.out.println(tm);
}
}