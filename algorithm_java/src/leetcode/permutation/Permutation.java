package leetcode.permutation;

import java.util.ArrayList;
import java.util.List;

public class Permutation {
    int n;
    public List<List<Integer>> permute(int[] nums) {
        n = nums.length;
        boolean[]visited = new boolean[n];
        List<List<Integer>>answer = new ArrayList<>();
        permutation(nums,visited,new ArrayList<>(),answer);
        return answer;
    }

    void permutation(int[]nums,boolean[]visited,List<Integer>tmp,List<List<Integer>>answer){
        if(tmp.size() == n){
            answer.add(new ArrayList<>(tmp));
            return;
        }
        for(int i=0;i<n;i++){
            if(!visited[i]){
                visited[i] = true;
                tmp.add(nums[i]);
                permutation(nums,visited,tmp,answer);
                visited[i] = false;
                tmp.remove(tmp.size()-1);
            }
        }
    }
}
