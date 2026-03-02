import java.util.Scanner;
public class Conditional13{
    public static void main(String[]args){
        Scanner sc=new Scanner(System.in);
        String studentstatus=sc.nextLine();
        int credithours=sc.nextInt();
        sc.nextLine();
        String  programtype=sc.nextLine();
        String residency=sc.nextLine();
        System.out.print("\nStudent Status: "+studentstatus);
        System.out.print("\nCredit Hours: "+credithours);
        System.out.print("\nProgram Type: "+programtype);
        System.out.print("\nResidency: "+residency);
        double tuition=0.0;
        if(programtype.equalsIgnoreCase("Undergraduate")){
            tuition=350;
        }
        else if(programtype.equalsIgnoreCase("Graduate")){
            tuition=550;
        }
        else if(programtype.equalsIgnoreCase("Professional")){
            tuition=800;
        }
        double multi=0.0;
        if(residency.equalsIgnoreCase("In-State")){
            multi=1.0;
        }
        else if(residency.equalsIgnoreCase("Out-of-State")){
            multi=2.5;
        }
        else if(residency.equalsIgnoreCase("International")){
            multi=3.0;
        }
        double fee=0.0;
        double activity=0.0;
          if(studentstatus.equalsIgnoreCase("Full-Time")){
            activity=200;
            if(programtype.equalsIgnoreCase("undergraduate")){
                fee=500;
            }
            else if(programtype.equalsIgnoreCase("Graduate")){
                fee=750;
            }
            else if(programtype.equalsIgnoreCase("Professional")){
                fee=1200;
            }
        }
        else if(studentstatus.equalsIgnoreCase("Part-Time")){
            activity=100;
            if(programtype.equalsIgnoreCase("undergraduate")){
                fee=300;
            }
            else if(programtype.equalsIgnoreCase("Graduate")){
                fee=750;
            }

            else if(programtype.equalsIgnoreCase("Professional")){
                fee=900;
            }    

        }
        else if(studentstatus.equalsIgnoreCase("Continuing-Education")){
            activity=50;
            fee=150;
        }
        double tuitioncost=credithours*tuition*multi;
        double totalfee=tuitioncost+fee+activity;
        String cate="";
        if(residency.equalsIgnoreCase("In-State") && studentstatus.equalsIgnoreCase("Full-Time")){
            cate="Standard";
        }
        else if(residency.equalsIgnoreCase("Out-of-State") || residency.equalsIgnoreCase("International")){
            cate="Premium";
        }
        else if(studentstatus.equalsIgnoreCase("Continuing-Education")){
            cate="Reduced";
        }
        System.out.print("\nBase Tuition Per Credit: $"+tuition);
        System.out.print("\nResidency Multiplier: "+multi+"x");
        System.out.print("\nProgram Fee: $"+fee);
        System.out.print("\nStudent Activity Fee: $"+activity);
        System.out.print("\nTotal Registration Fee: $"+totalfee);
        System.out.print("\nFee Category: "+cate);


        sc.close();
    }    
    
}
