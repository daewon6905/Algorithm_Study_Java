package 백준.그래프.DFS와BFS;

import java.util.*;
import java.io.*;

public class DFS와BFS {

    static List<List<Integer>> graph = new ArrayList<>();
    static boolean[] visited;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int v = Integer.parseInt(st.nextToken());

        for(int i=0;i<=n;i++){
            graph.add(new ArrayList<>());
        }

        for(int i=0;i<m;i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            graph.get(a).add(b);
            graph.get(b).add(a);
        }

        for(int i=0;i<=n;i++){
            Collections.sort(graph.get(i));
        }
        visited = new boolean[n + 1];
        dfs(v);
        sb.append('\n');

        visited = new boolean[n + 1];
        bfs(v);
        sb.append('\n');

        System.out.println(sb);
    }

    static void dfs(int v) {
        visited[v] = true;
        sb.append(v).append(' ');
        for (int next : graph.get(v)) {
            if(!visited[next]){
                dfs(next);
            }
        }
    }

    static void bfs(int v) {
        Queue<Integer> queue = new ArrayDeque<>();
        visited[v] = true;
        queue.add(v);
        sb.append(v).append(' ');
        while (!queue.isEmpty()) {
            int cur = queue.poll();
            for (int next : graph.get(cur)) {
                if(!visited[next]){
                    queue.add(next);
                    visited[next] = true;
                    sb.append(next).append(' ');
                }
            }
        }
    }
}
