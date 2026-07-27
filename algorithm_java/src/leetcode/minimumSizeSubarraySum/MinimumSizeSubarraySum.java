package leetcode.minimumSizeSubarraySum;

public class MinimumSizeSubarraySum {
    public int minSubArrayLen(int target, int[] nums) {
        int left = 0;
        int right = 0;
        int n = nums.length;
        int sum = 0;
        int min = Integer.MAX_VALUE;
        while(right < n){
            int cur = nums[right];
            if(sum < target){
                sum+=cur;
            }
            while(left<=right && target <= sum){
                if(min > right-left+1){
                    min = right-left+1;
                }
                sum-=nums[left];
                left++;
            }
            right++;
        }
        return min == Integer.MAX_VALUE ? 0 : min;
    }
}
