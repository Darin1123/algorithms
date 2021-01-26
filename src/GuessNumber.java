import java.util.Random;

/**
 * @problem The secret is in range [1, N]. For each guess, you will be notified
 * whether you are getting closer or farther compare to your previous guess. Design
 * a ~lgN algorithm.
 */

public class GuessNumber {
    private final int N;
    private final int secret;
    private int gap;

    public GuessNumber(int N) {
        this.N = N;
        secret = new Random().nextInt(N)+1;
        this.gap = -1;
    }

    /**
     * 0 - checked; 1 - closer; -1: farther; 2-need one more guess; 3-neither closer nor farther
     * @param guess a number
     * @return guess result
     */
    public int checkGuess(int guess) {
        if (gap == -1) {
            this.gap = Math.abs(guess - secret);
            return 2;
        }
        if (guess==secret)
            return 0;
        int newGap = Math.abs(guess - secret);
        int result;
        if (newGap < gap)
            result = 1;
        else if (newGap > gap)
            result = -1;
        else
            result = 3;
        this.gap = newGap;
        return result;
    }

    /**
     * find the secret and return number of guesses.
     * @return number of guesses if the algorithm finds it, otherwise return -1;
     */
    public int discover() {
        // direction: 1-right; 2-left;
        int counter = 0, lo = 1, hi = N, span = (hi - lo + 1) / 2, direction = 1, guess;
        checkGuess(-span); //first guess
        int result;
        while (lo < hi) {
            guess = (direction==1) ? hi + span : lo - span;
            if (guess<=0)
                guess--;
            result = checkGuess(guess);
            if (result == 3) {
                lo = (hi + lo) / 2;
                break;
            }
            if (result == 1) {
                if (direction == 1)
                    lo = (lo + hi + 1) / 2;
                else
                    hi = (lo + hi) / 2;
            } else { // -1
                span += (hi - lo + 1) / 2;
                if (direction == 1)
                    hi = (lo + hi) / 2;
                else
                    lo = (lo + hi + 1) / 2;
            }
//            System.out.printf("guess: %d, lo: %d, hi: %d, span: %d, result: %d %n", guess, lo, hi, span, result);
            direction *= -1;
            counter++;
        }

        if (lo == secret)
            return counter;
        return -1;
    }

    public static void main(String[] args) {
        boolean success = true;
        long start = System.currentTimeMillis();
        for (int i = 1; i < 20000000; i++) {
            GuessNumber guessNumber = new GuessNumber(i);
            if (guessNumber.discover() == -1) {
                System.out.printf("failed at %d %n", i);
                success = false;
                break;
            }
        }
        if (success) {
            long elapsed = System.currentTimeMillis() - start;
            System.out.printf("time used: %d msec %n", elapsed);
            System.out.println("pass!");
        }
    }
}
