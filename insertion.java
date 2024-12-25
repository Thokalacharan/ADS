import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        
        Scanner scanner = new Scanner(System.in);
        
        int[] a = new int[50];
        int n;

        System.out.print("Enter n: ");
        n = scanner.nextInt();  
        System.out.println("Enter array elements:");
        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();  
        }

        for (int i = 1; i < n; i++) {
            int item = a[i]; 
            int j = i - 1;    

           
            while (j >= 0 && a[j] > item) {
                a[j + 1] = a[j]; 
                j--;  
            }

           
            a[j + 1] = item;
        }

        
        System.out.println("Sorted list:");
        for (int i = 0; i < n; i++) {
            System.out.print(a[i] + " ");  
        }
    }
}
