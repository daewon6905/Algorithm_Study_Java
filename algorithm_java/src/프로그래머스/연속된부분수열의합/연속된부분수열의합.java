package 프로그래머스.연속된부분수열의합;

public class 연속된부분수열의합 {
    public int[] solution(int[] sequence, int k) {
        int[] answer = new int[2];
        int min = Integer.MAX_VALUE;
        int left = 0;
        int right = 0;
        int sum = sequence[0];
        while(left <= right){
            if(sum == k){
                int currentLen = right - left + 1;
                if(min > currentLen){
                    answer[0] = left;
                    answer[1] = right;
                    min = currentLen;
                }
            }
            if(sum < k){
                right++;
                if(right == sequence.length){
                    break;
                }
                sum+=sequence[right];
            }else{
                sum-=sequence[left];
                left++;
            }
        }
        return answer;
    }
}
