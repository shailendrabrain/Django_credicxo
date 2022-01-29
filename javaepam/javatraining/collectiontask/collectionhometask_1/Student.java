import java.util.HashMap;
import java.util.Map;
class Student
{
int id;
String name;
Student()
{
id=0;
name="";
}
Student(int id,String name)
{
this.id=id;
this.name=name;
}

public void addStudent(int id,String name)
{
this.id=id;
this.name=name;
}

public String toString()
{
return "your id "+id+" name "+name;
}

public static void main(String args[])
{
Student stu1=new Student(1,"varun");
Student stu2=new Student(2,"sanjay");
Student stu3=new Student(3,"nikesh");
Student stu4=new Student(4,"yadav");

HashMap<Integer,Student> hm=new HashMap<>();
hm.put(stu1.id,stu1);
hm.put(stu2.id,stu2);
hm.put(stu3.id,stu3);
hm.put(stu4.id,stu4);
System.out.println("map contain"+ hm);
System.out.println("search for specific element id 1:"+hm.get(1));
hm.remove(3);
System.out.println("after remove: map contain"+ hm);

for (Map.Entry<Integer, Student> e : hm.entrySet())
            System.out.println("Key: " + e.getKey()
                               + " Value: " + e.getValue());
}
}


