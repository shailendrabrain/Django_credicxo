import java.util.*;

//#################################
//ARRAY CLASS

class ArrayHomeTask
{

public static int missNumber(int numbers[],int length)
{
int totalOfNumber=0;
  for(int number:numbers)
  {
   totalOfNumber=totalOfNumber+number;
  }
 int actualTotal=0;
  actualTotal=(length*(length+1))/2;
  return actualTotal-totalOfNumber;

}

static int [] maxmin(int arr[],int length)
{
int maxMinArray[]=new int[2];
maxMinArray[0]=arr[0];
maxMinArray[1]=arr[1];

if(maxMinArray[0]>maxMinArray[1])
{ 
  int a=maxMinArray[1];
  maxMinArray[1]=maxMinArray[0];
  maxMinArray[0]=a;
}
for(int i=2;i<length;i++)
{
  if(arr[i]<maxMinArray[0])
   {
       maxMinArray[0]=arr[i]; 
    }
   if(arr[i]>maxMinArray[1])
    {
     maxMinArray[1 ]=arr[i];
     } 

}
return maxMinArray;
}

}


//######################################################################################
//FOR STRING TASK

class StringHomeTask{
  
   String str;
    StringHomeTask()
    {
      
    }
  
    StringHomeTask(String s)
    {
	str=s;
    }
  
//######FIND DUPLICATE

  void findDuplicate()
   {  

       System.out.print("duclicate in "+str+" is :::");
       char ch[]=str.toCharArray();
      int length=str.length();
      for(int i=0;i<length-1;i++)
	{  
         if(ch[i]=='0'||ch[i]==' ') continue;
	    for(int j=i+1;j<length;j++)
		 {
		    if(ch[i]==ch[j])
			{
			   System.out.print(ch[i]+"  ");
			   ch[j]='0';
			   break;	
                        }

                }

          }
	System.out.println();
	
   }
   
//###CHECK FOR ROTATION.
 
static boolean checkForRotation(String str1,String str2)
{
     int lenstr1=str1.length();
     int lenstr2=str2.length();
      
      if(lenstr1!=lenstr2)
		return false;
      Queue<Character>q1=new LinkedList<Character>();
     for(int i=0;i<lenstr1;i++)
	{
		q1.add(str1.charAt(i));
	}

	Queue<Character>q2=new LinkedList<Character>();
	
	for(int i=0;i<lenstr2;i++)
	    {
		q2.add(str2.charAt(i));
            }
       
       int k=lenstr1;
    while(k>=0)
	{
          k--;
	  char ch=q2.peek();
 	   q2.remove();
           q2.add(ch);
          if(q2.equals(q1))
		return true;
	}
  return false;
}
 
  

}

//########################################
//CLASS WITH MAIN METHOD 


class ArrayString
{

public static void main(String args[])
{
  System.out.print("enter the size of array: ");
  Scanner sc=new Scanner(System.in);
    int arraysize=sc.nextInt();
    int arr[]=new int[100];
    System.out.print("enter the element of array: ");
    for(int i=0;i<arraysize;i++)
     {

      arr[i]=sc.nextInt();
      }
    System.out.print("your missed number is: ");
    System.out.println(ArrayHomeTask.missNumber(arr,arraysize+1));

  
 int minmaxarr[]=ArrayHomeTask.maxmin(arr,arraysize);
 System.out.print("your min and max number is: ");
 System.out.println(minmaxarr[0]+"  "+minmaxarr[1]);


StringHomeTask s=new StringHomeTask("hello World java program");
s.findDuplicate();

System.out.println();
System.out.println();
String s1="ABCDEF";
String s2="DEFABC";

System.out.println(s1+" is rotation of "+ s2 + " or not:  "+ StringHomeTask.checkForRotation(s1,s2));
  

 
}
}



