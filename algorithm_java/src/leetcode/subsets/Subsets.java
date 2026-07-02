package leetcode.subsets;

import java.util.ArrayList;
import java.util.List;

public class Subsets {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>>s = new ArrayList<>();
        subset(0,new ArrayList<>(),s,nums);
        return s;
    }

    void subset(int start, List<Integer> tmp, List<List<Integer>>s, int[]nums){
        s.add(new ArrayList<>(tmp));
        for(int i=start;i<nums.length;i++){
            tmp.add(nums[i]);
            subset(i+1,tmp,s,nums);
            tmp.remove(tmp.size()-1);
        }
    }
}
