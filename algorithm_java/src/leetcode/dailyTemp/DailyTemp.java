package leetcode.dailyTemp;

import java.util.ArrayDeque;
import java.util.Deque;

public class DailyTemp {
    public int[] dailyTemperatures(int[] temperatures) {
        Deque<Integer> stack = new ArrayDeque<>();
        int n = temperatures.length;
        int[]answer = new int[n];

        for(int i=0;i<n;i++){
            while(!stack.isEmpty() && temperatures[i]>temperatures[stack.peek()]){
                int cur = stack.pop();
                answer[cur] = i - cur;
            }
            stack.push(i);
        }
        return answer;
    }
}
