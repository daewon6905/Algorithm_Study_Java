package 프로그래머스.캐시;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashSet;
import java.util.Set;

public class 캐시 {
    public int solution(int cacheSize, String[] cities) {
        if(cacheSize == 0) return 5*cities.length;
        Deque<String> cache = new ArrayDeque<>();
        Set<String> cacheSet = new HashSet<>();
        int time =0;
        for(String city : cities){
            String s = city.toLowerCase();
            if(cacheSet.contains(s)){
                time+=1;
                cache.remove(s);
                cache.addFirst(s);
            }else{
                if(cache.size() == cacheSize){
                    String lru = cache.pollLast();
                    cacheSet.remove(lru);
                }
                time+=5;
                cacheSet.add(s);
                cache.addFirst(s);
            }
        }
        return time;
    }
}
