package tree.problems;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Q2 {
    public String solution(String[][]folders, String p, String q){
        Map<String, String> parentMap = new HashMap<>();
        for (String[] arr : folders) {
            String parent = arr[0];
            String child = arr[1];
            parentMap.put(child, parent);
        }
        Set<String> ancesterP = new HashSet<>();
        while (p != null) {
            ancesterP.add(p);
            p = parentMap.get(p);
        }

        while (q != null) {
            if (ancesterP.contains(q)) {
                return q;
            }
            q = parentMap.get(q);
        }
        return "root"; //끝까지 없으면 가장 루트에 있는 노드 리턴
    }
}
