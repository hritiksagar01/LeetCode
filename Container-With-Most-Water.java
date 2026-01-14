1class Solution {
2    public int maxArea(int[] height) {
3        int maxArea = 0;
4        int left = 0;
5        int right = height.length - 1;
6
7        while (left < right) {
8            maxArea = Math.max(maxArea, (right - left) * Math.min(height[left], height[right]));
9
10            if (height[left] < height[right]) {
11                left++;
12            } else {
13                right--;
14            }
15        }
16
17        return maxArea;        
18    }
19}