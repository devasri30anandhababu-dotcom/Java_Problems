import java.util.*;
public class looping11 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        sc.nextLine();
        double originalprice=0.0;
        double totfinal=0.0;
        for(int i=1;i<=n;i++){
            String seattype=sc.nextLine();
            String customertype=sc.nextLine();
            double baseprice=0.0;
            if(seattype.equalsIgnoreCase("Regular")){
                baseprice=12;
            }
            else if(seattype.equalsIgnoreCase("Premium")){
                baseprice=18;
            }
            else if(seattype.equalsIgnoreCase("Recliner")){
                baseprice=25;
            }
            int discount=0;
            if(customertype.equalsIgnoreCase("Adult")){
                discount=0;
            }
            else if(customertype.equalsIgnoreCase("Child")){
                discount=30;
            }
            else if(customertype.equalsIgnoreCase("senior")){
                discount=25;
            }
            double fianlprice=0.0;
            fianlprice=baseprice*(1-discount/100.0);
            originalprice+=baseprice;
            totfinal+=fianlprice;
            System.out.println("Ticket "+ i+":"+seattype+"-"+customertype);
            System.out.println("Base Price:$"+baseprice);
            System.out.println("Discount:"+discount+"%");
            System.out.println(String.format("Final Price:$%.1f",fianlprice));     

        }
        double totdiscount=0.0;
        totdiscount=originalprice-totfinal;
        String disapply="";
        if(n>=5){
            totfinal=totfinal*10/100.0;
            disapply="Yes";
        }
        else{
            disapply="No";
        }
        System.out.println("\nTotal Ticker:"+n);
        System.out.println("Original Total:$"+originalprice);
        System.out.println(String.format("Total Discount:$%.2f",totdiscount));
        System.out.println("Final Total:$"+totfinal);
        System.out.println("Group Discount Applied:"+disapply);
        }

        
    }

