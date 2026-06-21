package 기본문제.올바른괄호쌍;

import java.util.ArrayDeque;
import java.util.Deque;

public class 올바른괄호쌍 {

    public int solution(String s) {
        int answer = 0;
        Deque<Character> stack = new ArrayDeque<>();

        for (char c : s.toCharArray()) {
            if(c == '('){
                stack.push(')');
            }else if(c == '{'){
                stack.push('}');
            }else if(c == '['){
                stack.push(']');
            }else{
                if(stack.isEmpty() || stack.peek() != c){
                    return -1;
                }else if(stack.peek() == c){
                    answer++;
                }
            }
        }
        return stack.isEmpty() ? answer : -1;
    }
}
