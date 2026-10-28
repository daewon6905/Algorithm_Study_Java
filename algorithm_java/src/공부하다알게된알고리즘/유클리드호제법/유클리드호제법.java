package 공부하다알게된알고리즘.유클리드호제법;

public class 유클리드호제법 {

    //최대공약수
    public int gcd(int a, int b) {
        while (b != 0) {
            int r = a % b;
            a = b;
            b = r;
        }
        return a;
    }

    //최대공약수 재귀
    public int gcdRecursive(int a, int b) {
        if(b == 0) return a;
        return gcdRecursive(b, a % b);
    }

    //최소공배수
    public int lcm(int a, int b){
        return (a * b) / gcd(a, b);
    }
}
