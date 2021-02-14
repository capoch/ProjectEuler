import java.util.*;
import java.util.stream.Collectors;

public class GoldbachsOtherConjecture {
    private static boolean sieve[] = new boolean[99999];
    private static void createSieve() {
        sieve[0] = false;
        sieve[1] = false;

        for(int i = 2; i < sieve.length; i++) {
            sieve[i] = true;
        }
    }

    private static void runAlgorithm() {
        for(int i = 0; i < Math.sqrt(sieve.length); i++) {
            if(sieve[i]) {
                for(int j = 2; j * i < sieve.length; j++) {
                    sieve[i*j] = false;
                }
            }
        }

    }

    private static void printSieve(int n) {
        StringJoiner joiner = new StringJoiner(", ");
        for(int i = 0; i < n; i++) {
            if(sieve[i]) {
                joiner.add(String.valueOf(i));
            }
        }
        System.out.println(joiner.toString());
    }



    private static boolean checkSieveEntry(int i) {
        for(int j = i - 1; j > 0; j--) {
            for(int k = 0; k < i - j; k++) {
                if(sieve[j] && i == j + 2 * Math.pow(k, 2)) {
                    //System.out.println(i + " = " + j +" + 2 * " + k + "^2");
                    return true;
                }
            }
        }
        System.out.println("no solutiion found for " + i);
        return false;
    }

    public static void main(String[] args) {
        GoldbachsOtherConjecture.createSieve();
        GoldbachsOtherConjecture.runAlgorithm();
        for(int i = 9; i < sieve.length; i+=2) {
            if(!sieve[i] && !checkSieveEntry(i)) {
                System.out.println("sol = " + i);
            }
        }
    }
}
