package LeetCode;

public class SumofDigits {
    public static void main(String [] args){
        SumofDigits sod = new SumofDigits();
        var res = sod.sumDigit(101);
        System.out.println(res);
    }
    public int sumDigit(int n){
        if(n==0 || n<0)
            return 0;
        return n%10+sumDigit(n/10);
    }
}
