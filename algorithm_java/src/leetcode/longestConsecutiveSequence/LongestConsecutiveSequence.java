package leetcode.longestConsecutiveSequence;

import java.util.HashSet;
import java.util.Set;

public class LongestConsecutiveSequence {
    public int longestConsecutive(int[] nums) {
        int answer = 0;
        Set<Integer> set = new HashSet<>();
        for(int n : nums){
            set.add(n);
        }
        for(int n : set){
            int tmp = 0;
            if(!set.contains(n-1)){
                while(set.contains(n++)){
                    tmp++;
                }
                answer = Math.max(answer , tmp);
            }
        }
        return answer;
    }
}
