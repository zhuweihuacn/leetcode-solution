import java.util.Arrays;
import java.util.Comparator;

/**
 * Leetcode's solution for TwoSum: https://oj.leetcode.com/problems/two-sum/
 */
public class TwoSum {
    public int[] twoSum(int[] numbers, int target) {
        // Check numbers.
        if (numbers == null || numbers.length == 0)
            return new int[0];

        // TODO: use guava's Pair
        // Better use static factory method, I am too lazy...
        class Tuple {
            private int num, index;

            Tuple(int _num, int _index) {
                num = _num;
                index = _index;
            }
        };

        Tuple[] tupleArray = new Tuple[numbers.length];
        // TODO: use guava's iterable index.
        for (int i = 0; i < numbers.length; ++i)
            tupleArray[i] = new Tuple(numbers[i], i + 1);


        Arrays.sort(tupleArray, new Comparator<Tuple>() {
            @Override
            public int compare(Tuple e1, Tuple e2) {
                if (e1.num != e2.num)
                    return e1.num - e2.num;
                return e1.index - e2.index;
            }
        });


        int i = 0, j = numbers.length - 1;
        while (i < j) {
            Tuple e1 = tupleArray[i], e2 = tupleArray[j];
            int sum = e1.num + e2.num;

            if (sum == target)
                return new int[] {Math.min(e1.index, e2.index), Math.max(e1.index, e2.index)};
            else if (sum < target)
                ++i;
            else
                --j;
        }
        return new int[0];

    }
}