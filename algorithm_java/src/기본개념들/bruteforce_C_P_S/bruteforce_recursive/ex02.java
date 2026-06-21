package 기본개념들.bruteforce_C_P_S.bruteforce_recursive;

public class ex02 {
    int[]nums = new int[]{4,9,7,5,1};
    int target = 13;

    //재귀에서 boolean값 리턴해서 중간에 조건이 맞으면 즉시 true 리턴. (가지치기/조기리턴)
    boolean dfs(int[]nums, int target, int m, int start, int depth,int sum){
        if (depth == m) {
            return sum == target;
        }
        for (int i = start; i < nums.length; i++) {
            if (dfs(nums, target, m, i + 1, depth + 1, sum + nums[i])) {
                return true;
            } //이렇게 매게변수로 sum값을 넘겨주면 아래처럼 더했다가 되돌리는 과정 필요없음.
            /*
                sum += nums[i];
                if(dfs(nums,target,m,i+1,depth+1,sum)){
                    return true;
                }
                sum -= nums[i];
             */
        }
        return false;
    }

    boolean solution(int[] nums, int target, int m) {
        return dfs(nums, target, m, 0, 0, 0);
    }

    public static void main(String[] args) {
        ex02 ex01 = new ex02();
        int m = 3;
        System.out.println("배열 3요소의 합이 " + ex01.target + "이 될수 있는지 여부 판단 :");
        if (ex01.solution(ex01.nums, ex01.target,m)) {
            System.out.println("가능");
        }else{
            System.out.println("불가능");
        }
    }
}
