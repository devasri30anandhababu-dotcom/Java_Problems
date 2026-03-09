import java.util.*;
public class looping14 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        sc.nextLine();
        for(int i=0;i<n;i++){
            String booktype=sc.nextLine();
            int dayslate=sc.nextInt();
            sc.nextLine();
            double fine=0.0;
            int finecape=0;
            if(booktype.equalsIgnoreCase("Regular")){
                fine=0.5;
                finecape=10;
            }
            else if(booktype.equalsIgnoreCase("Reference")){
                fine=1.0;
                finecape=20;
            } 
            else if(booktype.equalsIgnoreCase("Magazine")){
                fine=0.25;
                finecape=5;
            }
            double finecalculate=0.0;
            finecalculate=dayslate*fine;
            double actualfine=0.0;
            



        }
    }
}
