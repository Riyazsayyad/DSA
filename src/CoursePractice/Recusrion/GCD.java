package CoursePractice.Recusrion;

public class GCD {
    public static void main(String [] args){
    GCD gc = new GCD();
    var res=gc.gcd(8,4);
    System.out.println(res);
    }
    public int gcd(int a,int b){
        if(a<0||b<0){
            return -1;
        }
        if (b==0){
            return a;
        }
        return gcd(b,a%b);
    }

}
