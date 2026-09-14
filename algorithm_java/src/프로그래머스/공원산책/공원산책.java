package 프로그래머스.공원산책;

public class 공원산책 {
    public int[] solution(String[] park, String[] routes) {
        int n = park.length;
        int m = park[0].length();
        int sr = 0;
        int sc = 0;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(park[i].charAt(j) == 'S'){
                    sr = i;
                    sc = j;
                    break;
                }
            }
        }
        for(String r : routes){
            String way = r.split(" ")[0];
            int dist = Integer.parseInt(r.split(" ")[1]);
            boolean flag = true;
            if(way.equals("N")){
                for(int i=sr;i>=sr-dist;i--){
                    if(i<0|| park[i].charAt(sc)=='X'){
                        flag = false;
                        break;
                    }
                }
                if(flag){
                    sr -= dist;
                }
            }
            if(way.equals("W")){
                for(int i=sc;i>=sc-dist;i--){
                    if(i<0 || park[sr].charAt(i)=='X'){
                        flag = false;
                        break;
                    }
                }
                if(flag){
                    sc -= dist;
                }
            }
            if(way.equals("S")){
                for(int i=sr;i<=sr+dist;i++){
                    if(i>=n || park[i].charAt(sc)=='X'){
                        flag = false;
                        break;
                    }
                }
                if(flag){
                    sr += dist;
                }
            }
            if(way.equals("E")){
                for(int i=sc;i<=sc+dist;i++){
                    if(i>=m || park[sr].charAt(i)=='X'){
                        flag = false;
                        break;
                    }
                }
                if(flag){
                    sc += dist;
                }
            }
        }
        return new int[]{sr,sc};
    }
}
