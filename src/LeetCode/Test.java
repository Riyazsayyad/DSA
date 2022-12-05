package LeetCode;

public class Test {
    public static void main(String [] args){
        Test t = new Test() ;
        var res = t.testKarlo(2,2);
        System.out.println(res);
    }
    public int testKarlo(int base,int exponent){
            if (exponent==0) return 1;
            if (exponent==1)
                return base;
            return base * testKarlo(base,exponent-1) ;
    }
}
