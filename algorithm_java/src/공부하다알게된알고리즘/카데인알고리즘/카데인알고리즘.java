package 공부하다알게된알고리즘.카데인알고리즘;

public class 카데인알고리즘 {
    public int kadane(int[]arr){
        int global_max = arr[0];
        int current_max = arr[0];
        for(int i=1;i<arr.length;i++){
            current_max = Math.max(arr[i], current_max + arr[i]);
            global_max = Math.max(global_max, current_max);
        }
        return global_max;
    }
}
