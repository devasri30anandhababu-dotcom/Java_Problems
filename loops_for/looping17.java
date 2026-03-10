import java.util.*;
public class looping16{
    public static void main(String[]args){
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        sc.nextLine();
        int count=0;
        double totalrenew=0.0;
        for(int i=0;i<n;i++){
            String membername=sc.nextLine();
            String type=sc.nextLine();
            int days=sc.nextInt();
            sc.nextLine();
            double renewfee=0.0;
            if(type.equalsIgnoreCase("Basic")){
                renewfee=50;
            }
            else if(type.equalsIgnoreCase("Premium")){
                renewfee=100;
            }
            else if(type.equalsIgnoreCase("VIP")){
                renewfee=200;
            }
            int discount=0;
            if(days>=45){
                discount=20;
            }
            else if(days>=30 && days<=44){
                discount=15;
            }
            else if(days>=15 && days<=29){
                discount=10;
            }
            else if(days<15){
                discount=0;
            }
            double finalfee=0.0;
            finalfee=renewfee*(1-discount/100.0);
            String priority="";
            if(days<10){
                priority="Urgent";
                count++;
            }
            else if(days>=10 && days<=30){
                priority="High";
            }
            else if(days>30){
                priority="Normal";
            }
            totalrenew+=renewfee;
            System.out.println("Member:"+membername);
            System.out.println("Membership:"+type);
            System.out.println("Days Until Expiry:"+days);
            System.out.println("Renewal Fee:$"+renewfee);
            System.out.println("Discount:"+discount+"%");
            System.out.println("Final Fee:$"+finalfee);
            System.out.println("Priority:"+priority);
            }
            double avg=totalrenew/n;
            System.out.println("\nTotal Members:"+n);
            System.out.println("Urgent Renewals:"+count);
            System.out.println("Total Renewal Revenue:$"+totalrenew);
            System.out.println(String.format("Average Renewal Fee:$%.2f",avg));
            sc.close();
    }
}