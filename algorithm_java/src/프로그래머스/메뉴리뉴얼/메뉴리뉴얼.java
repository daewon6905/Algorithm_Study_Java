package 프로그래머스.메뉴리뉴얼;

import java.util.*;

public class 메뉴리뉴얼 {
    public String[] solution(String[] orders, int[] course) {
        List<String>answerList = new ArrayList<>();
        for(int i=0;i<orders.length;i++){
            char[]arr = orders[i].toCharArray();
            Arrays.sort(arr);
            orders[i] = new String(arr);
        }
        for(int courseLen : course){
            Map<String, Integer>countMap = new HashMap<>();
            for(String order : orders){
                List<String>combination = new ArrayList<>();
                comb(0,courseLen,order,new StringBuilder(),combination);
                for(String c : combination){
                    countMap.put(c,countMap.getOrDefault(c,0)+1);
                }
            }
            int max =0;
            for(int freq : countMap.values()){
                if(freq>=2){
                    max = Math.max(freq,max);
                }
            }
            for(Map.Entry<String,Integer>entry : countMap.entrySet()){
                if(entry.getValue() == max){
                    answerList.add(entry.getKey());
                }
            }
        }
        Collections.sort(answerList);
        return answerList.stream().toArray(String[]::new);
    }
    void comb(int start, int target, String order, StringBuilder sb, List<String> combination){
        if(sb.length() == target){
            combination.add(sb.toString());
            return;
        }
        for(int i=start;i<order.length();i++){
            sb.append(order.charAt(i));
            comb(i+1,target,order,sb,combination);
            sb.deleteCharAt(sb.length()-1);
        }
    }
}
