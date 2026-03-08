import java.util.*;
public class looping6 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        double initialbal=sc.nextDouble();
        int n=sc.nextInt();
        sc.nextLine();
        double currentbal=initialbal;
        double total=0.0;
        int fail=0;
        int success=0;
        for(int i=1;i<=n;i++){
            double withdraw=sc.nextDouble();
            // sc.nextLine();
            String status="";
            String reason="";
            if(withdraw<=currentbal){
                status="Approved";
                success++;
                currentbal=currentbal-withdraw;
                total+=withdraw;
                System.out.println("Transaction "+i+":$"+withdraw);
                System.out.println("Status:"+status);
                System.out.println("Remaining Balance:$"+currentbal);
            }
            else{
                status="Denied";
                reason="Insufficient funds";
                fail++;
                currentbal=currentbal-withdraw;
                System.out.println("Transaction "+i+":$"+withdraw);
                System.out.println("Status:"+status);
                System.out.println("Reason:"+reason);
                System.out.println("Remaining Balance:$"+currentbal);
            }   
            }
            System.out.println("\nTotal Transactions:"+n);
            System.out.println("Successful Withdrawals:"+success);
            System.out.println("Failed Withdrawals:"+fail);
            System.out.println("Final Balance:$"+currentbal);
            System.out.println("Total Withdrawn:$"+total);
        }
    }

