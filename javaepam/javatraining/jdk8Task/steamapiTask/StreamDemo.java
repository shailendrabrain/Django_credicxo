import java.util.*;
import java.util.stream.*;
import java.util.function.*;
class Product
{
String name;
int price;
String category;
String grade;

Product(String n,int p,String c,String g)
{
name=n;
price=p;
category=c;
grade=g;
}

public String toString()
{
return name+" "+price+" "+category+" "+grade;
}
}

class Response
{
String responseBody;
int statusCode;
String responseType;

Response(String rb, int sc, String rt)
{
responseBody=rb;
statusCode=sc;
responseType=rt;
}

public String toString()
{
return responseBody+" "+statusCode+" "+responseType;
}
}

class StreamDemo{
public static void main(String args[])
{
ArrayList<Product>al=new ArrayList<Product>();
al.add(new Product("mobile",1200,"electronic","A"));
al.add(new Product("charger",500,"electronic","B"));
al.add(new Product("taitan",350,"book","c"));
al.add(new Product("pulse",150,"grocery","b"));
al.add(new Product("laptop",25000,"electronic","A"));
al.add(new Product("shirt",500,"cloth","c"));
al.add(new Product("jeans",1250,"cloth","c"));


//*********
List<Product>l=al.stream().filter(p->p.price>1000).collect(Collectors.toList());
//Consumer c=i-> System.out.println("name"+i.name+" price "+i.price);
System.out.println("list of all product with price more then 1000");
l.stream().forEach(System.out::println);
//l.stream().forEach(c);

//*************
List<Product>electronic=al.stream().filter(p->p.category=="electronic").collect(Collectors.toList());
System.out.println("product with electronic category");
electronic.stream().forEach(System.out::println);

Predicate<Product>checkForElectronic=e->e.category=="electronic";

Predicate<Product>checkForPrice=e->e.price>1000;



//*******electronic and more then 1000;
System.out.println("electronic product more then 1000");
//List<Product>electronicProductMoreThen1000=al.stream().filter(p->p.category=="electronic").filter(p->p.price>1000).collect(Collectors.toList());

Function<Product,Product> f=p1-> {p1.name.toUpperCase(); return p1;};

List<Product>electronicProductMoreThen1000=al.stream().filter(checkForElectronic.and(checkForPrice)).collect(Collectors.toList());


//electronicProductMoreThen1000.stream().forEach(System.out::println);

electronicProductMoreThen1000.stream().forEach(i-> System.out.println(i.name.toUpperCase()));

//*****count of all electronic product

long i=al.stream().filter(checkForElectronic).count();
System.out.println("electronic product count "+i);


}

}


















