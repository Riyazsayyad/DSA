package LeetCode;

public class PowerOfTwo {
    public static void main(String[] args) {
        PowerOfTwo pot = new PowerOfTwo();
        var res = pot.isPowerOfTwo(16);
        System.out.println(res);
    }

    public boolean isPowerOfTwo(int n) {
        if (n%2==0 || n==1) {
            if (n == 1) {
                return true;
            } else if (n < 1) {
                return false;
            } else
                return isPowerOfTwo(n / 2);
        }
        return false;
    }
}