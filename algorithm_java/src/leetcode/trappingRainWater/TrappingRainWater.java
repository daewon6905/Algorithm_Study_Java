package leetcode.trappingRainWater;

import java.util.ArrayDeque;
import java.util.Deque;

public class TrappingRainWater {
    class Solution {
        public int trap(int[] height) {
            Deque<Integer> stack = new ArrayDeque<>();
            int n = height.length;
            int answer = 0;

            for(int i=0;i<n;i++){
                while(!stack.isEmpty() && height[i]>height[stack.peek()]){
                    int bottom = stack.pop();
                    if(stack.isEmpty()) break;
                    int left = stack.peek();
                    int w = i - left - 1;
                    int h = Math.min(height[i],height[left]) - height[bottom];
                    answer += w*h;
                }
                stack.push(i);
            }
            return answer;
        }
    }
}
