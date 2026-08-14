package PCCE기출문제.기출9번이웃한칸;

public class 이웃한칸 {
    int[]dr = new int[]{0,1,-1,0};
    int[]dc = new int[]{1,0,0,-1};
    int n;
    public int solution(String[][] board, int h, int w) {
        int answer = 0;
        this.n = board.length;
        String color = board[h][w];
        for(int i=0;i<4;i++){
            int nr = h + dr[i];
            int nc = w + dc[i];
            if(nr>=0&&nr<n&&nc>=0&&nc<n){
                if(board[nr][nc].equals(color)) answer++;
            }
        }
        return answer;
    }
}
