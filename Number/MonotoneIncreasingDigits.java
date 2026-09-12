class Solution {
    public int monotoneIncreasingDigits(int n) {

        char[] digits = String.valueOf(n).toCharArray();

        int mark = digits.length;

        // Check from right to left
        for (int i = digits.length - 1; i > 0; i--) {

            if (digits[i - 1] > digits[i]) {
                digits[i - 1]--;
                mark = i;
            }
        }

        // Make all digits after mark equal to 9
        for (int i = mark; i < digits.length; i++) {
            digits[i] = '9';
        }

        return Integer.parseInt(new String(digits));
    }
}
