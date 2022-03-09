import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
class Employee
{
int roll;
String name;

Employee(int roll,String name)
{
this.roll=roll;
this.name=name;
}

public String toString()
{
return name+  " "+roll;
}
}

class EmployeeCollectionSortDemo
{
public static void main(String args[])
{
ArrayList<Employee>al=new ArrayList<>();

al.add(new Employee(11,"shiva"));
al.add(new Employee(23,"samardh"));
al.add(new Employee(3,"medha"));
al.add(new Employee(7,"anchal"));
al.add(new Employee(13,"varun"));

System.out.println("before sort "+al);
Comparator<Employee> c=(e1,e2)->e2.name.compareTo(e1.name);
Collections.sort(al,c);


System.out.println("AFTER sort "+al);
}
}
