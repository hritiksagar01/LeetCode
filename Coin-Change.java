1class Solution {
2    public int coinChange(int[] coins, int amount) {
3        int[] dp = new int[amount + 1];
4        Arrays.fill(dp, amount + 1);
5
6        dp[0] = 0;
7
8        for (int coin : coins) {
9            for (int x = coin; x <= amount; x++) {
10                dp[x] = Math.min(dp[x], 1 + dp[x - coin]);
11            }
12        }
13
14        return dp[amount] > amount ? -1 : dp[amount];
15    }
16}
17