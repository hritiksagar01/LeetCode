1class Solution {
2    public boolean canPartition(int[] nums) {
3        int total = 0;
4        for (int x : nums) total += x;
5
6        if (total % 2 != 0) return false;
7
8        int target = total / 2;
9        int n = nums.length;
10
11        boolean[][] dp = new boolean[n + 1][target + 1];
12
13        // base case: sum = 0
14        for (int i = 0; i <= n; i++) {
15            dp[i][0] = true;
16        }
17
18        for (int i = 1; i <= n; i++) {
19            for (int j = 1; j <= target; j++) {
20
21                if (nums[i - 1] <= j) {
22                    dp[i][j] =
23                        dp[i - 1][j - nums[i - 1]]
24                     || dp[i - 1][j];
25                } else {
26                    dp[i][j] = dp[i - 1][j];
27                }
28
29            }
30        }
31
32        return dp[n][target];
33    }
34}
35