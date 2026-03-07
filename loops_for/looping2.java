import java.util.*;
public class looping2{
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        sc.nextLine();
        double total=0.0;
        double avg=0.0;
        int high=0;
        int count=0;
        int failed=0;
        for(int i=0;i<n;i++){
            String student=sc.nextLine();
            int score=sc.nextInt();
            sc.nextLine();
            String grade="";
            if(score>=85 && score <=100){
                grade="A";
            }
            else if(score>=70 && score <=84){
                grade="B";
            }
            else if(score>=60 && score <=69){
                grade="C";
            }
            else if(score>=50 && score <=59){
                grade="D";
            }
            else if(score>=0 && score <=49){
                grade="F";
            }
            String status="";
            if(score>=60){
                status="Pass";
            }
            else if(score<60){
                status="Fail";
            }
            if(status.equalsIgnoreCase("Pass")){
                count++;
            }
            else{
                failed++;
            }
            total+=score;
            high=Math.max(high,score);
            System.out.println("Student:"+student);
            System.out.println("Score:"+score);
            System.out.println("Letter Grade:"+grade);
            System.out.println("Status:"+status);
        }
        avg=total/n;
        System.out.println("\nTotal Students:"+ n);
        System.out.println(String.format("Class Average:%.2f",avg));
        System.out.println("Highest Score:"+ high);
        System.out.println("Student Passed:" +count);
        System.out.println("Student Failed:"+ failed);
    }
}