import java.util.*;
public class p6 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int familyincome=sc.nextInt();
        int percentage=sc.nextInt();
        int scholarship=(familyincome<200000 && percentage>=75)?1:0;
        
        System.out.println((scholarship==1)?"Scholarship Granted": "Not Granted");
        }
}