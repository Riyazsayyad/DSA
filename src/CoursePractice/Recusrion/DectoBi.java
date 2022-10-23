package CoursePractice.Recusrion;

public class DectoBi {
    public static void main(String [] args){
    DectoBi db = new DectoBi();
    var res=db.decimalTobinary(13);
    System.out.println(res);

    }
    public int decimalTobinary(int n){
        if (n==0){
            return 0;
        }
        return n%2+10*decimalTobinary(n/2);
    }

}
