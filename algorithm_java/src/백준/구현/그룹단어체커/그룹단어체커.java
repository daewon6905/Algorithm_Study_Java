package 백준.구현.그룹단어체커;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 그룹단어체커 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int answer = 0;
        List<String> words = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            words.add(br.readLine());
        }

        for (String word : words) {
            Map<Character, Integer> map = new HashMap<>();
            boolean flag = true;
            for (int i = 0; i < word.length(); i++) {
                char c = word.charAt(i);
                if(map.containsKey(c)){
                    if(i - map.get(c) != 1){
                        flag = false;
                        break;
                    }else{
                        map.put(c, i);
                    }
                }else{
                    map.put(c, i);
                }
            }
            if (flag) answer++;
        }
        System.out.println(answer);
    }
}
