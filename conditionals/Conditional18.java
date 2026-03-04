import java.util.Scanner;
public class Conditional18 {
    public static void main(String[]args){
        Scanner sc=new Scanner(System.in);
        double packageweight=sc.nextDouble();
        sc.nextLine();
        String destination=sc.nextLine();
        String shippingspeed=sc.nextLine();
        String packagesize=sc.nextLine();
        System.out.print("\nPackage Weight:"+packageweight+"lbs");
        System.out.print("\nDestination Zone:"+destination);
        System.out.print("\nshippingspeed:"+shippingspeed);
        System.out.print("\nPackage Size:"+packagesize);
        double rate=0.0;
        String level="";
        if(shippingspeed.equalsIgnoreCase("Economy")){
            rate=5;
            level="Budget";
        }
        else if(shippingspeed.equalsIgnoreCase("Standard")){
            rate=10;
            level="Standard";
        }
        else if(shippingspeed.equalsIgnoreCase("Express")){
            rate=25;
            level="Priority";
        }
        else if(shippingspeed.equalsIgnoreCase("Overnight")){
            rate=50;
            level="Premium";
        }
        double surcharge=packageweight*1.0;
        double multi=0.0;
        if(destination.equalsIgnoreCase("Local")){
            multi=1.0;
        }
        else if(destination.equalsIgnoreCase("Regional")){
            multi=1.2;
        }
        else if(destination.equalsIgnoreCase("National")){
            multi=1.5;
        }
        else if(destination.equalsIgnoreCase("International")){
            multi=3.0;
        }
        double size=0.0;
        if(packagesize.equalsIgnoreCase("Small")){
            size=0;
        }
        else if(packagesize.equalsIgnoreCase("Medium")){
            size=5;
        }
        else if(packagesize.equalsIgnoreCase("Large")){
            size=15;
        }
        else if(packagesize.equalsIgnoreCase("Oversized")){
            size=30;
        }
        double basecost=(rate+surcharge)*multi;
        double totalcost=basecost+size;
        String days="";
        if(shippingspeed.equalsIgnoreCase("Economy")){
            if(destination.equalsIgnoreCase("Local")){
                days="3-5";
            }
            else if(destination.equalsIgnoreCase("Regional")){
                days="5-7";
            }
            else if(destination.equalsIgnoreCase("National")){
                days="7-10";
            }
            else if(destination.equalsIgnoreCase("International")){
                days="14-21";
            }
        }
        if(shippingspeed.equalsIgnoreCase("standard")){
            if(destination.equalsIgnoreCase("Local")){
                days="2-3";
            }
            else if(destination.equalsIgnoreCase("Regional")){
                days="3-5";
            }
            else if(destination.equalsIgnoreCase("National")){
                days="5-7";
            }
            else if(destination.equalsIgnoreCase("International")){
                days="10-14";
            }
        }

        if(shippingspeed.equalsIgnoreCase("Express")){
            if(destination.equalsIgnoreCase("Local")){
                days="1";
            }
            else if(destination.equalsIgnoreCase("Regional")){
                days="1-2";
            }
            else if(destination.equalsIgnoreCase("National")){
                days="2-3";
            }
            else if(destination.equalsIgnoreCase("International")){
                days="3-5";
            }
        }
        if(shippingspeed.equalsIgnoreCase("Overnight")){
            days="1";
        }
        System.out.print("\nBase Shipping Rate:$"+rate);
        System.out.print("\nWeight Surcharge:$"+surcharge);
        System.out.print("\nZone Multiplier:"+multi+"x");
        System.out.print("\nSize Surcharge:$"+size);
        System.out.print("\nTotal Shipping Cost:$"+totalcost);
        System.out.print("\nEstimated Delivery:"+days+" business days");
        System.out.print("\nService Level:"+level);
        sc.close();
    }
    
}
