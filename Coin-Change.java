import java.util.Arrays;

class Solution {
    public int coinChange(int[] coins, int amount) {
        // memo[i] will store the min coins for amount i.
        // Initialize with a value to indicate not yet computed.
        int[] memo = new int[amount + 1];
        // We use a value like -2 to distinguish from computed values (0, positive ints, or -1 for impossible)
        Arrays.fill(memo, -2); 
        
        int result = findMinCoins(coins, amount, memo);
        return result == Integer.MAX_VALUE ? -1 : result;
    }
    
    private int findMinCoins(int[] coins, int amount, int[] memo) {
        // Base case: Amount is negative, impossible path.
        if (amount < 0) {
            return Integer.MAX_VALUE;
        }
        // Base case: Amount is zero, 0 coins needed.
        if (amount == 0) {
            return 0;
        }
        // If we have already computed this subproblem, return the stored result.
        if (memo[amount] != -2) {
            return memo[amount];
        }
        
        int minCount = Integer.MAX_VALUE;
        
        for (int coin : coins) {
            int result = findMinCoins(coins, amount - coin, memo);
            
            if (result != Integer.MAX_VALUE) {
                minCount = Math.min(minCount, 1 + result);
            }
        }
        
        // Store the computed result in the memoization table before returning.
        memo[amount] = minCount;
        return minCount;
    }
}