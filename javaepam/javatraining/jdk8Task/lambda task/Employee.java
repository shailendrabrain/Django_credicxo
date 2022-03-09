import java.util.ArrayList;
import java.util.Collections;
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

public static void main(String args[])
{
ArrayList<Employee>al=new ArrayList<>();
al.add(new Employee(100,"krithuk"));
al.add(new Employee(123,"medha"));
al.add(new Employee(45,"shiva"));
al.add(new Employee(23,"varun"));
al.add(new Employee(213,"durga"));
al.add(new Employee(145,"sanjay"));
System.out.println(al);
Collections.sort(al,(e1,e2)->e1.name.compareTo(e2.name));
System.out.println(al);

}
}



