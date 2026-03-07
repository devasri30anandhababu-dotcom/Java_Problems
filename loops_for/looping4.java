import java.util.*;
public class looping4{
public static void main(String[] args) {
    Scanner sc=new Scanner(System.in);
    int n=sc.nextInt();
    sc.nextLine();
    double high=0.0;
    String top="";
    double totalsale=0.0;
    double commissions=0.0;

    for(int i=0;i<n;i++){
        String repname=sc.nextLine();
        double saleamount=sc.nextDouble();
        sc.nextLine();
        int rate=0;
        if(saleamount<=40000){
            rate=5;
        }
        else if(saleamount>=40001 && saleamount<=80000){
            rate=8;
        }
        else if(saleamount>= 80001&& saleamount<=100000){
            rate=10;
        }
        else if(saleamount>=100001 && saleamount<=150000){
            rate=12;
        }
        else if(saleamount>150000){
            rate=15;
        }
        double earned=saleamount*(rate/100.0);
        double bonus=0.0;
        if(saleamount>=150000){
            bonus=3000;
        }
        else if(saleamount>=100000){
            bonus=2000;
        }
        double payout=earned+bonus;
        totalsale+=saleamount;
        commissions+=earned;
        if(saleamount>high){
            high=saleamount;
            top=repname;
        }
        System.out.println("Sales Rep:"+repname);
        System.out.println("Sales Amount:$"+saleamount);
        System.out.println("Commission Rate:"+rate+"%");
        System.out.println("Commission Earned:$"+earned);
        System.out.println("Bonus:$"+bonus);
        System.out.println("Total Payout:$"+payout);
    }
    System.out.println("\nTotal Sales Reps:"+n);
    System.out.println("Total Sales :"+totalsale);
    System.out.println("Total Sales Commissions:"+commissions);
    System.out.println("Top Performer:"+top);
    sc.close();
}
}