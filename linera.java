
import java.util.Scanner;
public class Main{
	public static void main(String[] args){
		Scanner sc= new Scanner(System.in);
		System.out.println("enter theb n");
		int[] a=new int[20];
		int n,key,pos;
		
			
		n=sc.nextInt();
			System.out.println("enter"+n+"elements");
		for( int i=0;i<n;i++){
		a[i]=sc.nextInt();
		}
			System.out.println("enter the search element");
		key=sc.nextInt();
		pos=-1;
		for(  int i=0;i<n;i++){
		if(a[i]==key){
		pos=i;
		break;
		}
		}
		if(pos==-1){
			System.out.println("search is unsuccessful");
		}
		else{
		System.out.println("key is found"+pos);
		}
		
		
	}
	
}


