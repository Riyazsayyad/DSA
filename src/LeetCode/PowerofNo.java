package LeetCode;

public class PowerofNo {
    public static void main(String [] args){
    PowerofNo po = new PowerofNo();
    var res=po.powerMul(10,5);
    System.out.println(res);
    }
    public int powerMul(int base,int expo){
        if (expo<0){
            return -1;
        }
        if (expo==1||expo==0){
            return 1;
        }
        return base*powerMul(base,expo-1);
    }

}
