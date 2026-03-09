import java.util.*;
public class looping16{
    public static void main(String[]args){
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        sc.nextLine();
        int passcount=0;
        int failcount=0;
        int high=0;
        int total=0;
        for(int i=0;i<n;i++){
            String studentname=sc.nextLine();
            int correctans=sc.nextInt();
            int wrongans=sc.nextInt();
            int unattempt=sc.nextInt();
            sc.nextLine();
            int score=0;
            score=(correctans*4)-(wrongans*3)+(unattempt*0);
            String res="";
            if(score>=32){
                res="Pass";
                passcount++;
            }
            else {
                res="Fail";
                failcount++;
            }
            high=Math.max(high,score);
            System.out.println("Student:"+studentname);
            System.out.println("Correct:"+correctans);
            System.out.println("wrong:"+wrongans);
            System.out.println("Unattempted:"+unattempt);
            System.out.println("Score:"+score);
            System.out.println("Result:"+res);
            total+=score;
        }
        double avg=(double)total/n;
        System.out.println("\nTotal Students:"+n);
        System.out.println("Pass Count:"+passcount);
        System.out.println("Fail Count:"+failcount);
        System.out.println("Class Average:"+avg);
        System.out.println("Highest Score:"+high);
        sc.close();
    }
}