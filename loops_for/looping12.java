import java.util.*;
public class looping12 {
   public static void main(String[] args) {
    Scanner sc=new Scanner(System.in);
    int n=sc.nextInt();
    sc.nextLine();
    double totrev=0.0;
    int count=0;
    for(int i=1;i<=n;i++){
        String vehicletype=sc.nextLine();
        double hrs=sc.nextDouble();
        sc.nextLine();
        double rate=0.0;
        if(vehicletype.equalsIgnoreCase("Car")){
            rate=3;
        }
        else if(vehicletype.equalsIgnoreCase("Motorcycle")){
            rate=2;
        }
        else if(vehicletype.equalsIgnoreCase("Truck")){
            rate=5;
        }
        else if(vehicletype.equalsIgnoreCase("Bus")){
            rate=7;
        }
        double fees=hrs*rate;
        String cap="";
        if(vehicletype.equalsIgnoreCase("Car")){
            if(fees>=30){
                cap="Yes";
            }
            else{
                cap="No";
            }  
        }
        if(vehicletype.equalsIgnoreCase("Motorcycle")){
            if(fees>=20){
                cap="Yes";
            }
            else{
                cap="No";
            }  
        }
        if(vehicletype.equalsIgnoreCase("Truck")){
            if(fees>=60){
                cap="Yes";
            }
            else{
                cap="No";
            }  
        }
        if(vehicletype.equalsIgnoreCase("Bus")){
            if(fees>=100){
                cap="Yes";
            }
            else{
                cap="No";
            }  
        }
        totrev+=fees;
        if(hrs>8){
        count++;
    }
    System.out.println("Vehicle :"+i+" "+vehicletype);
    System.out.println("Hours Parked:"+hrs);
    System.out.println("Hourly Rate:$"+rate);
    System.out.println("Parking Fee:$"+fees);
    System.out.println("Cap Applied:"+cap);

    }
    double avg=totrev/n;
    System.out.println("Total Vehicles:"+n);
    System.out.println("Total Revenue:$"+totrev);
    System.out.println(String.format("Average Fee:$%.2f",avg));
    System.out.println("Peak Hour Vehicles(>8 hours):"+count);
    
    
   } 
}
