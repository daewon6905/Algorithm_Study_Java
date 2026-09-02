package 프로그래머스.혼자서하는틱택토;

public class 혼자서하는틱택토 {
    public int solution(String[] board) {
        int countO = 0;
        int countX = 0;
        char[][]boardC = new char[3][3];
        for(int i=0;i<3;i++){
            boardC[i] = board[i].toCharArray();
            for(int j=0;j<3;j++){
                if(boardC[i][j] == 'O') countO++;
                if(boardC[i][j] == 'X') countX++;
            }
        }
        int total = countO + countX;
        if (countO != countX && countO != countX + 1) return 0;
        boolean oWin = checkWin('O', boardC);
        boolean xWin = checkWin('X', boardC);

        if(oWin && xWin) return 0;
        if(oWin && !xWin){
            if(countO != countX + 1) return 0;
        }
        if(!oWin && xWin){
            if(countX != countO) return 0;
        }
        return 1;
    }
    public boolean checkWin(char mark, char[][]board){
        for(int i=0;i<3;i++){
            if(board[i][0]==mark && board[i][1]==mark && board[i][2]==mark) return true;
            if(board[0][i]==mark && board[1][i]==mark && board[2][i]==mark) return true;
        }
        if(board[0][0]==mark && board[1][1]==mark && board[2][2]==mark) return true;
        if(board[0][2]==mark && board[1][1]==mark && board[2][0]==mark) return true;
        return false;
    }
}
