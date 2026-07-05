package leetcode.longestValidParentheses;

import java.util.ArrayDeque;
import java.util.Deque;

public class LongestValidParentheses {
    public int longestValidParentheses(String s) {
        int maxLength = 0;
        Deque<Integer> stack = new ArrayDeque<>();
        int n = s.length();
        stack.push(-1); // 시작부터 () 나오는 경우, 초기 -1값이 없으면 길이가 2지만 1로 나옴

        for (int i = 0; i < n; i++) {
            char cur = s.charAt(i);
            if(cur == '('){
                stack.push(i);
            }else{
                stack.pop();
                if (stack.isEmpty()) {
                    stack.push(i);
                }else{
                    maxLength = Math.max(maxLength, i - stack.peek());
                }
            }
        }
        return maxLength;
    }
}
