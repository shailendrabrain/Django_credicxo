class Printer
{
/*public static <T> void printArray(T[] arr)
{
  for(T t:arr)
    {
    System.out.print(t+ " ");
    }
  System.out.println();
}
*/
public static  void printArray(Object arr[])
{
  for(Object o:arr )
    {
    System.out.print(o+ " ");
    }
  System.out.println();
}

public static void main(String args[])
{
 Integer[] integerArray = {1, 2, 3, 4, 5, 6};  

Double[] doubleArray = {1.1, 2.2, 3.3, 4.4, 5.5, 6.6, 7.7};  

Character[] characterArray = {'H', 'E', 'L', 'L', 'O'};	  
 System.out.println("Array integerArray contains:");  
   Printer.printArray(integerArray); // pass an Integer array  
System.out.println("\nArray doubleArray contains:");  

  

Printer.printArray(doubleArray); // pass a Double array  

  

System.out.println("\nArray characterArray contains:");  

  
Printer.printArray(characterArray); // pass a Character array 

  

    }	   

  

} 