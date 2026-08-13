package PCCP기출문제.기출3번충돌위험찾기;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class 충돌위험찾기 {
    public int solution(int[][] points, int[][] routes) {
        List<List<int[]>>node = new ArrayList<>();
        int max_time = 1000000; // r,c <=100 routes 길이 최대 100
        for(int i=0;i<=max_time;i++){
            List<int[]>list = new ArrayList<>();
            list.add(new int[]{0,0});
            node.add(list);
        }
        for(int[]robot : routes){
            int time = 0;
            for(int i=0;i<robot.length-1;i++){
                int r = points[robot[i]-1][0];
                int c = points[robot[i]-1][1];
                if(i==0){
                    int[]now = new int[]{r,c};
                    node.get(time++).add(now);
                }
                int next_r = points[robot[i+1]-1][0];
                int next_c = points[robot[i+1]-1][1];

                if(next_r < r){
                    int size = r - next_r;
                    for(int j=0;j<size;j++){
                        int[]rc = new int[]{--r,c};
                        node.get(time++).add(rc);
                    }

                }
                if(next_r > r){
                    int size =  next_r - r;
                    for(int j=0;j<size;j++){
                        int[]rc = new int[]{++r,c};
                        node.get(time++).add(rc);
                    }
                }
                if(next_c < c){
                    int size = c - next_c;
                    for(int j=0;j<size;j++){
                        int[]rc = new int[]{r,--c};
                        node.get(time++).add(rc);
                    }
                }
                if(next_c > c){
                    int size = next_c - c;
                    for(int j=0;j<size;j++){
                        int[]rc = new int[]{r,++c};
                        node.get(time++).add(rc);
                    }
                }
            }
        }
        int collision = 0;
        for(List<int[]> list : node){
            Map<String,Integer> count = new HashMap<>();
            for(int[]arr : list){
                String key = arr[0] + "," + arr[1];
                count.put(key, count.getOrDefault(key,0) + 1);
            }
            for(Integer value : count.values()){
                if(value != 1) collision++;
            }
        }
        return collision;
    }
}
