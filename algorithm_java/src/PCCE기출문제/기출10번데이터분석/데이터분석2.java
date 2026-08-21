package PCCE기출문제.기출10번데이터분석;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class 데이터분석2 {
    public int[][] solution(int[][] data, String ext, int val_ext, String sort_by) {
        List<int[]> tmp = new ArrayList<>();
        int extIdx = getIndex(ext);
        int sortIdx = getIndex(sort_by);
        for(int[]d : data){
            if(d[extIdx] < val_ext) tmp.add(d);
        }
        tmp.sort(Comparator.comparingInt(arr -> arr[sortIdx]));
        //tmp.sort((a,b) -> (a[sortIdx] - b[sortIdx]));
        return tmp.toArray(new int[tmp.size()][]);
    }
    public int getIndex(String name){
        switch(name){
            case "code" : return 0;
            case "date" : return 1;
            case "maximum" : return 2;
            case "remain" : return 3;
            default : return -1;
        }
    }
}
