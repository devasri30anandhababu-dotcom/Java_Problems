import java.util.*;
public class looping13 {
 public static void main(String[] args) {
    Scanner sc=new Scanner(System.in);
    int n=sc.nextInt();
    sc.nextLine();
    int conform=0;
    int reject=0;

    for(int i=0;i<n;i++){
        String donorname=sc.nextLine();
        int age=sc.nextInt();
        double weight=sc.nextDouble();
        double hemoglobin=sc.nextDouble();
        sc.nextLine();
        System.out.println("Donor:"+donorname);
        System.out.println("Age:"+age+"years");
        System.out.println("Weight:"+weight+" kg");
        System.out.println("Hemoglobin:"+hemoglobin+" g/dL");
        String status="";
        String reason="";
        if((age>=18 && age<=65) && weight>=50 && hemoglobin>=12.5){
        status="Eligible";
        conform++;
        System.out.println("Status:"+status);
       }
    else{
        status="Not Eligible";
        reject++;
        if(age<18){
        reason="Age below 18 years";
    }
    else if(age>65){
        reason="Age above 65 years";
    }
    else if(weight<50){
        reason="Weight below 50 kg";
    }
    else if(hemoglobin<12.5){
        reason="Hemoglobin below 12.5 g/dL";
    }
    System.out.println("Status:"+status);
    System.out.println("Reason:"+reason);
    }
 }
 double rate=0.0;
 rate=(conform/(double)n)*100.0;
 System.out.println("\nTotal Donors:"+n);
 System.out.println("Eligible Donors:"+conform);
 System.out.println("Rejected Donors:"+reject);
 System.out.println("Eligibility Rate:"+rate+"%");
    
}
}
