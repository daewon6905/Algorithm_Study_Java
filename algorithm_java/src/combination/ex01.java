package combination;

import java.util.ArrayList;
import java.util.List;

public class ex01 {
    int[]nums = new int[]{1,2,3,4,5};
    List<List<Integer>> answer = new ArrayList<>();

    void dfs(int[] nums, int m, int start, List<Integer> curr, boolean[] visited) {
        if (curr.size() == m) {
            answer.add(new ArrayList<>(curr));
            return;
        }

        for (int i = start; i < nums.length; i++) {
            if(!visited[i]){
                curr.add(nums[i]);
                visited[i] = true;
                dfs(nums, m, i + 1, curr, visited);
                visited[i] = false;
                curr.remove(curr.size() - 1);
            }
        }
    }

    List<List<Integer>> solution(int m) {
        dfs(nums, m, 0, new ArrayList<>(), new boolean[nums.length]);
        return answer;
    }

    public static void main(String[] args) {
        ex01 ex01 = new ex01();
        System.out.println(ex01.solution(2));

    }
}
