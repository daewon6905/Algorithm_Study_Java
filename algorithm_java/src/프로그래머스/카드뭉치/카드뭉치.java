package 프로그래머스.카드뭉치;

public class 카드뭉치 {
    public String solution(String[] cards1, String[] cards2, String[] goal) {
        int start1 = 0;
        int start2 = 0;
        for(String g : goal){
            if(start1<cards1.length && cards1[start1].equals(g)){
                start1++;
            }else if(start2<cards2.length && cards2[start2].equals(g)){
                start2++;
            }else{
                return "No";
            }
        }
        return "Yes";
    }
}
