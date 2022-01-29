import java.util.*;
class Student
{
int id;
String name;
int age;
Student()
{
name="";
age=0;
id=0;
}
Student(int id,String name,int age)
{
 this.id=id;
 this.name=name;
 this.age=age;

}

public void addStudent(int id,String name,int age)
{ 
  this.id=id;
  this.name=name;
  this.age=age;
}

public String toString()
{
return name+" "+age;

}
}

class CollectionHomeTask
{
 public static void main(String args[])
 {
    ArrayList<Student>al=new ArrayList<Student>();
    Student stu1=new Student();
    stu1.addStudent(1,"ajay",21);
    Student stu2=new Student(2,"ram",23);
    Student stu3=new Student(3,"sidhhant",35); 
    al.add(stu1);
    al.add(stu2);
    System.out.println(al);
    al.remove(1);
    al.add(stu3);
    for(Student s:al)
      {
	 System.out.println(s.name);
       }
   Student stu24=new Student(4,"place2",35);
  al.add(1,stu24);

//***linkedlist****
System.out.println("in linkedlist");
LinkedList<Student>ll=new LinkedList<Student>();
ll.add(stu1);
ll.add(stu2);
ll.add(1,stu3);
System.out.println(ll);
ll.remove(stu2);
ll.add(stu2);
ll.removeFirst();
ll.removeLast();

ll.add(stu24);
for(Student stu:ll)
{
System.out.println(stu.name);
}

//******hashmap******
System.out.println("in hashmap");
HashMap<Integer,Student> map=new HashMap<>();

map.put(stu1.id,stu1);
map.put(stu2.id,stu2);
map.put(stu3.id,stu3);
System.out.println("map size: "+map.size());
Student student=map.get(2);
System.out.println(student);
map.remove(2);

//*********linkedhashmap***********
System.out.println("in linkedhashmap");
LinkedHashMap<Integer,Student> lhm=new LinkedHashMap<>();

lhm.put(1,stu1);
lhm.put(2,stu2);
lhm.put(3,stu3);
System.out.println(lhm);
System.out.println("size: "+lhm.size());
System.out.println("check for empty:"+ lhm.isEmpty());
System.out.println("cotainkey:" +lhm.containsKey(2));
lhm.remove(2);
lhm.put(2,stu2);

//*******in hashset**********
System.out.println("in hashset");

HashSet<String> h = new HashSet<String>();
 
        //Adding elements into HashSet
        // usind add() method
        h.add("India");
        h.add("Australia");
        h.add("South Africa"); 
        // Adding duplicate elements
        h.add("India");
        // Displaying the HashSet
        System.out.println(h);
        System.out.println("List contains India or not:"
                           + h.contains("India"));
        // Removing items from HashSet
        // using remove() method
        h.remove("Australia");
        System.out.println("List after removing Australia:"
                           + h);
        // Display message
        System.out.println("Iterating over list:");

//**********linkedhashset *******

System.out.println("in linkedhashset");
 LinkedHashSet<String> hs= new LinkedHashSet<String>();
 
        // Adding elements to above Set
        // using add() method
        hs.add("hello");
        hs.add("java");
        hs.add("world");
        hs.add("new");
        hs.add("program");
        hs.add("in");
        // Printing all above elements to the console
        System.out.println("Initial HashSet " + hs);
        // Removing the element from above Set
        hs.remove("B");
        // Again removing the element
        System.out.println("After removing element " + hs);
        // Returning false if the element is not present
        System.out.println(hs.remove("AC"));

        Iterator itr = hs.iterator();
	while (itr.hasNext())
            System.out.print(itr.next() + ", ");
        for (String s : hs)
            System.out.print(s + ", ");

//*********treeset********
System.out.println("in treeset ");

Set<String> ts=new TreeSet<>();
ts.add("hello");
ts.add("java");
ts.add("world");

//duplicate will not add
ts.add("world");
System.out.println(ts);

//check for element
System.out.println("contains world "+ts.contains("world"));


System.out.println("in for each style :");
for(String s:ts)
{
System.out.println(s);
}

//*********Treemap
System.out.println("in treemap");
TreeMap<Integer,String>tm=new TreeMap<>();
tm.put(1,"one");
tm.put(2,"two");
tm.put(3,"three");
tm.put(4,"four");
System.out.println(tm);
tm.remove(3);
System.out.println("after removing :"+tm);

}


}


