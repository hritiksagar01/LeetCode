1class Solution {
2    public int maxSubArray(int[] nums) {
3        int n = nums.length;
4        int[] dp = new int[n];
5        dp[0] = nums[0];
6        int max = dp[0];
7        for(int i =1 ; i < n ;i++){
8            dp[i] = Math.max(dp[i-1] + nums[i] , nums[i]);
9            max = Math.max(dp[i] , max);
10
11        }
12        return max;
13    }
14}