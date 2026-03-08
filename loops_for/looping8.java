import java.util.*;
;public class looping8 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        sc.nextLine();
        double originaltotal=0.0;
        double finaltotal=0.0;
        double original=0.0;
        int items=0;
        for(int i=0;i<n;i++){
            String productname=sc.nextLine();
            double price=sc.nextDouble();
            int quantity=sc.nextInt();
            sc.nextLine();
            int discount=0;
            if(quantity==1){
                discount=0;
            }
            else if(quantity>=2 && quantity<=4){
                discount=10;
            }
            else if(quantity>=5 && quantity<=9){
                discount=15;
            }
            else if(quantity>=10){
                discount=20;
            }
            double subtotal=price*quantity*(1-discount/100.0);
            original=price*quantity;
            originaltotal+=original;
            finaltotal+=subtotal;
            items=items+quantity;
            System.out.println("Product:"+productname);
            System.out.println("Unit Price:$"+price);
            System.out.println("Quantity:"+quantity);
            System.out.println("Discount:"+discount+"%");
            System.out.println("Subtotal:$"+subtotal);
        }
        double totaldiscount=originaltotal-finaltotal;
        double savings=(totaldiscount/originaltotal)*100.0;
        System.out.println("\nTotal Items:"+items);
        System.out.println("Original Total:$"+originaltotal);{
        System.out.println("Total Discoun:$"+totaldiscount+"%");
        System.out.println("Final Total:$"+finaltotal);
        System.out.print(String.format("Savings:%.2f",savings));
        System.out.print("%");
        }
    }
}
