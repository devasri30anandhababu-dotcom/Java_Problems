import java.util.*;
public class looping9 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        sc.nextLine();
        int totaldur=0;
        int totalcal=0;
        int calories=0;
        String intensity="";
        for(int i=1;i<=n;i++){
            String exercise=sc.nextLine();
            int duration=sc.nextInt();
            sc.nextLine();
            if(exercise.equalsIgnoreCase("Running")){
                calories=10*duration;
                intensity="High";
            }
            else if(exercise.equalsIgnoreCase("Swimming")){
                calories=12*duration;
                intensity="High";
            }
            else if(exercise.equalsIgnoreCase("Cycling")){
                calories=8*duration;
                intensity="Moderate";
            }
            else if(exercise.equalsIgnoreCase("Gym")){
                calories=7*duration;
                intensity="Moderate";
            }
            else if(exercise.equalsIgnoreCase("Walking")){
                calories=4*duration;
                intensity="Low";
            }
            totaldur=totaldur+duration;
            totalcal=totalcal+calories;
            System.out.println("Session "+i+": "+exercise);
            System.out.println("Duration:"+duration+" minutes");
            System.out.println("Calories Burned:"+calories);
            System.out.println("Intensity:"+intensity);
        }
        double avg=(double)totalcal/n;
        String level="";
        if(totalcal<300){
            level="Beginner";
        }
        else if (totalcal>=300 && totalcal<=1000){
            level="Intermediate";
        }
        else if(totalcal>1000){
            level="Advanced";
        }
            System.out.println("Total Workouts:"+n);
            System.out.println("Total Duration:"+totaldur+" minutes");
            System.out.println("Total Calories Burned:"+totalcal);
            System.out.println(String.format("Average Calories Per Session:%.2f",avg));
            System.out.println("Fitness Level:"+level);
        
    }
}
