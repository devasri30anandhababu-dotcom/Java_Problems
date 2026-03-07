import java.util.*;
public class looping3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n=sc.nextInt();
        sc.nextLine();
        int low=0;
        int critical=0;
        int total=0;
        for(int i=0;i<n;i++){
           String productname=sc.nextLine();
           int currentstock=sc.nextInt();
           int minimumstock=sc.nextInt();
           sc.nextLine();
           String status="";
           if(currentstock>=minimumstock){
            status="Adequate";
           }
           else if(currentstock<minimumstock && currentstock>=minimumstock/2){
            status="Low Stock";
            low++;
           }
           else if(currentstock<minimumstock/2){
            status="Critical";
            critical++;
           }
           int quality=0;
           if(status.equalsIgnoreCase("Adequate")){
            quality=0;
           }
           else if(status.equalsIgnoreCase("Low Stock")){
            quality=(minimumstock-currentstock)+minimumstock/2;
           }
           else if(status.equalsIgnoreCase("Critical")){
            quality=(minimumstock-currentstock)+minimumstock*15/10;
           }
           total=total+quality;
           System.out.println("Product"+productname);
           System.out.println("Current Stock:"+currentstock);
           System.out.println("Minimum Stock:"+minimumstock);
           System.out.println("Status:"+status);
           System.out.println("Reorder Quantity:"+quality);
        }
        System.out.println("\nTotal Products:" +n);
        System.out.println("Low Stock Items:"+low);
        System.out.println("Critical Items:"+critical);
        System.out.println("Total Reorder Quantity:"+total);
    }

}
