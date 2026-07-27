package leetcode.substringwithConcatenationofAllWords;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SubstringwithConcatenationofAllWords {
    public List<Integer> findSubstring(String s, String[] words) {
        int L = words[0].length();
        List<Integer>answer = new ArrayList<>();

        Map<String,Integer> answerMap = new HashMap<>();
        for(String w : words){
            answerMap.put(w, answerMap.getOrDefault(w,0)+1);
        }
        for(int i=0;i<L;i++){
            int left = i;
            int count = 0;
            Map<String,Integer>windowMap = new HashMap<>();
            for(int right=i;right+L<=s.length();right+=L){
                String sub = s.substring(right,right+L);
                if(answerMap.containsKey(sub)){
                    windowMap.put(sub,windowMap.getOrDefault(sub,0)+1);
                    count++;
                    while(windowMap.get(sub) > answerMap.get(sub)){
                        String remove = s.substring(left,left+L);
                        windowMap.put(remove,windowMap.get(remove)-1);
                        left+=L;
                        count--;
                    }
                    if(count == words.length){
                        answer.add(left);
                    }
                }else{
                    windowMap.clear();
                    count = 0;
                    left = right+L;
                }
            }
        }
        return answer;
    }
}
