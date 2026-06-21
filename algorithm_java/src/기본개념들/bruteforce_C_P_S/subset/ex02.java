package 기본개념들.bruteforce_C_P_S.subset;

import java.util.ArrayList;
import java.util.List;

public class ex02 {
    int[]nums = new int[]{1,2,3,4};
    List<List<Integer>> answer = new ArrayList<>();

    void dfs(int[] nums, List<Integer> curr, int idx) {
        if (idx == nums.length) {
            answer.add(new ArrayList<>(curr));
            return;
        }

        // 1. 미포함(X) 갈래길
        // curr에 현재 원소를 넣지 않고 바로 다음 인덱스(idx + 1)로 넘어감.
        dfs(nums, curr, idx + 1);

        // 2. 포함(O) 갈래길
        // curr에 현재 원소(nums[idx])를 넣은 뒤 다음 인덱스로 넘어감.
        curr.add(nums[idx]);
        dfs(nums, curr, idx + 1);
        curr.remove(curr.size() - 1);
    }

    List<List<Integer>> solution() {
        dfs(nums, new ArrayList<>(), 0);
        return answer;
    }

    public static void main(String[] args) {
        ex02 ex02 = new ex02();
        System.out.println(ex02.solution());
    }
}
