import java.util.*;
public class While17 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int rem=0,res=0;
        System.out.println("Original :"+n);
        while(n>0){
            rem=n%10;
            res=res*10+rem;
            n=n/10;
        }
        System.out.println("Reversed :"+ res);
        sc.close();
    }
    
}
