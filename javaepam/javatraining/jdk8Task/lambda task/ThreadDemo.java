class ThreadDemo
{
public static void main(String args[])
{
Runnable r=()->
 {
   for(int i=10;i<=100;i++)
      System.out.println(i);
};
Thread t=new Thread(r);
t.start();

}
} 


