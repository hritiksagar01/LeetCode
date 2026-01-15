1class Solution {
2    public int maxAbsoluteSum(int[] nums) {
3        int maxSoFar = 0;
4        int minSoFar = 0;
5        int currMax = 0;
6        int currMin = 0;
7
8        for (int n : nums) {
9            // Logic for Max Positive Sum
10            currMax = Math.max(0, currMax + n); // If currMax + n < 0, reset to 0
11            maxSoFar = Math.max(maxSoFar, currMax);
12
13            // Logic for Min Negative Sum
14            currMin = Math.min(0, currMin + n); // If currMin + n > 0, reset to 0
15            minSoFar = Math.min(minSoFar, currMin);
16        }
17        
18        return Math.max(maxSoFar, Math.abs(minSoFar));
19    }
20}