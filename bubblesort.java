import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

       
        System.out.print("Enter the number of elements: ");
        int n = scanner.nextInt();  

        int[] a = new int[n]; 
    
        System.out.println("Enter " + n + " elements:");
        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();  
        }
    
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (a[j] > a[j + 1]) {
            
                    int temp = a[j];
                    a[j] = a[j + 1];
                    a[j + 1] = temp;
                }
            }
        }

    
        System.out.println("Sorted array:");
        for (int i = 0; i < n; i++) {
            System.out.println(a[i]);
        }

        scanner.close();  
    }
}
