package 프로그래머스.캐시;

import java.util.LinkedHashMap;

public class 캐시2 {
    public int solution(int cacheSize, String[] cities) {
        int n = cities.length;
        if(cacheSize == 0) return 5*n;
        int time = 0;
        LinkedHashMap<String,Boolean>cache = new LinkedHashMap<>(cacheSize,0.75f,true);

        for(String city : cities){
            String s = city.toLowerCase();
            if(cache.containsKey(s)){
                time+=1;
                cache.get(s);
            }else{
                if(cache.size() == cacheSize){
                    String lru = cache.entrySet().iterator().next().getKey();
                    cache.remove(lru);
                }
                time+=5;
                cache.put(s,true);
            }
        }
        return time;
    }
}
