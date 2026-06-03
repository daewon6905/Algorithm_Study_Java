package bruteforce_C_P_S.problems;
//완전탐색 풀이
public class Q1 {
    int answer;
    public int solution(int balance, int[][] countries) {
        boolean[]visited = new boolean[countries.length];
        answer = 0;
        dfs(balance,0,countries,visited);
        return answer;
    }

    void dfs(int balance,int count, int[][]countries, boolean[]visited){
        answer = Math.max(count,answer);
        for(int i=0;i<countries.length;i++){
            if(!visited[i] && balance >= countries[i][1]){
                visited[i] = true;
                dfs(balance - countries[i][0],count+1,countries,visited);
                visited[i] = false;
            }
        }
    }

    public static void main(String[] args) {
        Q1 q1 = new Q1();
        int balance = 600;
        int[][]countries = new int[][]{{70, 350}, {100, 550}, {350, 400}};
        System.out.println("최대 방문 국가 수: "+ q1.solution(balance,countries));
    }
}
