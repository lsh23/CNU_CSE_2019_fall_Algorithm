public class Fibonacci {

    public static int fibonacci_recursive(int n){
        if(n == 0) return 1;
        if(n == 1) return 1;
        return fibonacci_recursive(n-1) + fibonacci_recursive(n-2);
    }

    public static int fibonacci_bottom_up(int n){
        return 0;
    }

    public static int fibonacci_recursive_squaring(int n){
        return 0;
    }
}
