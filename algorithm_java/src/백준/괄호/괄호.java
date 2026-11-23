package 백준.괄호;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class 괄호 {
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            check(br.readLine());
        }
        System.out.println(sb);
    }

    static void check(String line) {
        Deque<Character> stack = new ArrayDeque<>();
        for (char c : line.toCharArray()) {
            if(c == '('){
                stack.push(c);
            }else{
                if(stack.isEmpty()){
                    sb.append("NO\n");
                    return;
                }
                stack.pop();
            }
        }
        if (stack.isEmpty()) {
            sb.append("YES\n");
        }else{
            sb.append("NO\n");
        }
    }
}
