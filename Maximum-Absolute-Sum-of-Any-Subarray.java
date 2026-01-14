1class Solution {
2    public int maxAbsoluteSum(int[] nums) {
3        int sum = 0, minSum = 0, maxSum = 0;
4        for (int num : nums) {
5            sum += num;
6            if (sum > maxSum) maxSum = sum;
7            if (sum < minSum) minSum = sum;
8        }
9        return Math.abs(maxSum - minSum);
10    }
11}