//Code with Notepad
class Pyramid
{
static void pyramidWithWhileLoop(int number,int step)
{
 int row =0;
 int column=0;
 int numberToPrint=0;
while(row<number)
{
column=0;
   while(column<=row)
   {
    System.out.print(numberToPrint+"  ");
	numberToPrint=numberToPrint+step;
    column++;
    }
   System.out.println();
  row++;
  
}

}

static void pyramidWithDoWhileLoop(int number,int step)
{
 int row =0;
 int column=0;
 int numberToPrint=0;

  do{
      column=0;
       do{
	   System.out.print(numberToPrint+"  ");
		numberToPrint=numberToPrint+step;
	  column++;
    	 }while(column<=row);
        System.out.println();
       
      row++;
   }while(row<number);
}

public static void pyramidWithForLoop(int number, int step)
{
  
  int numberToPrint=0;
  for(int row=0;row<number;row++)
  {
     for(int column=0;column<=row;column++)
	{
		System.out.print(numberToPrint+"  ");
		numberToPrint=numberToPrint+step;
            
        }
  System.out.println();
  }
}


public static void main(String args[])
{
Pyramid.pyramidWithForLoop(5,1);
Pyramid.pyramidWithWhileLoop(5,2);
Pyramid.pyramidWithDoWhileLoop(5,3);



}
}

