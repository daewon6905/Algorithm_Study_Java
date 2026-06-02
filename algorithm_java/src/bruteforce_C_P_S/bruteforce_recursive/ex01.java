package bruteforce_C_P_S.bruteforce_recursive;

import java.util.ArrayList;
import java.util.List;

public class ex01 {
    int[]nums = new int[]{4,9,7,5,1};
    int target = 13;

    //재귀에서 boolean값 리턴해서 중간에 조건이 맞으면 즉시 true 리턴. (가지치기/조기리턴)
    boolean dfs(int[]nums, int target, int start, List<Integer> selected){
        if (selected.size() == 3) {
            int sum = 0;
            for (int num : selected) {
                sum += num;
            }
            return sum == target;
        }

        for (int i = start; i < nums.length; i++) {
            selected.add(nums[i]);
            if (dfs(nums, target, i + 1, selected)) {
                return true;
            }
            selected.remove(selected.size() - 1);
        }
        return false;
    }

    boolean solution(int[] nums, int target) {
        return dfs(nums, target, 0, new ArrayList<>());
    }

    public static void main(String[] args) {
        ex01 ex01 = new ex01();
        System.out.println("배열 3요소의 합이 " + ex01.target + "이 될수 있는지 여부 판단 :");
        if (ex01.solution(ex01.nums, ex01.target)) {
            System.out.println("가능");
        }else{
            System.out.println("불가능");
        }
    }
}
