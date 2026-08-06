package 카카오.카카오2025하반기1차.중요한단어를스포방지;
import java.util.*;

class WordInfo{
    String word;
    int startIndex;

    public WordInfo(String word, int startIndex){
        this.word = word;
        this.startIndex = startIndex;
    }
}
public class 중요한단어를스포방지 {
    public int solution(String message, int[][] spoiler_ranges) {
        String[]words = message.split(" ");
        Map<String, List<WordInfo>>map = new HashMap<>();
        int idx = 0;
        int count = 0;
        for(int i=0;i<words.length;i++){
            if(!map.containsKey(words[i])) map.put(words[i], new ArrayList<>());
        }
        for(String w : words){
            int len = w.length();
            WordInfo wi = new WordInfo(w, idx);
            map.get(w).add(wi);
            idx += len+1;
        }
        for(String key : map.keySet()){
            boolean flag = true;
            for(WordInfo wi : map.get(key)){
                if(!isInRange(spoiler_ranges, wi)){
                    flag = false;
                    break;
                }
            }
            if(flag) count++;
        }
        return count;
    }
    public boolean isInRange(int[][]spoiler_ranges, WordInfo wi){
        int wordStartIndex = wi.startIndex;
        int wordEndIndex = wordStartIndex + wi.word.length() -1;
        for(int[]range : spoiler_ranges){
            int start = range[0];
            int end = range[1];
            if(start<=wordEndIndex && end>=wordStartIndex) return true;
        }
        return false;
    }
}
