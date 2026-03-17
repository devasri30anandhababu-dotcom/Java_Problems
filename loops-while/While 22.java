import java.util.*;

public class EvenSumRange {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int start = sc.nextInt();
        int end = sc.nextInt();
        int temp = start;

        int sum = 0;

        while(temp <= end){
            if(temp % 2 == 0){
                sum = sum + temp;
            }
            temp++;
        }

        System.out.println("Sum of even numbers from " + start + " to " + end + ": " + sum);
    }
}
