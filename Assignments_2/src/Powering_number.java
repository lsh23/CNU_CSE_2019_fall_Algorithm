public class Powering_number {
    public static double power(double a, int n){
        if(n==1) return a;
        double tmp = power(a,n/2);
        if(n%2==0){
            // 짝수
            return tmp*tmp;
        }
        else{
            // 홀수
            return a*tmp*tmp;
        }
    }
}
