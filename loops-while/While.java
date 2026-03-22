import java.util.*;

public class MenuProgram {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\n--- MENU ---");
            System.out.println("1. Print INRI Meaning");
            System.out.println("2. Print Number Pattern (1, 22, 333...)");
            System.out.println("3. Exit");
            System.out.print("Enter your choice: ");
            
            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.println("INRI : Jesus of Nazareth, King of the Jews");
                    break;

                case 2:
                    System.out.print("Enter number of rows: ");
                    int n = sc.nextInt();
                    int i = 1;

                    do {
                        int j = 1;
                        do {
                            System.out.print(i);
                            j++;
                        } while (j <= i);
                        System.out.println();
                        i++;
                    } while (i <= n);
                    break;

                case 3:
                    System.out.println("Exiting program...");
                    break;

                default:
                    System.out.println("Invalid choice!");
            }

        } while (choice != 3);
    }
}
