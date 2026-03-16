import java.util.*;

public class VowelCount {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String text = sc.nextLine();
        int i = 0;
        int count = 0;

        do {
            char ch = Character.toLowerCase(text.charAt(i));

            if (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u') {
                count++;
            }

            i++;
        } while (i < text.length());

        System.out.println("Text: " + text);
        System.out.println("Vowel count: " + count);
    }
}
