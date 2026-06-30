package 프로그래머스.후보키;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
//후보키 -> 유일성, 최소성 만족
public class 후보키 {
    public int solution(String[][] relation) {
        int rowLen = relation.length;
        int colLen = relation[0].length;
        List<Set<Integer>> candidateKey = new ArrayList<>(); //리스트의 요소는 중복 방지가 이유는 아님. set의 containsAll() 메서드 활용이 더 이유가 큼

        for(int i=1;i<=colLen;i++){
            List<List<Integer>> comb = new ArrayList<>();
            combination(0,colLen,i,new ArrayList<>(),comb);
            for(List<Integer>list : comb){
                Set<Integer>colSet = new HashSet<>(list);
                if(!isMinimal(candidateKey,colSet)) continue;
                Set<String>set = new HashSet<>();
                for(int j=0;j<rowLen;j++){
                    String key = "";
                    for(int idx : list){
                        key += relation[j][idx];
                    }
                    set.add(key);
                }
                if(set.size() == rowLen){
                    candidateKey.add(colSet);
                }
            }
        }
        return candidateKey.size();
    }

    boolean isMinimal(List<Set<Integer>>candidateKey, Set<Integer>colSet){
        for(Set<Integer>ck : candidateKey){
            if(colSet.containsAll(ck)) return false;
        }
        return true;
    }

    void combination(int start, int n, int target, List<Integer>tmp, List<List<Integer>>c){
        if(tmp.size() == target){
            c.add(new ArrayList<>(tmp));
            return;
        }
        for(int i=start;i<n;i++){
            tmp.add(i);
            combination(i+1,n,target,tmp,c);
            tmp.remove(tmp.size()-1);
        }
    }
}
