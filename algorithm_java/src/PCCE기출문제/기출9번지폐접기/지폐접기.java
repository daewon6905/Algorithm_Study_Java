package PCCE기출문제.기출9번지폐접기;
import java.util.*;

public class 지폐접기 {
    public int solution(int[] wallet, int[] bill) {
        int answer = 0;
        Arrays.sort(wallet);
        int bigger;
        int smaller;
        bigger = Math.max(bill[0],bill[1]);
        smaller = Math.min(bill[0],bill[1]);
        while(smaller>wallet[0] || bigger>wallet[1]){
            bigger = bigger/2;
            if(bigger<smaller){
                int tmp = bigger;
                bigger = smaller;
                smaller = tmp;
            }
            answer++;
        }
        return answer;
    }
}
