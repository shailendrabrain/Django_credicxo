interface palildrome
{
 public boolean check(String s);
}

class Palindrome
{
public static void main(String args[])
{

palildrome p=(s)->
		{  int i=0;int j=s.length()-1;
			while(i<j)
				{
    				  if(s.charAt(i)!=s.charAt(j)) return false;
                                 i++; j--;
                               }
                              return true;
                  };

String s="hellolleh";
System.out.println(p.check(s));
}
}