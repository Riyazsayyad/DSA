package LeetCode;
import java.util.*;

public class ThreeSum {
    public static List<List<Integer>> threeSum(int[] nums) {

        Arrays.sort(nums);
        Set<List<Integer>> threeSum = new HashSet<>();

        for(int i = 0; i < nums.length - 2; i++){
            int j = i + 1;
            int k = nums.length - 1;
            while(j < k){
                int sum = nums[i] + nums[j] + nums[k];
                System.out.println(nums[i] +" "+ nums[j] +" "+ nums[k]);

                if(sum == 0){
                    List<Integer> temp = new ArrayList<>();
                    temp.add(nums[i]);
                    temp.add(nums[j]);
                    temp.add(nums[k]);
                    threeSum.add(temp);
                    j++;
                    k--;
                }else if(sum > 0){
                    k--;
                }else{
                    j++;
                }
            }
        }

        return new ArrayList<>(threeSum);
    }
    /* public List<List<Integer>> threeSum(int[] nums) {
        // Solution3: two pointer approach (sorting but without HashMap)
        List<List<Integer>> triplet = new ArrayList<>();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 2 && nums[i] <= 0; i++) { // if leftmost element is positive, there no way to get a triplet with sum = 0
            if (i > 0 && nums[i] == nums[i-1]) continue; // skip duplicates

            int left = i + 1;
            int right = nums.length - 1;
            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];
                if (sum == 0) {
                    triplet.add(Arrays.asList(nums[i], nums[left], nums[right]));
                    left++;
                    right--;
                    while (left < right && nums[left] == nums[left - 1]) left++; //skip duplicates
                    while (left < right && nums[right] == nums[right + 1]) right--; // skip duplicates
                } else if (sum < 0) {
                    left++;
                } else {
                    right--;
                }
            }
        }
        return triplet;*/
    /*  public static List<List<Integer>> threeSum(int[] nums) {
        int a = 0;
        int b = 1;
        int c = 2;
        int n = nums.length;

        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if(n==3)
            if(nums[0]+nums[1]+nums[2]==0){
                List<Integer> temp = new ArrayList<Integer>();
                temp.add(nums[0]);
                temp.add(nums[1]);
                temp.add(nums[2]);
                res.add(temp);
                return res;}
            else return res;

        // main code
        while (a<n-2){
            if(c>n-1) {
                a++;
                b = a + 1;
                c = a + 2;
            }
            if(b==(n-1)) return res;


            //if(c>n-1) {  c = 0;  a++; }
            System.out.println(a+" "+b+" "+c);

            if(nums[a]+nums[b]+nums[c]==0){
                List<Integer> temp = new ArrayList<Integer>();
                temp.add(nums[a]);
                temp.add(nums[b]);
                temp.add(nums[c]);
                c++;
                if(!res.contains(temp))
                    res.add(temp);
            }
            else{
                b=c;
                c++;
            }

        }


            return res;

    }
*/
    /*
    public static List<List<Integer>> threeSum(int[] nums) {
        //declaring 3 pointers which will traverse the array
        // a will be static until b,c completes one iteration
        int a = 0;
        int b = 1;
        int c = 2;
        int n = nums.length;
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        //handling the base condition
        if(n==3)
            if(nums[0]+nums[1]+nums[2]==0){
                List<Integer> temp = new ArrayList<Integer>();
                temp.add(nums[0]);
                temp.add(nums[1]);
                temp.add(nums[2]);
                res.add(temp);
                return res;}
        else return res;

        // main code
        while (a<n-1){
        if(b>n-1)   b = 0;
        if(c>n-1) {  c = 0;  a++; }
        System.out.println(a+" "+b+" "+c);

        if(nums[a]+nums[b]+nums[c]==0){
            List<Integer> temp = new ArrayList<Integer>();
            temp.add(nums[a]);
            temp.add(nums[b]);
            temp.add(nums[c]);
            //a++;
            if(!res.contains(temp))
                res.add(temp);
        }

        b++;
        c++;

        }

        return res;
        }

     */
        public static void main (String[] args){
        int [] nums = {-1,0,1,2,-1,-4};
        //[-2,0,1,1,2]
        System.out.println(threeSum(nums));
        }
        }
