package 프로그래머스.두큐합같게만들기;

public class 두큐합같게만들기 {
    public int solution(int[] queue1, int[] queue2) {
        int n = queue1.length;
        int count = 0;
        int left = 0;
        int right = n;
        int[]queue = new int[2*n];
        long sum1 = 0;
        long sum2 = 0;

        for(int i=0;i<n;i++){
            queue[i] = queue1[i];
            queue[i+n] = queue2[i];
            sum1+=queue1[i];
            sum2+=queue2[i];
        }
        long target = (sum1+sum2)/2;
        while(left<=right && right<=2*n-1){
            if(sum1 == target) return count;
            if(sum1<target){
                sum1+=queue[right++];
            }else{
                sum1-=queue[left++];
            }
            count++;
        }
        return -1;
    }
}
