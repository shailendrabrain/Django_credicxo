class LoopArrayHomeTask
{

// ********MAXSPAN PROBLEM**************
public static  int maxSpan(int[] nums) {
  int span=0;
  int l=nums.length;
  if(l==0) return 0;
  int count =1;
  for(int i=0;i<l;i++)
  {
    for(int j=l-1;j>i;j--)
    {
      if(nums[j]==nums[i])
         {
           if(count<j-i+1)
             count=j-i+1;
             break;
         } 
    }
  }
  return count; 
}

//************CANBALANCE PROBLEM*************

public static  boolean canBalance(int[] nums) {
  int len=nums.length;
  int totalsum=0;
  for(int num:nums)
    totalsum+=num;
  if(totalsum%2!=0) return false;
  int half=totalsum/2;
  int check=0;
  boolean flag=false;
  for(int i=0;i<len;i++)
  {
    check=check+nums[i];
    if(check==half)
    { flag=true;
      break;
    }
  }
return flag;
}

//*************COUNTCLUMPS PROBLEM**********
public static  int countClumps(int[] nums) {
  int len=nums.length;
  int count=0;
  boolean flag=false;
  
  for(int i=0;i<len-1;i++)
  {
    if(nums[i]==nums[i+1])
    {
      flag=true;
    }
    else
    {
      if(flag)
      {
        count++;
        flag=false;
      }
    }
  }
  if(flag)
   count+=1;
   
 return count;
}

//**********maxMirror******************

public static  int maxMirror(int[] nums) {
  int l=nums.length;
  int k=0;
  int count=0;
  int maxmirror=0;
  boolean flag=false;
 if(l==0) return 0;
 if(l==1) return 1;
 
  for(int i=0;i<l;i++)
  {
    count=0;
    
    for(int j=l-1;j>=0&&i+count<l;j--)
       {
            if(nums[i+count]==nums[j])
            {
             count++;
             }
             
            else
            {
                if(maxmirror<count)
                  maxmirror=count;
                  count=0;
            }
       }
       if(maxmirror<count) maxmirror=count;
  }
  return maxmirror;
}

//*************Linear inner outer problem.*********

public static boolean linearIn(int[] outer, int[] inner) {
  int outerlength=outer.length;
  int innerlength=inner.length;
  if(innerlength==0) return true;
  boolean flag=true;
int j=0;
 for(int i=0;i<outerlength &&j<innerlength;i++)
 {
   if(outer[i]==inner[j])
     {
       j++;
     }
    else
    {
        if(outer[i]>inner[j])
        {
          flag=false;
          break;
        }
     }
 }
 if(j!=innerlength) flag=false;
  return flag;
}





public static void main(String args[])
{
int nums[]={1,2,1,1,4};
int inner[]={2,3,4};
int outer[]={1,2,4,6};
System.out.println(LoopArrayHomeTask.maxSpan(nums));

System.out.println(LoopArrayHomeTask.canBalance(nums));

System.out.println(LoopArrayHomeTask.countClumps(nums));

System.out.println(LoopArrayHomeTask.maxMirror(nums));

System.out.println(LoopArrayHomeTask.maxSpan(nums));

System.out.println(LoopArrayHomeTask.linearIn(outer,inner));
}

}
