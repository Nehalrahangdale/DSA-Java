import java.util.HashSet;

class Solution {
    public int longestConsecutive(int[] nums) {

        HashSet<Integer> set = new HashSet<>();

        // Store all numbers in HashSet
        for (int num : nums) {
            set.add(num);
        }

        int longest = 0;

        for (int num : set) {

            // Start only if it's the beginning of a sequence
            if (!set.contains(num - 1)) {

                int currentNum = num;
                int currentLength = 1;

                while (set.contains(currentNum + 1)) {
                    currentNum++;
                    currentLength++;
                }

                longest = Math.max(longest, currentLength);
            }
        }

        return longest;
    }
}
