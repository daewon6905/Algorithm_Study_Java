package 기본문제.태어난김에세계일주1;


//완전탐색 재귀 풀이
public class 태어난김에세계일주1 {
    int maxCountries = 0;

    public int solution(int balance, int[][]countries){
        int n = countries.length;
        boolean[] visited = new boolean[n];
        dfs(0, balance, countries, visited);
        return maxCountries;
    }

    public void dfs(int count, int balance, int[][] countries, boolean[] visited) {
        maxCountries = Math.max(maxCountries, count);
        for (int i = 0; i < countries.length; i++) {
            if(!visited[i] && balance >= countries[i][1]){
                visited[i] = true;
                dfs(count + 1, balance - countries[i][0], countries, visited);
                visited[i] = false;
            }
        }
    }
}
