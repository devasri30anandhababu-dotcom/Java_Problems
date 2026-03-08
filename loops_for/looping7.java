import java.util.*;
public class looping7 {
    public static void main(String[]args){
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        sc.nextLine();
        double totunit=0.0;
        double totrev=0.0;
        for(int i=0;i<n;i++){
            String customerid=sc.next();
            int unitsconsumed=sc.nextInt();
            double bill=0.0;
            if(unitsconsumed>=0 && unitsconsumed<=100){
                bill=unitsconsumed*0.10;
            }
            else if(unitsconsumed>=101 && unitsconsumed<=200){
                bill=(100.0*0.10)+(unitsconsumed-100)*0.13;
            }
            else if(unitsconsumed>=201 && unitsconsumed<=300){
                bill=(100.0*0.10)+(100.0*0.13)+(unitsconsumed-200)*0.16;
            }
            else if(unitsconsumed>300){
                bill=(100.0*0.10)+(100.0*0.13)+(100.*0.16)+(unitsconsumed-300)*0.20;
            }
            String category="";
            if(unitsconsumed<=200){
                category="Low Usage";
            }
            else if(unitsconsumed>=201 && unitsconsumed<=300){
                category="Medium Usage";
            }
            else if(unitsconsumed>300){
                category="High Usage";
            }
            totunit=totunit+unitsconsumed;
            totrev=totrev+bill;
            System.out.println("Cunsumer ID:"+customerid);
            System.out.println("Units Consumed:"+unitsconsumed);
            System.out.println("Bill Amount:$"+totrev);
            System.out.println("Category:"+category);

        }
        double avg=totrev/n;
        System.out.println("\nTotal Consumers:"+n);
        System.out.println("Total Units Consumed:"+totunit);
        System.out.println("Total Revenue:$"+totrev);
        System.out.println(String.format("Average Bill:$%.2f",avg));
    }
}

