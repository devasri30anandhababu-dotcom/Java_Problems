import java.util.*;
public class looping5{
    public static void main(String[]args){
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        sc.nextLine();
        double tot=0.0;
        double high=0.0;
        int peak=0;
        int count=0;
        for(int i=1;i<=n;i++){
            int day=sc.nextInt();
            int rooms=sc.nextInt();
            int totalroom=sc.nextInt();
            sc.nextLine();
            double rate=0.0;
            rate=(rooms*100.0)/totalroom;
            String status="";
            if(rate<60){
                status="Low";
            }
            else if(rate>=60 && rate<=79){
                status="Moderate";
            }
            else if(rate>=80 && rate<=99){
                status="High";
            }
            else if(rate>=100){
                status="Full";
            }
            tot=tot+rate;
            if(rate>high){
                high=rate;
                peak=i;
            }
            if(status.equalsIgnoreCase("Full")){
                count++;
            }
            System.out.println("Day:"+i);
            System.out.println("Rooms Occupied:"+rooms);
            System.out.println("Total Rooms:"+totalroom);
            System.out.println("Occupancy Rate:"+rate+"%");
            System.out.println("Status:"+status);
        }
        double avg=Math.round(tot/n*100.0)/100.0;
        System.out.println("\nTotal Days Analyzed:"+n);
        System.out.println("Average Occupancy Rate:"+avg+"%");
        System.out.println("Peak Occupancy Day: Day"+ peak);
        System.out.println("Days at Full Capacity:"+count);
    }
}