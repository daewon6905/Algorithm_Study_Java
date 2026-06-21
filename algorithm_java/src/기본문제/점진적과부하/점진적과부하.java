package 기본문제.점진적과부하;

import java.util.ArrayDeque;
import java.util.Deque;

public class 점진적과부하 {

    public int[] solution(int[] weights) {
        int n = weights.length;
        int[] answer = new int[n];
        Deque<int[]> stack = new ArrayDeque<>();

        for (int cur = 0; cur < n; cur++) {
            int w = weights[cur];
            while(!stack.isEmpty() && stack.peek()[1] < w){
                int[] popped = stack.pop();
                answer[cur] = cur - popped[0];
            }
            stack.push(new int[]{cur,w});
        }
        return answer;
    }
}
