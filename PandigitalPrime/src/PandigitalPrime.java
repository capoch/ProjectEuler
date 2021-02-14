import java.util.*;
import java.util.stream.Collectors;

public class PandigitalPrime {
    private static boolean sieve[] = new boolean[9876544];
    private static final Set<Integer> listOfInts = new HashSet<Integer>(Arrays.asList(1,2,3,4,5,6,7));
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

    private static boolean isPandigital(int n) {
        return new HashSet(Arrays.asList(String.valueOf(n).split("")).stream().map(Integer::valueOf).collect(Collectors.toSet())).containsAll(listOfInts);
    }

    public static void main(String[] args) {
        PandigitalPrime.createSieve();
        PandigitalPrime.runAlgorithm();
        //System.out.println(PandigitalPrime.isPandigital(123456789));
        //PandigitalPrime.printSieve(1000);
        for(int i = sieve.length - 1; i >= 0; i--) {
            if(sieve[i] && PandigitalPrime.isPandigital(i)) {
                System.out.println("sol = " + i);
                return;
            }
        }
    }
}
