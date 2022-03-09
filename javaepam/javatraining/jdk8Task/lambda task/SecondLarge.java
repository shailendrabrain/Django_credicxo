interface SecondNumber
{
public int check(int arr[]);
}
class SecondLarge
{
public static void main(String args[])
{
SecondNumber sn=arr->{
			int f=arr[0];
			int s=arr[1];
			if(f<s)
		         { int a=f;
                           f=s;
                           s=a;
                         }
                for(int i=0;i<arr.length;i++)
                {
                   if(arr[i]>f) { s=f;f=arr[i];}
                   if(arr[i]<f&&arr[i]>s) { s=arr[i];}
               }
               return s;
              };

int arr[]={4,3,5,1,7,6,8,12,10,13};
for(int i:arr) System.out.print(i+" ");
System.out.println(" second max number "+sn.check(arr));
}
} 




