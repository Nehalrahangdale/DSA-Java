class Solution {

    public int search(int[] nums, int target) {
        return search(nums, target, 0, nums.length - 1);
    }

    public int search(int[] nums, int target, int si, int ei) {

        if (si > ei) {
            return -1;
        }

        int mid = si + (ei - si) / 2;

        if (nums[mid] == target) {
            return mid;
        }

        // Left half sorted
        if (nums[si] <= nums[mid]) {

            if (nums[si] <= target && target <= nums[mid]) {
                return search(nums, target, si, mid - 1);
            } else {
                return search(nums, target, mid + 1, ei);
            }

        }
        // Right half sorted
        else {

            if (nums[mid] <= target && target <= nums[ei]) {
                return search(nums, target, mid + 1, ei);
            } else {
                return search(nums, target, si, mid - 1);
            }
        }
    }
}
