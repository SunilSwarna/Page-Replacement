package Second_chance;
import java.util.*;
public class secondchance {
    int pagefault=0,repptr=0;
    int full=0,frsize,frame[],table[],tablesize,referbit[];
    //Scanner in = new Scanner(System.in);
    void read(int x,int[] y,int z){
        //System.out.println("Enter the size of page table");
            tablesize = x;
            
            table = new int[tablesize];
            //System.out.println("Enter the pages in the table");
            for (int i=0;i<tablesize;i++){
                table[i]=y[i];
            }
            //System.out.println("Enter the number of frames : ");
            frsize=z;
            frame = new int[frsize];
            referbit = new int[frsize];
    }
    void display(){
        for(int i=0;i<full;i++){
            System.out.print(frame[i]+" ");
        }
        System.out.println();
    }
    int pagerep(int ele){
        int temp;
        while(referbit[repptr]!=0){
            referbit[repptr++]=0;
                if(repptr==frsize){
                    repptr=0;
                }
        }
        temp=frame[repptr];
        frame[repptr]=ele;
        referbit[repptr]=1;
        return temp;
    }
    void pfault(int ele){
        if(full!=frsize){
            referbit[full]=1;
            frame[full++]=ele;
        }
        //else{
        //    System.out.println("The page replaced is : "+ pagerep(ele));
        //}
    }
    int search(int ele){
        int flag=0;
        if(full!=0){
            for(int i=0;i<full;i++){
                if(ele==frame[i]){
                    flag=1;
                    referbit[i]=1;
                    break;
                }
            }
        }
        return flag;
    }
    void run(){
        for(int i=0;i<tablesize;i++){
            if(search(table[i])!=1){
                pfault(table[i]);
                //display();
                pagefault++;
            }
        }
        System.out.println("No.of pagefaults = " + pagefault);
    }
}
