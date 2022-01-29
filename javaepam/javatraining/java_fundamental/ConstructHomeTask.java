import java.lang.Math;
import java.util.Scanner;
class ConstructHomeTask{


//*************CAUGHTSPEED***********
public static int caughtSpeeding(int speed, boolean isBirthday) {
 int returnvalue=0;  
if(isBirthday)
  {
    if(speed<=65)
       returnvalue=0;
      else
      {
        if(speed>65 && speed<=85) 
           returnvalue=1;
           
           else
           returnvalue=2;
      }
  }
  else
  {
    if(speed<=60)
       returnvalue=0;
      else
      {
        if(speed>60 && speed<=80) 
           returnvalue=1;
           
           else
           returnvalue=2;
      }
  } 
return returnvalue;
}

//*************check six********

public static boolean checkSix(int a,int b)
{
   boolean flag=false;
   if(a==6||b==6)
       flag=true;
   if(Math.abs(a+b)==6||Math.abs(a-b)==6)
	flag=true;
  return flag;
}

//**********tea candy*************
public static  int teaParty(int tea, int candy) {
   int returnvalue=0;
   if(tea<5||candy<5) returnvalue=0;
  
   if(Math.abs(tea-candy)>=tea || Math.abs(tea-candy)>=candy) 
         returnvalue=2;
     else
         if(tea>=5 && candy>=5) returnvalue=1;
    
   return returnvalue; 
}

//******Blue ticket *********

public static  int blueTicket(int a, int b, int c) {
int ab=a+b;
int bc=b+c;
int ac=a+c;
int returnvalue=0;
if(ab==10||bc==10||ac==10) returnvalue=10;

else
{
  if(ab-10==bc||ab-10==ac) returnvalue=5;
}
return returnvalue;
  
}

//********** Inorder********

public static  boolean inOrder(int a, int b, int c, boolean bOk) {
boolean flag=false;  
if(!bOk)
  {
    if(b>a&&c>b) flag=true;
      
  }
  else
  {
    if(c>b) flag=true;
  }
  return flag; 
}

//********sharedigit********

public static  boolean shareDigit(int a, int b) {
  int fa=a/10 ,sa=a%10;
  int fb=b/10, sb=b%10;
  boolean flag=false;
  if(fa==fb||fa==sb||sa==fb||sa==sb) flag=true;
  
  return flag;
}

//***********WITHOUTSTRING PROBLEM*************

public static  String withoutString(String base, String remove) {
  int blen = base.length();
  int rlen = remove.length();
  String lowbase = base.toLowerCase();
  String lowrem = remove.toLowerCase();
  String returnstring = "";

  for (int i = 0; i < blen; i++) {
      if (i <= blen - rlen) {
         String tmp = lowbase.substring(i,i+rlen);
      if (!tmp.equals(lowrem))
         returnstring+= base.substring(i,i+1);
      else {
        i += rlen-1;
       }
   }
    else {
      String tmp2 = lowbase.substring(i,i+1);
      if (!tmp2.equals(lowrem))
        returnstring += base.substring(i,i+1);
    }
  }
  return returnstring;
}



//********sum limit***********

public static  int sumLimit(int a, int b) {
  int sum=a+b;
  
  String s=Integer.toString(sum);
  String stra=Integer.toString(a);
  int sumlength=s.length();
  int alength=stra.length();
  
  int returnvalue=a;
  if(sumlength==alength) returnvalue=sum;
  
  return returnvalue;
 
}

//***************maxblock problem***************************

public static int maxBlock(String str) {
 int strlength=str.length();
 if(strlength==0) return 0;
 boolean flag=true;
 int count =1;
 int maxblock=0;
 for(int i=0;i<strlength-1;i++)
 {
     if(str.charAt(i)==str.charAt(i+1))
     {
       count++;
     }
     else
     {
       if(maxblock<count) maxblock=count;
       count=1;
     }
 }
 if(maxblock<count) maxblock=count;
 
 return maxblock;  
}


//***********SUMNUMBER PROBLEM*************

public static int sumNumbers(String str) {
  int length=str.length();
  char ch[]=str.toCharArray();
  int sum=0,digit=0;
  boolean flag=false;
  for(int i=0;i<length;i++)
  {
    if(Character.isDigit(ch[i]))
    { 
       digit=digit*10+Character.getNumericValue(ch[i]);
    }
    else
    {
      sum=sum+digit;
      digit=0; 
    }
  }
  if(digit!=0)
    sum =sum+digit;
    
    return sum; 
}



//*******MAIN METHOD***************


public static void main(String args[])
{
  //checksix problem.
 Scanner sc=new Scanner(System.in);
  System.out.println("enter the two number for checksix problem: ");
 int num1=sc.nextInt();
 int num2=sc.nextInt();
 System.out.println("output of checksix problem: "+ConstructHomeTask.checkSix(num1,num2));

  }

}
