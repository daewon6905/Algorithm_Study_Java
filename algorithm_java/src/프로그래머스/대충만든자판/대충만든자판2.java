package 프로그래머스.대충만든자판;

import java.util.Arrays;

public class 대충만든자판2 {
    public int[] solution(String[] keymap, String[] targets) {
        int n = targets.length;
        int[] answer = new int[n];
        int[]globalMin = new int[26];
        Arrays.fill(globalMin, Integer.MAX_VALUE);

        for(int i=0;i<keymap.length;i++){
            char[]arr = keymap[i].toCharArray();
            for(int j=0;j<arr.length;j++){
                globalMin[arr[j]-'A'] = Math.min(globalMin[arr[j]-'A'], j+1);
            }
        }

        for(int i=0;i<targets.length;i++){
            for(char c : targets[i].toCharArray()){
                if(globalMin[c-'A'] == Integer.MAX_VALUE){
                    answer[i] = -1;
                    break;
                }
                answer[i] += globalMin[c-'A'];
            }
        }
        return answer;
    }
}
