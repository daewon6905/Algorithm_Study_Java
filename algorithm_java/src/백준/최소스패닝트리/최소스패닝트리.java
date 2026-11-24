package 백준.최소스패닝트리;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class 최소스패닝트리 {
    static int[] parents;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int v = Integer.parseInt(st.nextToken());
        int e = Integer.parseInt(st.nextToken());
        int[][] edges = new int[e][3];
        parents = new int[v+1];
        for (int i = 1; i <= v; i++) {
            parents[i] = i;
        }
        for (int i = 0; i < e; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            edges[i] = new int[]{a, b, w};
        }
        Arrays.sort(edges, Comparator.comparingInt(a -> a[2]));
        int count = 0;
        int sum = 0;
        for (int i = 0; i < e; i++) {
            if(count == v-1) break;
            if (union(edges[i][0], edges[i][1])) {
                sum += edges[i][2];
                count++;
            }
        }
        System.out.println(sum);
    }

    static boolean union(int a, int b) {
        int p1 = find(a);
        int p2 = find(b);
        if(p1 == p2) return false;
        else {
            if(p1>p2) parents[p1] = p2;
            else parents[p2] = p1;
            return true;
        }
    }

    static int find(int n) {
        if (parents[n] != n) {
            parents[n] = find(parents[n]);
        }
        return parents[n];
    }
}
