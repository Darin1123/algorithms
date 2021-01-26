import java.util.Random;
import java.util.Scanner;

public class Playground {

    public static void main(String[] args) {
        System.out.println("enter range:");
        int N = new Scanner(System.in).nextInt();
        int secret = new Random().nextInt(N)+1;
        System.out.println("first guess:");
        int previousGuess = new Scanner(System.in).nextInt();
        if (previousGuess==secret) {
            System.out.println("You got it!");
            return;
        }
        int newGuess;
        System.out.println("next guess:");
        while ((newGuess = new Scanner(System.in).nextInt()) != secret) {
            if (Math.abs(newGuess - secret) < Math.abs(previousGuess - secret)) {
                System.out.println("closer");
            } else {
                System.out.println("farther");
            }
            previousGuess = newGuess;
            System.out.println("next guess:");
        }
        System.out.println("You got it!");
        return;
    }
}
