package LeetCode.Recursion;



public class WiggleSubsquence {
    public static void main(String [] args){
        WiggleSubsquence ws = new WiggleSubsquence();
        int[] a = new int[]{1,7,4,9,2,5};
        var res=ws.wiggleMaxLength(a);
        System.out.println(res);

    }
    public int wiggleMaxLength(int[] nums) {
        if (nums.length<1) return 1;
         int inc = 1;
         int dec = 1;
        for(int i=1;i<nums.length;i++){
            if (nums[i]>nums[i-1])
                inc=dec+1;
            else if(nums[i]<nums[i-1])
                dec=inc+1;


         }
return Math.max(inc,dec);

    }
}
