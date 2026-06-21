package 기본문제.태어난김에세계일주1;


import java.util.ArrayList;
import java.util.List;

//완전탐색 재귀 풀이
public class 태어난김에세계일주2 {
    int maxCountries = 0;

    public int solution(int balance, int[][]countries){
        int n = countries.length;
        boolean[] visited = new boolean[n];
        List<List<Integer>> p = new ArrayList<>();
        permutation(n, p, new ArrayList<>(), visited);

        for (List<Integer> path : p) {
            int curBal = balance;
            int count = 0;
            for (int c : path) {
                if(curBal >= countries[c][1]){
                    count++;
                    curBal -= countries[c][0];
                }else{
                    break;
                }
            }
            maxCountries = Math.max(maxCountries, count);
        }
        return maxCountries;
    }

    public void permutation(int target, List<List<Integer>> p, List<Integer> cur, boolean[]visited){
        if (cur.size() == target) {
            p.add(new ArrayList<>(cur));
            return;
        }
        for(int i=0;i<target;i++){
            if(!visited[i]){
                cur.add(i);
                visited[i] = true;
                permutation(target, p, cur, visited);
                cur.remove(cur.size() - 1);
                visited[i] = false;
            }
        }
    }
}
