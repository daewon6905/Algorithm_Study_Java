package leetcode.binartSearch;

import java.util.HashMap;
import java.util.Map;

public class HashMapSol {
    public int search(int[] nums, int target) {
        Map<Integer,Integer> map = new HashMap<>();
        for(int i=0;i<nums.length;i++){
            map.put(nums[i],i);
        }
        return map.getOrDefault(target,-1);
    }
}
