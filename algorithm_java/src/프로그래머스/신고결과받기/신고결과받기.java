package 프로그래머스.신고결과받기;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class 신고결과받기 {
    public int[] solution(String[] id_list, String[] report, int k) {
        Map<String, Set<String>>reportLog = new HashMap<>();
        Map<String, Integer> reportCount = new HashMap<>();
        Set<String>banned = new HashSet<>();
        int n = id_list.length;

        for(String id : id_list){
            reportLog.put(id, new HashSet<>());
            reportCount.put(id, 0);
        }
        for(String r : report){
            String[]split = r.split(" ");
            String reporter = split[0];
            String reported = split[1];
            if(!reportLog.get(reporter).contains(reported)){
                reportCount.put(reported, reportCount.getOrDefault(reported,0)+1);
            }
            if(reportCount.get(reported) >= k) banned.add(reported);
            reportLog.get(reporter).add(reported);
        }
        int[]answer = new int[n];
        for(int i=0;i<n;i++){
            Set<String>cur = reportLog.get(id_list[i]);
            for(String s : cur){
                if(banned.contains(s)) answer[i]++;
            }
        }
        return answer;
    }
}
