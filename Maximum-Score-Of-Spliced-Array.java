1class Solution {
2    public int maximumsSplicedArray(int[] nums1, int[] nums2) {
3        int n1 = nums1.length;
4        int n2 = nums2.length;
5        int totalSum1 =Arrays.stream(nums1).sum();
6        int totalSum2 =Arrays.stream(nums2).sum();
7        int currSum = 0;
8        int maxSum1 = Integer.MIN_VALUE;
9        int maxSum2 = Integer.MIN_VALUE;
10        
11        int diff1[] = new int[n1];
12        int diff2[] = new int[n2];
13        //for n1 to n2
14        for(int i =0; i < n1;i++){
15            diff1[i] = nums1[i]-nums2[i];
16            diff2[i] = nums2[i]- nums1[i];
17        }
18        for( int n : diff2){
19            currSum = Math.max(currSum + n , n);
20            maxSum1 = Math.max( maxSum1 , currSum);
21            if ( currSum < 0) currSum = 0;
22        }
23        currSum =0;
24        for( int n : diff1){
25            currSum = Math.max(currSum + n , n);
26            maxSum2 = Math.max( maxSum2 , currSum);
27            if ( currSum < 0) currSum = 0;
28        }
29        return Math.max(totalSum1+maxSum1 ,totalSum2+maxSum2 );
30    }
31}