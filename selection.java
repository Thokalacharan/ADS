import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] a = new int[50];
        int n;

        System.out.print("Enter n: ");
        n = sc.nextInt();

        System.out.println("Enter array elements:");
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }

       
        for (int i = 0; i <= n - 2; i++) {
            int minpos = i;
            for (int j = i + 1; j <= n - 1; j++) {
                if (a[j] < a[minpos]) {
                    minpos = j;
                }
            }
            int temp = a[i];
            a[i] = a[minpos];
            a[minpos] = temp;
        }

        System.out.println("Sorted list:");
        for (int i = 0; i < n; i++) {
            System.out.print(a[i] + " ");
        }

        
    }
}
