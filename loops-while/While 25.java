import java.util.*;

public class NumberPattern2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt(); // number of rows
        int i = 1;

        do {
            int j = 1;

            do {
                System.out.print(i); // print same number (row number)
                j++;
            } while (j <= i);

            System.out.println(); // next line
            i++;
        } while (i <= n);
    }
}
