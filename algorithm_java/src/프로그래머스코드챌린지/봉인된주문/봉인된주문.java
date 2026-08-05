package 프로그래머스코드챌린지.봉인된주문;

import java.util.*;

public class 봉인된주문 {
    char[]c = new char[]
            {'a','b','c','d','e','f','g'
                    ,'h','i','j','k','l'
                    ,'m','n','o','p','q','r'
                    ,'s','t','u','v','w','x','y','z'};
    long n;
    public String solution(long n, String[] bans) {
        this.n = n;
        Arrays.sort(bans,new Comparator<>(){
            @Override
            public int compare(String s1, String s2){
                if(s1.length() == s2.length()){
                    return s1.compareTo(s2);
                }else{
                    return s1.length() - s2.length();
                }
            }
        });
        n = n-1;
        for(int i=0;i<bans.length;i++){
            long banNum = strToLong(bans[i]);
            if(banNum <= n){
                n++;
            }
        }

        return longToString(n);
    }
    public long strToLong(String s){
        long num = 0;
        int len = s.length();
        for(int i=0;i<len;i++){
            int idx = 0;
            for(int j=0;j<c.length;j++){
                if(s.charAt(i) == c[j]){
                    idx += j+1;
                    break;
                }
            }
            if(i == len-1){
                num += idx;
            }else{
                num += Math.pow(26,len-i-1)*idx;
            }
        }
        return num-1;
    }
    public String longToString(long num){
        if(num>=0 && num<26){
            return String.valueOf(c[(int)num]);
        }else{
            return longToString(num/26-1) + longToString(num%26);
        }
    }
}
