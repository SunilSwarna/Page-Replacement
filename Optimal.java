

import java.util.Scanner;
public class Optimal {
int num;
int ref[];

 int size=0,i;
 int pf=0;
 int frame[];
 int fc=0;
 Scanner input=new Scanner(System.in);
 public void input(){
	 System.out.println("no. of processes : \n") ;
	 num = input.nextInt();
	 ref=new int[num];
  System.out.println("Enter the processes : \n");
  for(i=0;i<num;i++){  
  ref[i]=input.nextInt();}
  System.out.println("Enter Frame size: \n");
  size=input.nextInt();
  frame=new int[size];
 }
 
 public boolean search(int ch){
  for(int i=0;i<fc;i++){
   int temp=frame[i];
   if(temp==ch){
    return true;
   }
  }
  return false;
 }
 public int future(int ch, int pos){
  int result=num+1;
  for(int i=pos+1;i<num;i++){
   int temp=ref[i];
   if(temp==ch){
    if(i<result){
     result=i;
    }
   }
  }
  return result;
  
 }
 
 public void optimal(){
//  System.out.println("Lenght="+num);
  for(int i=0;i <num;i++){
  int ch=ref[i];
   if(search(ch)){
    
   }else{
    // page fault
    System.out.print("Page fault At index "+i);
    pf++;
    
    if(fc<size){
     frame[fc]=ch;
     fc++;
    }else{
     
     int optimal[]=new int[size];
     
     for(int j=0;j<size;j++){
      optimal[j]=future(frame[j],i);
     }
     // to find the page to be replaced
     int index=0;
     int max=optimal[0];
     for(int j=1;j<size;j++){
      if(optimal[j]>max){
       max=optimal[j];
       index=j;
      }
     }
     // replace page
     System.out.print(" and page "+ frame[index]+" is replaced by "+ch);
     frame[index]=ch;
     
    }
    System.out.println();
    
   }
   
   
  }
  System.out.println("No. of Page fault="+pf);
 }
 public static void main(String args[]){
  Optimal obj=new Optimal();
  obj.input();
  obj.optimal();
 }

}
