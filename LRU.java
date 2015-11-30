import java.util.*;
class replace
{
	int n;
	int[] a;
	Scanner scann= new Scanner(System.in);
	void read()
	{
		n=scann.nextInt();
		a=new int[n];
		int i;
		for(i=0;i<n;i++)
		{
			a[i]=scann.nextInt();
		}
	}
	int find(int k, int run[], int t)
	{
		int f=0;
		for(int i=0;i<t;i++)
		{
			if(run[i]==k)
			{
				f=1;
			}
		}
		return f;
	}
	void runner()
	{
		int t,i=0,j=0;
		t=scann.nextInt();
		int[] run=new int[t];
		for(i=0;i<t;i++)
		{
			run[i]=a[i];
System.out.print("page input= "+ a[i]+" :  ");

				for(j=0;j<t;j++)
					{
					System.out.print(run[j]+" ");
					}
				System.out.println();
		}
		int m=n;
		int faults=0;
		int[] temp=new int[t];
		int ii;
		for(ii=t;ii<n;ii++)
		{
			int f=find(a[ii],run,t);
			if(f==1)
			{
				int k=0;
				for(j=0;j<t;j++)
				{
					if(run[j]!=a[ii])
					{
						temp[k]=run[j];
				//		System.out.print(temp[k]);
						k++;
					}
				}
				temp[k]=a[ii];
				// System.out.print(temp[k]);

				for(j=0;j<t;j++)
				{
					run[j]=temp[j];
				}
			//	System.out.println();
			}
			else
			{
				faults++;
				for(i=0;i<t-1;i++)
				{
					run[i]=run[i+1];

				}
				run[t-1]=a[ii];
			}
			System.out.print("page input= "+a[i] + " :  ");
			for(i=0;i<t;i++)
			{
				System.out.print(run[i]+" ");
			}
			System.out.println("");
//			break;
//		 System.out.println("Total faults are: "+ faults+4);


		}
faults=faults+4;
	System.out.println("Total faults are: "+ faults);

	}
	}
	public class LRU
	{
		public static void main(String args[])
		{
			replace aa=new replace();
			aa.read();
			aa.runner();

		}
	}








