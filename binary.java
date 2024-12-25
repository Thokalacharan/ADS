import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
       
        int[] a = new int[20];
        int n, key;
        
        
        System.out.print("Enter the list size: ");
        n = scanner.nextInt();
        
        
        System.out.println("Enter the elements in the list:");
        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
        }
        
       
        System.out.print("Enter the element to be searched: ");
        key = scanner.nextInt();
        
       
        int low = 0;
        int high = n - 1;
        int count = 0;
        
       
        while (low <= high) {
            int mid = (low + high) / 2;
            
            if (key == a[mid]) {
                System.out.println("Search is successful, Key is found at index " + mid);
                count = 1;
                break;
            } else if (key < a[mid]) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        
       
        if (count == 0) {
            System.out.println("Search is unsuccessful");
        }
    }
}
