package 프로그래머스.뒤에있는큰수찾기;

import java.util.ArrayDeque;
import java.util.Deque;

public class 뒤에있는큰수찾기 {
    public int[] solution(int[] numbers) {
        int n = numbers.length;
        int[] answer = new int[n];
        Deque<Integer> stack = new ArrayDeque<>();

        for(int i=0;i<n;i++){
            int number = numbers[i];
            while(!stack.isEmpty() && number > numbers[stack.peek()]){
                int prev = stack.pop();
                answer[prev] =  numbers[i];
            }
            stack.push(i);
        }
        for(int i=0;i<n;i++){
            if(answer[i] == 0) answer[i] = -1;
        }
        return answer;
    }
}
