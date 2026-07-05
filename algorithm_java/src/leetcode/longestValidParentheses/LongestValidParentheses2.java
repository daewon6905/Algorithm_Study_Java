package leetcode.longestValidParentheses;

import java.util.ArrayDeque;
import java.util.Deque;

public class LongestValidParentheses2 {
    public int longestValidParentheses(String s) {
        int left = 0;
        int right = 0;
        int n = s.length();
        int maxLength = 0;

        for(int i=0;i<n;i++){
            char c = s.charAt(i);
            if(c == '('){
                left++;
            }else{
                right++;
            }
            if(left == right){
                maxLength = Math.max(maxLength,2*right);
            }
            if(left<right){
                left = 0;
                right = 0;
            }
        }
        left = 0;
        right = 0;

        for(int i=n-1;i>=0;i--){
            char c = s.charAt(i);
            if(c == '('){
                left++;
            }else{
                right++;
            }
            if(left == right){
                maxLength = Math.max(maxLength,2*left);
            }
            if(left>right){
                left = 0;
                right = 0;
            }
        }
        return maxLength;
    }
}
