package alg.arrays;

/**
 * You have a list arr of all integers in the range [1, n] sorted in a strictly increasing order.
 * Apply the following algorithm on arr:
 *
 * Starting from left to right, remove the first number and every other number afterward until you reach the end of the list.
 * Repeat the previous step again, but this time from right to left, remove the rightmost number and every other number
 * from the remaining numbers.
 * Keep repeating the steps again, alternating left to right and right to left, until a single number remains.
 * Given the integer n, return the last number that remains in arr.
 *
 *
 *
 * Example 1:
 *
 * Input: n = 9
 * Output: 6
 * Explanation:
 * arr = [1, 2, 3, 4, 5, 6, 7, 8, 9]
 * arr = [2, 4, 6, 8]
 * arr = [2, 6]
 * arr = [6]
 *
 * Example 2:
 *
 * Input: n = 1
 * Output: 1
 *
 *
 * Constraints:
 *
 * 1 <= n <= 109
 *
 * explanation: https://www.programmersought.com/article/15245845067/
 */
public class EliminationGame {

    public static void main(String[] args) {
        System.out.println(lastRemaining(9)); // 6
        System.out.println(lastRemaining(1)); // 1
    }

    private static int lastRemaining(int n) {
        boolean isLeft = true;
        int head = 1;
        int step = 1;
        int remaining = n;

        while(remaining > 1) {
            if (isLeft || ((remaining & 1) == 1)) {
                head += step;
            }
            step <<= 1;
            remaining >>= 1;
            isLeft = !isLeft;
        }
        return head;
    }
}
