package 프로그래머스.개인정보수집유효기간;

import java.util.*;

public class 개인정보수집유효기간 {

    public int[] solution(String today, String[] terms, String[] privacies) {
        Map<String,Integer> termsMap = new HashMap<>();
        for(String t : terms){
            String[]arr = t.split(" ");
            termsMap.put(arr[0],Integer.parseInt(arr[1]));
        }
        List<Integer> answerList = new ArrayList<>();
        int todayToDay = dateToDays(today);
        for(int i=0;i<privacies.length;i++){
            String date = privacies[i].split(" ")[0];
            String term = privacies[i].split(" ")[1];
            int validMonths = termsMap.get(term);
            if(todayToDay >= dateToDays(date) + validMonths*28){
                answerList.add(i+1);
            }
        }
//        Collections.sort(answerList); i 0부터 순서대로 진행하기에 정렬이 필요 없음
        return answerList.stream().mapToInt(Integer::intValue).toArray();
    }

    int dateToDays(String date){
        String[]arr = date.split("\\.");
        int year = Integer.parseInt(arr[0]);
        int month = Integer.parseInt(arr[1]);
        int day = Integer.parseInt(arr[2]);
        return (28*12*(year)) + (28*(month)) + day;
    }
}
