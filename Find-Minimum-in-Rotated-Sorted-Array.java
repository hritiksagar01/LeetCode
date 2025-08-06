class Solution {
    public int findMin(int[] nums) {
        // If the array is empty or has one element, handle it.
        if (nums == null || nums.length == 0) {
            throw new IllegalArgumentException("Input array is empty");
        }
        if (nums.length == 1) {
            return nums[0];
        }

        int low = 0;
        int high = nums.length - 1;

        // Optimization: If the array is not rotated at all,
        // the first element is the minimum.
        if (nums[low] < nums[high]) {
            return nums[low];
        }

        // Binary search to find the inflection point (the minimum element).
        while (low < high) {
            int mid = low + (high - low) / 2;

            // Case 1: mid is in the "larger" part of the array.
            // The minimum element must be to the right of mid.
            if (nums[mid] > nums[high]) {
                low = mid + 1;
            } 
            // Case 2: mid is in the "smaller" part of the array.
            // nums[mid] could be the minimum, so we can't discard it.
            // The minimum is either mid or to its left.
            else {
                high = mid;
            }
        }

        // The loop terminates when low and high converge.
        // This single element is the minimum.
        return nums[low];
    }
}