package 프로그래머스.연속된부분수열의합;

public class 연속된부분수열의합2 {
    public int[] solution(int[] sequence, int k) {
        int[] answer = new int[2];
        int min = Integer.MAX_VALUE;
        int left = 0;
        int sum = 0;
        for(int right=0;right<sequence.length;right++){
            sum += sequence[right];
            while(sum > k && left<=right){
                sum -= sequence[left];
                left++;
            }
            if(sum == k){
                int currentLen = right - left + 1;
                if(min > currentLen){
                    answer[0] = left;
                    answer[1] = right;
                    min = currentLen;
                }
            }
        }
        return answer;
    }
}
