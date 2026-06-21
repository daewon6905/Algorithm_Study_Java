package 기본개념들.priorityQueue;
import java.util.*;

class Node implements Comparable<Node> {
    int index;
    int distance;

    public Node(int index, int distance) {
        this.index = index;
        this.distance = distance;
    }
    @Override
    public int compareTo(Node o) {
        return Integer.compare(this.distance, o.distance);
    }
}

//반복적으로 최댓값, 최솟값을 찾아야하는 경우
public class Dijkstra {
    static final int INF = Integer.MAX_VALUE;
    static List<List<Node>> graph = new ArrayList<>();
    static int[]dist;

    public static void dijkstra(int start) {
        Queue<Node> pq = new PriorityQueue<>();

        pq.offer(new Node(start, 0));
        dist[start] = 0;

        while (!pq.isEmpty()) {
            Node poll = pq.poll();
            int index = poll.index;
            int currentDist = poll.distance;
            if(dist[index] < currentDist) continue;

            for (Node n : graph.get(index)) {
                if (dist[n.index] > currentDist + n.distance) {
                    dist[n.index] = currentDist + n.distance;
                    pq.offer(new Node(n.index, currentDist + n.distance));
                }
            }
        }
    }
    public static void main(String[] args) {
        int n = 5; // 노드의 개수
        int startNode = 1; // 시작 노드 번호

        // 그래프 및 최단거리 테이블 초기화
        dist = new int[n + 1];
        Arrays.fill(dist, INF);
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }

        // 그래프 간선 정보 입력 (예시: 임의의 단방향 그래프 가중치 설정)
        // 기본개념들.graph.get(출발).add(new Node(도착, 가중치));
        graph.get(1).add(new Node(2, 2));
        graph.get(1).add(new Node(3, 4));
        graph.get(2).add(new Node(3, 1));
        graph.get(2).add(new Node(4, 7));
        graph.get(3).add(new Node(5, 3));
        graph.get(4).add(new Node(5, 1));

        // 다익스트라 알고리즘 실행
        dijkstra(startNode);

        // 모든 노드로 가기 위한 최단 거리 출력
        System.out.println("--- 1번 노드로부터의 최단 거리 ---");
        for (int i = 1; i <= n; i++) {
            if (dist[i] == INF) {
                System.out.println(i + "번 노드: 도달 불가");
            } else {
                System.out.println(i + "번 노드: " + dist[i]);
            }
        }
    }
}
