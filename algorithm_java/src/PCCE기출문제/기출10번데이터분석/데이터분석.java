package PCCE기출문제.기출10번데이터분석;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class 데이터분석 {
    public int[][] solution(int[][] data, String ext, int val_ext, String sort_by) {
        List<int[]>tmp = new ArrayList<>();
        filter(ext, val_ext, tmp, data);
        sortBy(sort_by, tmp);
        int n = tmp.size();
        int[][] answer = new int[n][4];
        for(int i=0;i<tmp.size();i++){
            answer[i] = tmp.get(i);
        }
        return answer;
    }

    public void sortBy(String sort_by, List<int[]> tmp){
        if(sort_by.equals("code")){
            tmp.sort(Comparator.comparingInt(arr -> arr[0]));
        }
        if(sort_by.equals("date")){
            tmp.sort(Comparator.comparingInt(arr -> arr[1]));
        }
        if(sort_by.equals("maximum")){
            tmp.sort(Comparator.comparingInt(arr -> arr[2]));
        }
        if(sort_by.equals("remain")){
            tmp.sort(Comparator.comparingInt(arr -> arr[3]));
        }
    }

    public void filter(String ext, int val_ext, List<int[]>tmp, int[][]data){
        if(ext.equals("code")){
            for(int[]d : data){
                if(d[0] < val_ext) tmp.add(d);
            }
        }
        if(ext.equals("date")){
            for(int[]d : data){
                if(d[1] < val_ext) tmp.add(d);
            }
        }
        if(ext.equals("maximum")){
            for(int[]d : data){
                if(d[2] < val_ext) tmp.add(d);
            }
        }
        if(ext.equals("remain")){
            for(int[]d : data){
                if(d[3] < val_ext) tmp.add(d);
            }
        }
    }
}
