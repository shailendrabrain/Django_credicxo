import java.util.ArrayList;
class Sweet implements Comparable<Sweet>
{
int cost;
String name;

Sweet()
{
cost=0;
name="";
}
Sweet(int cost,String name)
{
this.cost=cost;
this.name=name;
}

public void addsweet(int cost,String name)
{
this.cost =cost;
this.name=name;
}

public String getString()
{
return name;
}

public String toString()
{
return "name "+name+" cost "+cost;
}

public int compareTo(Sweet s)
{
return this.name.compareTo(s.name);
}
}

class Gift
{
public static void main(String args[])
{
Sweet s1=new Sweet(100,"rasgulla");
Sweet s2=new Sweet(145,"jalebi");
Sweet s3=new Sweet(250,"rasmalai");
Sweet s4=new Sweet(300,"kajukatli");
Sweet s5=new Sweet(325,"Gulabjamun");

ArrayList<Sweet> al=new ArrayList<>();
al.add(s1);
al.add(s2);
al.add(s3);
al.add(s4);
al.add(s5);
al.remove(s2);

int totalcost=0;
for(Sweet s:al)
{
totalcost+=s.cost;
}
System.out.println("totalcost of your sweet "+totalcost);

}

}

