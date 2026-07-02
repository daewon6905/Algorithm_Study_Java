package leetcode.combinations;

import java.util.ArrayList;
import java.util.List;

public class Combination {
    class Solution {
        public List<List<Integer>> combine(int n, int k) {
            List<List<Integer>>answer = new ArrayList<>();
            combination(1,n,k,new ArrayList<>(),answer);
            return answer;
        }
        void combination(int start, int n,int k, List<Integer>tmp, List<List<Integer>>answer){
            if(tmp.size() == k){
                answer.add(new ArrayList<>(tmp));
                return;
            }
            for(int i=start;i<=n;i++){
                tmp.add(i);
                combination(i+1,n,k,tmp,answer);
                tmp.remove(tmp.size()-1);
            }
        }
    }
}
