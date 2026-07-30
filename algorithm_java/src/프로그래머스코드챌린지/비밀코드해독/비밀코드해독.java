package 프로그래머스코드챌린지.비밀코드해독;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class 비밀코드해독 {
    public int solution(int n, int[][] q, int[] ans) {
        int answer = 0;
        List<List<Integer>>comb = new ArrayList<>();
        combination(1,n,new ArrayList<>(),comb);
        for(List<Integer>c : comb){
            Set<Integer> set = new HashSet<>(c);
            boolean success = true;
            for(int i=0;i<q.length;i++){
                int matchCount = 0;
                int[]cur = q[i];
                int target = ans[i];
                for(int j=0;j<5;j++){
                    if(set.contains(cur[j])){
                        matchCount++;
                    }
                    // for(int lc : c){
                    //     if(lc == cur[j]) matchCount++;
                    // }
                }
                if(matchCount != target){
                    success = false;
                    break;
                }
            }
            if(success) answer++;
        }
        return answer;
    }
    public void combination(int start, int n, List<Integer> tmp, List<List<Integer>>comb){
        if(tmp.size()==5){
            comb.add(new ArrayList<>(tmp));
            return;
        }
        for(int i=start;i<=n;i++){
            tmp.add(i);
            combination(i+1,n,tmp,comb);
            tmp.remove(tmp.size()-1);
        }
    }
}
