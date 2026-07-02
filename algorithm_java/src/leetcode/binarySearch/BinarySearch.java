package leetcode.binarySearch;

public class BinarySearch {
    int n;
    public int search(int[] nums, int target) {
        n = nums.length;
        int index = binarySearch(target, nums);
        if (nums[index] == target) {
            return index;
        }

        return -1;
    }
    int binarySearch(int target, int[]nums){
        int low = 0;
        int high = n-1;
        while (low < high) {
            int mid = (low+high)/2;
            if(target > nums[mid]){
                low = mid + 1;
            }else{
                high = mid;
            }
        }
        return low;
    }
}
