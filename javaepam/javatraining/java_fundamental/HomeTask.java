import java.util.*;
class Calculator
{
  float number1,number2;
  Calculator()
{
number1=0;
number2=0;
}

Calculator(float num1,float num2)
{
number1=num1;
number2=num2;
}

void takenumbers()
{
 Scanner sc=new Scanner(System.in);
System.out.println("enter the first number:"); 
number1=sc.nextFloat();
System.out.println("enter the second number:"); 
 number2=sc.nextFloat();
}


float addition()
{
return number1+number2;
}

float substraction()
{
 return number1-number2;
}

float multiplication()
{
  
return (number1*number2);
}

float divison()
{
 if(number2==0)
    return 0;
  else
{
return number1/number2;
} 
}

float reminder()
{
float rem=0;
try{
    rem=number1%number1;
   }
catch(Exception e)
{
System.out.println(e);
}
return rem;
}
}

class HomeTask
{
public static void main(String args[])
{
System.out.println("Enter your name: ");
Scanner sc=new Scanner(System.in);
String name;
name=sc.nextLine();
System.out.println("your name: "+name);

//Calculator
Calculator calculator=new Calculator();
String opration=(args[0]);

System.out.println("String value  "+opration);

  calculator.takenumbers();
switch(opration) 
{
  case "+": 
		
		System.out.println(calculator.addition());
		break;
 
 case "-": 
		
		System.out.println(calculator.substraction());
		break;


case "'*'": 
		System.out.println("in multiplication");
		System.out.println(calculator.multiplication());
		break;


case "/": 
		System.out.println("in divison");
		System.out.println(calculator.divison());
		break;

default:
           System.out.println("wrong input");

  }


}
}