class Apple
{
 
    int numberofapple;
   Apple()
    { 
	numberofapple=0;
    }

   Apple(int value)
{
  numberofapple=value;
}

 int getApple()
{
return numberofapple;
}

void setApple(int appval)
{
 numberofapple=appval;
}

static int totalApple(Apple person1,Apple person2)
{
  return person1.numberofapple+person2.numberofapple;
}

public static void main(String args[])
{
   Apple denial=new Apple(3);
   Apple amber=new Apple(2);
   System.out.println("Total apple are: "+Apple.totalApple(denial,amber));
}
}

