package 기본문제.감염된폴더;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class 감염된폴더dfs {
    public String solution(String[][] folders, String p, String q) {
        Map<String,List<String>> tree = new HashMap<>();
        for(String[]folder : folders){
            String parent = folder[0];
            String child = folder[1];
            tree.putIfAbsent(parent,new ArrayList<>());
            tree.get(parent).add(child);
        }
        return dfs("root",p,q,tree);
    }

    String dfs(String node, String p, String q, Map<String,List<String>> tree){
        if(node.equals(p) || node.equals(q)) return node;
        List<String> found = new ArrayList<>();

        for(String s : tree.get(node)){
            String res = dfs(s, p, q, tree);
            if(res!=null){
                found.add(res);
            }
        }
        if(found.size() == 2){
            return node;
        }
        if(found.size() == 1){
            return found.get(0);
        }
        return null;
    }
}
