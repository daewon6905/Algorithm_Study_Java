package 프로그래머스.숫자카드나누기;

public class 숫자카드나누기 {
    public int solution(int[] arrayA, int[] arrayB) {
        int gcdA = gcdArray(arrayA);
        int gcdB = gcdArray(arrayB);
        int candidateA;
        int candidateB;

        candidateA = check(gcdA, arrayB) ? gcdA : 0;
        candidateB = check(gcdB, arrayA) ? gcdB : 0;

        return Math.max(candidateA, candidateB);
    }

    public boolean check(int gcd, int[]arr){
        for(int n : arr){
            if(n % gcd == 0) return false;
        }
        return true;
    }

    public int gcd(int a, int b){
        while(b != 0){
            int r = a % b;
            a = b;
            b = r;
        }
        return a;
    }

    public int gcdArray(int[]arr){
        int result = arr[0];
        for(int i=1;i<arr.length;i++){
            result = gcd(result, arr[i]);
            if(result == 1){
                return 1;
            }
        }
        return result;
    }
}
