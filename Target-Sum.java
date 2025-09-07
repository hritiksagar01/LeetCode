class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        return solve(nums, nums.length - 1, target);
    }
    private int solve(int[] nums, int index, int target) {
        // Base case
        if (index == 0) {
            if (target == nums[0] && target == -nums[0]) return 2; // e.g. nums[0] = 0
            if (target == nums[0] || target == -nums[0]) return 1;
            return 0;
        }
        // Choice 1: Put '+'
        int plus = solve(nums, index - 1, target - nums[index]);
        // Choice 2: Put '-'
        int minus = solve(nums, index - 1, target + nums[index]);
        return plus + minus;
    }
}
