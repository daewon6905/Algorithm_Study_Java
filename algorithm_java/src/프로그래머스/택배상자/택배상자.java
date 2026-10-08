package 프로그래머스.택배상자;

import java.util.ArrayDeque;
import java.util.Deque;

public class 택배상자 {
    public int solution(int[] order) {
        Deque<Integer> stack = new ArrayDeque<>();

        int answer = 0;
        int box = 1;

        for (int target : order) {
            while (box <= order.length && box < target) {
                stack.push(box++);
            }

            if (box == target) {
                answer++;
                box++;
            }else if (!stack.isEmpty() && stack.peek() == target) {
                stack.pop();
                answer++;
            }else {
                break;
            }
        }
        return answer;
    }
}
