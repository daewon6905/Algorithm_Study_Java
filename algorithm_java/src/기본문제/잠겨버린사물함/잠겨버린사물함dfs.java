package 기본문제.잠겨버린사물함;


public class 잠겨버린사물함dfs {

    public int solution(int[][] lockers) {
        int n = lockers.length;
        boolean[] visited = new boolean[n];

        int count = 0;
        dfs(0, lockers, visited);
        for (boolean bool : visited) {
            if(!bool) count++;
        }
        return count;
    }

    void dfs(int cur, int[][] lockers, boolean[] visited) {
        visited[cur] = true;
        for (int nxt : lockers[cur]) {
            if(!visited[nxt]){
                dfs(nxt, lockers, visited);
            }
        }

    }
}
