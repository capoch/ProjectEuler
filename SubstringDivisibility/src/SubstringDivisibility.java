import java.util.Arrays;

public class SubstringDivisibility {
    private static int subSumCheck(long n, int i) {
        String[] numArray = String.valueOf(n).split("");
        try {
            return 100 * Integer.valueOf(numArray[i]) + 10 * Integer.valueOf(numArray[i + 1]) + Integer.valueOf(numArray[i + 2]);
        } catch(ArrayIndexOutOfBoundsException e) {
            System.out.println(e.getMessage());
            return 0;
        }
    }

    private static boolean checkSums(long n) {
        //System.out.println(n);
        return subSumCheck(n,1) % 2 == 0 && subSumCheck(n, 2) % 3 == 0 && subSumCheck(n, 3) % 5 == 0 &&
                subSumCheck(n, 4) % 7 == 0 && subSumCheck(n, 5) % 11 == 0 &&
                subSumCheck(n, 6) %13 == 0  && subSumCheck(n, 7) % 17 == 0 ;
    }

    private static long intArrayToLong(Object[] input) {
        StringBuilder stringBuilder = new StringBuilder();
        Arrays.stream(input).forEach(num -> stringBuilder.append(String.valueOf((Integer)num)));
        return Long.valueOf(stringBuilder.toString());
    }

    public static void main(String[] args) {
        long sum = 0;
        Object[][] myPerms = ArrayPermutation.myPerms();
        for(Object[] entry : myPerms) {
            long record = intArrayToLong(entry);
            if((Integer) entry[0] != 0 && checkSums(record)) {
                System.out.println("checked for " + record);
                sum += record;}
        }
        System.out.println(sum);
    }

}
