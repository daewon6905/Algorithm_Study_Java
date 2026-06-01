package permutation;

import java.util.ArrayList;
import java.util.List;

public class ex01 {
    int[] nums = new int[]{1, 2, 3, 4};
    List<List<Integer>> answer = new ArrayList<>();

    void dfs(int[] nums, int m, List<Integer> curr, boolean[] visited) {
        if (curr.size() == m) {
            answer.add(new ArrayList<>(curr));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (!visited[i]) {
                curr.add(nums[i]);
                visited[i] = true;
                dfs(nums, m, curr, visited);
                visited[i] = false;
                curr.remove(curr.size() - 1);
            }
        }
    }
    public List<List<Integer>> solution(int m) {
        dfs(nums, m, new ArrayList<>(), new boolean[nums.length]);
        return answer;
    }

    public static void main(String[] args) {
        ex01 ex01 = new ex01();
        System.out.println(ex01.solution(2));
    }
}
