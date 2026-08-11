import java.util.HashSet;

class Solution {
    public boolean isHappy(int n) {

        HashSet<Integer> set = new HashSet<>();

        while (n != 1) {

            // If we have already seen this number,
            // we are stuck in a cycle
            if (set.contains(n)) {
                return false;
            }

            set.add(n);

            n = sumOfSquares(n);
        }

        return true;
    }

    public int sumOfSquares(int n) {

        int sum = 0;

        while (n > 0) {
            int digit = n % 10;
            sum += digit * digit;
            n = n / 10;
        }

        return sum;
    }
}
