package leetcode.PermutationSequence;

public class PermutationSequence1 {
    int count =0;
    String answer;
    public String getPermutation(int n, int k) {
        boolean[]visited = new boolean[n];
        permutation(k,n,new StringBuilder(),visited);
        return answer;
    }
    void permutation(int k, int n, StringBuilder sb, boolean[]visited){
        if(sb.length() == n){
            count++;
            if(count == k){
                answer = sb.toString();
            }
            return;
        }
        for(int i=0;i<n;i++){
            if(!visited[i]){
                visited[i] = true;
                sb.append(i+1);
                permutation(k,n,sb,visited);
                visited[i] = false;
                sb.deleteCharAt(sb.length()-1);
            }
        }
    }
}
