package 프로그래머스.바탕화면정리;

public class 바탕화면정리2 {
    public int[] solution(String[] wallpaper) {
        int minR = Integer.MAX_VALUE;
        int minC = Integer.MAX_VALUE;
        int maxR = Integer.MIN_VALUE;
        int maxC = Integer.MIN_VALUE;

        int n = wallpaper.length;
        int m = wallpaper[0].length();
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(wallpaper[i].charAt(j) == '#'){
                    minR = Math.min(minR, i);
                    minC = Math.min(minC, j);
                    maxR = Math.max(maxR, i);
                    maxC = Math.max(maxC, j);
                }
            }
        }
        return new int[]{minR,minC,maxR+1,maxC+1};
    }
}
