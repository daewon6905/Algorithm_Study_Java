package 프로그래머스.둘만의암호;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class 둘만의암호 {
    String alphabet = "abcdefghijklmnopqrstuvwxyz";
    public String solution(String s, String skip, int index) {
        Map<Character ,Integer> map = new HashMap<>();
        Set<Character> set = new HashSet<>();
        for(char c : skip.toCharArray()){
            set.add(c);
        }
        for(int i=0;i<alphabet.length();i++){
            map.put(alphabet.charAt(i), i);
        }
        StringBuilder sb = new StringBuilder();
        for(char c : s.toCharArray()){
            int curIdx = map.get(c);
            int iter = 1;
            int count = 0;
            char next = ' ';
            while(count < index){
                int nextIdx = curIdx + iter;
                if(nextIdx >= alphabet.length()){
                    nextIdx %= alphabet.length();
                }
                if(set.contains(alphabet.charAt(nextIdx))){
                    iter++;
                    continue;
                }
                next = alphabet.charAt(nextIdx);
                iter++;
                count++;
            }
            sb.append(next);
        }
        return sb.toString();
    }
}
