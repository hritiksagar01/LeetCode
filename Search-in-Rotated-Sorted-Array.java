class Solution {
    public int search(int[] nums, int target) {
        int low = 0;
        int high = nums.length - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            // Case 1: Target found at mid
            if (nums[mid] == target) {
                return mid;
            }

            // Case 2: The left half [low...mid] is sorted
            if (nums[low] <= nums[mid]) {
                // Check if the target is within the sorted left half
                if (target >= nums[low] && target < nums[mid]) {
                    // Search in the left half
                    high = mid - 1;
                } else {
                    // Search in the right half
                    low = mid + 1;
                }
            } 
            // Case 3: The right half [mid...high] is sorted
            else {
                // Check if the target is within the sorted right half
                if (target > nums[mid] && target <= nums[high]) {
                    // Search in the right half
                    low = mid + 1;
                } else {
                    // Search in the left half
                    high = mid - 1;
                }
            }
        }

        // Target was not found in the array
        return -1;
    }
}