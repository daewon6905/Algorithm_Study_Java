package subset;

import java.util.ArrayList;
import java.util.List;

public class ex01 {
    int[]nums = new int[]{1,2,3,4};
    List<List<Integer>> answer = new ArrayList<>();

    void dfs(int[] nums, int start, List<Integer> curr) {
        answer.add(new ArrayList<>(curr));
        for (int i = start; i < nums.length; i++) {
            curr.add(nums[i]);
            dfs(nums,i + 1, curr);
            curr.remove(curr.size() - 1);
        }
    }

    List<List<Integer>> solution() {
        dfs(nums,  0, new ArrayList<>());
        return answer;
    }

    public static void main(String[] args) {
        ex01 ex01 = new ex01();
        System.out.println(ex01.solution());
    }
}
