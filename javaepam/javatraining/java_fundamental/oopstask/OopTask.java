import java.util.ArrayList;
enum FlowerType
{
Lily("25"),
Rose("45"),
Lotus("25"),
Sunflower("35");
String flower;
public String getFlower()
{
  return this.flower;
}
FlowerType(String flo)
{
 this.flower=flo;
}
}


class Flower
{
int cost;
String name;
Flower()
{
cost=0;
name="";
}
Flower(int cost,String name)
{
this.cost=cost;
this.name=name;
}

public void createFlower(int cost,String name)
{
this.cost=cost;
this.name=name;
}

public String getName()
{
  return name;
}

public void setName(String name)
{
this.name=name;
}

}

class OopTask
{
public static void main(String args[])
{
System.out.println(FlowerType.values());
FlowerType[] fts=FlowerType.values();
System.out.println("available flower with price");
for(FlowerType ft:fts)
 {
   System.out.print("flower name: "+ft.name()+"   ");
   System.out.println("flower price:"+ ft.getFlower());
 }

ArrayList<Flower> al=new ArrayList<>();
Flower f1=new Flower(25,"rose");
Flower f2=new Flower(35,"lotus");
Flower f3=new Flower(45,"sunflower");
Flower f4=new Flower(15,"lily");
al.add(f1);
al.add(f4);
al.add(f3);
al.add(f2);
int total=0;
 for(Flower f:al)
    total=total+f.cost;
System.out.println("total cost is: "+total);



}
}



