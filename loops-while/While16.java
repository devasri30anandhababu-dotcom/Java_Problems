import java.util.*;
public class While16 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int base=sc.nextInt();
        int exponent=sc.nextInt();
        int temp=exponent;
        int res=1;
        while(exponent>0){
            res=res*base;
            exponent--;
        }
        System.out.println(base+" ^ "+temp+" = "+res);
        sc.close();
        
    }
    
}
