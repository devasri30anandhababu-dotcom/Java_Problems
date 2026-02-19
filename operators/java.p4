import java.util.Scanner;
public class p4{
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int creditlimit=sc.nextInt();
        int purchaseamount=sc.nextInt();
        int cardblock=sc.nextInt();
        int bank=(purchaseamount<=creditlimit && cardblock==0)?1:0;
        System.out.println((bank==1)?"Approved":"Declined");
        
    }
}