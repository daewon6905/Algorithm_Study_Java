package 백준.그래프.바이러스;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class 바이러스 {
    static List<List<Integer>> graph = new ArrayList<>();
    static int answer = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }
        for (int i = 0; i < m; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            graph.get(a).add(b);
            graph.get(b).add(a);
        }
        boolean[]visited = new boolean[n+1];
        dfs(1, visited);
        System.out.println(answer-1);
    }

    static void dfs(int start, boolean[] visited) {
        visited[start] = true;
        answer++;
        for (int next : graph.get(start)) {
            if (!visited[next]) {
                dfs(next, visited);
            }
        }
    }
}
