package 프로그래머스.행렬과연산;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Iterator;

public class 행렬과연산 {
    Deque<Integer>left = new ArrayDeque<>();
    Deque<Integer>right = new ArrayDeque<>();
    Deque<Deque<Integer>>mid = new ArrayDeque<>();
    int n,m;
    public int[][] solution(int[][] rc, String[] operations) {
        n = rc.length;
        m = rc[0].length;
        for(int i=0;i<n;i++){
            left.add(rc[i][0]);
            right.add(rc[i][m-1]);
            Deque<Integer>tmp = new ArrayDeque<>();
            for(int j=1;j<m-1;j++){
                tmp.add(rc[i][j]);
            }
            mid.add(tmp);
        }

        for(String s : operations){
            if(s.equals("ShiftRow")){
                shiftRow();
            }
            if(s.equals("Rotate")){
                rotate();
            }
        }
        applyToBoard(rc);
        return rc;

    }
    void applyToBoard(int[][]rc){
        Iterator<Integer> itL = left.iterator();
        Iterator<Integer>itR = right.iterator();
        Iterator<Deque<Integer>>itM = mid.iterator();
        for(int i=0;i<n;i++){
            rc[i][0] = itL.next();
            rc[i][m-1] = itR.next();
            Deque<Integer>cur = itM.next();
            int j=1;
            for(int num : cur){
                rc[i][j++] = num;
            }
        }
    }

    void shiftRow(){
        left.addFirst(left.pollLast());
        right.addFirst(right.pollLast());
        mid.addFirst(mid.pollLast());
    }

    void rotate(){
        Deque<Integer> top = mid.peekFirst();
        Deque<Integer>bottom = mid.peekLast();
        top.addFirst(left.pollFirst());
        right.addFirst(top.pollLast());
        bottom.addLast(right.pollLast());
        left.addLast(bottom.pollFirst());
    }
}
