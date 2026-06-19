package tree.problems;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Q1 {
    public String solution(String[][] folders, String p, String q) {
        Map<String, List<String>> tree = new HashMap<>();
        for(String[]arr : folders){
            String parent = arr[0];
            String child = arr[1];
            tree.putIfAbsent(parent, new ArrayList<>());
            tree.get(parent).add(child);
        }
        return dfs("root", p, q, tree);
    }

    String dfs(String node, String p, String q, Map<String, List<String>> tree) {
        if(node.equals(p) || node.equals(q)){
            return node;
        }
        List<String> children = tree.getOrDefault(node, new ArrayList<>());
        List<String> found = new ArrayList<>();
        for (String child : children) {
            String res = dfs(child, p, q, tree);
            if (res != null) {
                found.add(res);
            }
        }
        if(found.size() == 1){
            return found.get(0);
        }
        if(found.size() == 2){
            return node;
        }
        return null;
    }
}
