import java.util.*;
public class looping10 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        sc.nextLine();
        double totalsub=0.0;
        double subtotal=0.0;
        for(int i=0;i<n;i++){
            String itemname=sc.nextLine();
            double price=sc.nextDouble();
            int quantity=sc.nextInt();
            sc.nextLine();
            subtotal=price*quantity;
            totalsub=totalsub+subtotal;
            System.out.println("Item:"+itemname);
            System.out.println("Price:$"+price+" x "+ quantity);
            System.out.println("Subtotal:$"+subtotal);
        }
        
        double tax=totalsub*0.08;
        double service=totalsub*0.10;
        double grandtotal=totalsub+tax+service;
        System.out.println("\nTotal Iteams:"+n);
        System.out.println("Subtotal:$"+totalsub);
        System.out.println("Tax(8%):$"+tax);
        System.out.println("Service Charge(10%):$"+service);
        System.out.println("Grand Total:$"+grandtotal);
    }
}
