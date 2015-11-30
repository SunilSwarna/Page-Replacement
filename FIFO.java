import java.util.*;
class FIFO
{
public static void main(String args[])
{
 int n,i,frame;
  int [] a;
  int [] fifo;
  int Hit=0,Fault=0;
  Scanner scan=new Scanner(System.in);
 System.out.println("Enter The No Of Inputs"); 
    n=scan.nextInt();
   
 System.out.println("Enter The Frame Size"); 
    frame=scan.nextInt();
   a=new int[n];
   fifo=new int[frame];
   for(i=0;i<n;i++)
    {
     a[i]=scan.nextInt();
     
    }
int j=0,k,o;
   for(i=0;i<frame;i++)
    {
     fifo[i]=-1;
    } 
   boolean check;
   for(i=0;i<n;i++)
   {
	   check=false;
	   for(k=0;k<frame;k++)
	   {
		   if(fifo[k]==a[i])
		   {
			   check=true;
			   Hit=Hit+1;
                System.out.println("At Index "+k+" "+fifo[k]+" is hitted by "+a[i]);
	
		   }
	  }             	
		   if(check==false)
		   {
			o=fifo[j];
			   fifo[j]=a[i];
			                             
                            Fault=Fault+1;
                System.out.println("At Index "+j+" "+o+" is repalced by "+a[i]);
                            j++;
			   if(j>=frame)
			   {
				   j=0;

			   }	
                   }
	   }

	   System.out.println("Hit:"+Hit+" Fault:"+Fault); 
   }
}

