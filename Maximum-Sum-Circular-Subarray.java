1class Solution {
2
3    public int maxSubarraySumCircular(int[] nums) {
4        int totalSum = 0;
5        int maxSum = Integer.MIN_VALUE;
6        int currMax = 0;
7        int minSum = Integer.MAX_VALUE;
8        int currMin = 0;
9        for(int n : nums){
10            totalSum += n;
11            currMax = Math.max( currMax + n , n);
12            currMin = Math.min( currMin + n , n);
13            maxSum = Math.max(maxSum , currMax);
14            minSum = Math.min( minSum , currMin);
15        }
16        if( maxSum < 0)
17        return maxSum;
18        return Math.max(maxSum, totalSum - minSum);
19    }
20}