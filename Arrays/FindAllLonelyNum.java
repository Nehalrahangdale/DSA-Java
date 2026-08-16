import java.util.*;

class Solution {
    public List<Integer> findLonely(int[] nums) {

        Arrays.sort(nums);

        List<Integer> list = new ArrayList<>();

        // Check middle elements
        for (int i = 1; i < nums.length - 1; i++) {

            if (nums[i - 1] + 1 < nums[i] &&
                nums[i] + 1 < nums[i + 1]) {

                list.add(nums[i]);
            }
        }

        // Only one element
        if (nums.length == 1) {
            list.add(nums[0]);
        }

        // Check first and last elements
        if (nums.length > 1) {

            // First element
            if (nums[0] + 1 < nums[1]) {
                list.add(nums[0]);
            }

            // Last element
            if (nums[nums.length - 2] + 1 < nums[nums.length - 1]) {
                list.add(nums[nums.length - 1]);
            }
        }

        return list;
    }
}
