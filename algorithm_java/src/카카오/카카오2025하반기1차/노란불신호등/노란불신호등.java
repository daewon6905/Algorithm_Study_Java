package 카카오.카카오2025하반기1차.노란불신호등;

public class 노란불신호등 {
    int n;
    public int solution(int[][] signals) {
        n = signals.length;
        int maxTime = 1;
        // for(int i=0;i<n;i++){
        //     int c = signals[i][0] + signals[i][1] + signals[i][2];
        //     maxTime = lcm(maxTime,c);
        // }
        for(int t=1;t<=3000000;t++){
            boolean isAllYellow = true;
            for(int i=0;i<n;i++){
                int g = signals[i][0];
                int y = signals[i][1];
                int r = signals[i][2];
                int c = g + y + r;
                int remain = (t-1) % c;
                if(!(g<=remain && remain<g+y)){
                    isAllYellow = false;
                    break;
                }
            }
            if(isAllYellow){
                return t;
            }
        }
        return -1;
    }
    //최대공약수
    // public int gcd(int a, int b){
    //     while(b>0){
    //         int tmp = b;
    //         b = a%b;
    //         a = tmp;
    //     }
    //     return a;
    // }
    // //최소공배수
    // public int lcm(int a, int b){
    //     return (a*b)/gcd(a,b);
    // }

}
