package 프로그래머스.문자열압축;

public class 문자열압축 {
    public int solution(String s) {
        int n = s.length();
        int minLength = Integer.MAX_VALUE;
        if(n==1)return 1;
        for(int i=1;i<=(n/2);i++){
            int count = 1;
            String prev = "";
            StringBuilder sb = new StringBuilder();
            for(int j=0;j<n;j+=i){
                int end = Math.min(j+i,n);
                String cur = s.substring(j,end);
                if(j==0){
                    prev = cur;
                    continue;
                }
                if(prev.equals(cur)){
                    count++;
                }else{
                    if(count>1) sb.append(count);
                    sb.append(prev);
                    prev = cur;
                    count = 1;
                }
            }
            if(count>1) sb.append(count);
            sb.append(prev);
            minLength = Math.min(minLength, sb.length());
        }
        return minLength;
    }
}
