package Crio.DSA_2;
import java.util.*;
public class NextGreaterElementWithSameSetOfDigits {
    public static void main(String[] args) {
        int n = 534976;
        System.out.print(nextGreaterElementWithSameSetOfDigits(n));
    }

    static void swap(char arr[], int i, int j) {
        char temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    static int nextGreaterElementWithSameSetOfDigits(int n) {
        char[] arr = Integer.toString(n).toCharArray();
        int i;

        for (i = arr.length - 1; i > 0; i--) {
            if (arr[i] > arr[i - 1]) break;
        }
        //534976
        if (i == 0) return -1;
        else {
            int x = arr[i - 1], min = i;
            System.out.println(x+" "+min);
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] > x && arr[j] < arr[min]) min = j;
            }
            swap(arr, i - 1, min);
            Arrays.sort(arr, i, arr.length);
        }
        return Integer.parseInt(String.valueOf(arr));
    }
}







        //I HATE MYSELF FOR WRITING THIS
        //        ArrayList<Integer> sack = new ArrayList<>();
//        boolean descend = true, ascend = true;
//        int ans = 0, dec = 1, z = 0;
//        int min = Integer.MAX_VALUE, prevI = 0, curI = 0;
//        while (n != 0) {
//            sack.add(0, n % 10);
//            n = n / 10;
//        }
//
//        // to check if the digits are in placed in ascend manner
//        for (int a = 1; a < sack.size(); a++) {
//            if (sack.get(a - 1) > sack.get(a)) {
//                ascend = false;
//                break;
//            }
//        }
//
//        //if digits in ascend manner just swap last two digits
//        if (ascend) {
//            Collections.swap(sack, sack.size() - 1, sack.size() - 2);
//            dec = sack.size() - 1;
//            for (int j = 0; j < sack.size(); j++, dec--) ans += sack.get(j) * Math.pow(10, dec);
//        } else {
//            //if digits in descending manner return -1 as its not possible
//            for (int i = 1; i < sack.size(); i++) {
//                if (sack.get(i - 1) < sack.get(i)) {
//                    descend = false;
//                    break;
//                }
//            }
//            if (descend) return -1;
//            else {
//                //if the digits are not in ascend or  descend manner we'll look for
//                //the point where descend end (i.e, 534976 '4' is the point) and then look for digit closer to it
//                //then sort the array after that point
//                // 534976
//                // 536723123
//                for (int i = sack.size()-1; i > 0; i--) {
//                    if (sack.get(i - 1) < sack.get(i)) { // if break point found
//                        prevI = i;
//                        curI = i-1;
//                        while (curI+1  < sack.size()) {  //while loop to get closest and less number
//                            if (min > sack.get(curI+1) && min > sack.get(prevI-1)) {
//                                min = sack.get(curI+1);
//                            }curI++;
//                        }
//                            Collections.swap(sack,prevI,curI);
//                            int[] sack1 = new int[sack.size()];
//                            for (int j = 0; j < sack.size(); j++) sack1[j] = sack.get(j);
//                            System.out.println(prevI+" "+curI);
//                            Arrays.sort(sack1,++prevI,sack1.length);
//                            dec = sack1.length-1;
//                            for (int j = 0; j < sack1.length; j++,dec--)    ans+=sack1[j]*Math.pow(10,dec);
//                        }
//                    }
//                }
//            }
//        return ans;




//            for (int i = 1; i < sack.size(); i++) {
//                if(sack.get(i-1) < sack.get(i)){ // if the digits are not in ascend or  descend manner we'll look4 for descend break point
//                    prevI = i;
//                    flag = false;
//                while (i+1 < sack.size()){  //while loop to get closest and less number
//                    if(min > sack.get(i+1) && min > sack.get(prevI)) {
//                        min = sack.get(i+1) ;
//                        curI = i+1;
//                    }i++;
//                }
//                Collections.swap(sack,prevI,curI);
//                int[] sack1 = new int[sack.size()];
//                for (int j = 0; j < sack.size(); j++) sack1[j] = sack.get(j);
//                Arrays.sort(sack1,++prevI,sack1.length);
//                dec = sack1.length-1;
//                for (int j = 0; j < sack1.length; j++,dec--)    ans+=sack1[j]*Math.pow(10,dec);
//            }else continue;
//        }




