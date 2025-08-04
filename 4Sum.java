class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        return kSum(nums, 0, 4, target);
    }

    public List<List<Integer>> kSum(int[] nums, int start, int k, long target) {
        List<List<Integer>> res = new ArrayList<>();
        int len = nums.length;
        if(start >= len) {
                return res;
        }
        if(k==2){
            int left = start, right = len-1;
            while(left < right){
                long sum = nums[left] + nums[right];
                if(sum == target){
                    List<Integer> path = new ArrayList<>();
                    path.add(nums[left]);
                    path.add(nums[right]);
                    res.add(path);
                    while(left < right && nums[left] == nums[left+1]) left++;
                    while(left < right && nums[right] == nums[right-1]) right--;
                    left++;
                    right--;
                }else if(sum < target){
                    left++;
                }else{
                    right--;
                }

            }
        }
        else{
            for(int i=start; i < len - (k-1); i++){
                if(i > start && nums[i] == nums[i-1]) continue;

                List<List<Integer>> temp = kSum(nums, i+1, k-1, target - nums[i]);
                for(List<Integer> t : temp){
                    t.add(0, nums[i]);
                }
                res.addAll(temp);
            }
        }
        return res;
    }
    
} 