1class Solution {
2public int findKthLargest(int[] nums, int k) {
3    PriorityQueue<Integer> minHeap = new PriorityQueue<>();
4    for (int num : nums) {
5        minHeap.offer(num);
6        if (minHeap.size() > k) minHeap.poll(); 
7    }
8    return minHeap.peek(); 
9}
10}