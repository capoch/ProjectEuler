import org.omg.CORBA.INTERNAL;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringJoiner;

public class ArrayPermutation {
    private final Object[] numbers;

    public ArrayPermutation(Object[] numbers) {
        this.numbers = numbers;
    }

    private static Object[] insertInArray(Object[] originalArray, Object target, int position) {
        Object[] targetArray = Arrays.copyOf(originalArray, originalArray.length + 1);
        for(int i = targetArray.length - 2; i >= position; i--) {
            targetArray[i+1] = targetArray[i];
        }
        targetArray[position] = target;
        return targetArray;
    }

    private String toString(Object[] input) {
        StringJoiner joiner = new StringJoiner(", ");
        Arrays.asList(input).stream().map(Object::toString).forEach(joiner::add);
        return joiner.toString();
    }

    private static Object[][] permutate(Object[][] input, Object added) {
        int newLength = input[0].length + 1;
        Object[][] output = new Object[Factorial(newLength)][newLength];

        for(int i = 0; i < input.length; i++) {
            for(int j = 0; j <= input[i].length; j++) {
                int targetIndex = newLength * i + j;
                output[targetIndex] = insertInArray(input[i], added, j);
            }
        }
        return output;
    }

    private static int Factorial(int n) {
        if(n == 0 || n == 1) {
            return 1;
        } else {
            return n * Factorial(n-1);
        }
    }

    public static Object[][] myPerms() {
        Integer[] toPermutate = {1,2,3,4,5,6,7,8,9,0};
        ArrayPermutation permutaiton = new ArrayPermutation(toPermutate);
        Integer[][] input = {{new Integer(1)}};

        Object[][] outputList =
                permutate(permutate(permutate(permutate(permutate(permutate(
                        permutate(
                                permutate(
                                        permutate(input, new Integer(2)), new Integer(3)), new Integer(4)), new Integer(5)), new Integer(6)), new Integer(7)), new Integer(8)), new Integer(9)), new Integer(0));


        return outputList;
    }

    public static void main(String[] args) {
        Integer[] toPermutate = {1,2,3,4,5,6,7,8,9,0};
        ArrayPermutation permutaiton = new ArrayPermutation(toPermutate);
        Integer[][] input = {{new Integer(1)}};

        Object[][] outputList =
                permutate(permutate(permutate(permutate(permutate(permutate(
                permutate(
                    permutate(
                        permutate(input, new Integer(2)), new Integer(3)), new Integer(4)), new Integer(5)), new Integer(6)), new Integer(7)), new Integer(8)), new Integer(9)), new Integer(0));


        for(Object[] entry : outputList) {
            if((Integer)entry[0] == 0) {

            }
        }
    }
}
