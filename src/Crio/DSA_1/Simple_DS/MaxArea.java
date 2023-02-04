package Crio.DSA_1.Simple_DS;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class MaxArea {
    public static void main(String[] args){
        int[] height={1,8,6,2,5,4,8,3,7};
        //{1,8,6,2,5,4,8,3,7}
        //{2,3,4,5,18,17,6}
        System.out.println(maxArea(height));
    }
    public static int  maxArea(int[] height) {
        int n = height.length;
        int left= 0;
        int right = n-1;
        int max=0;
        while (right>left){
            int h = right-left;
            int w = Math.min(height[right],height[left]);
            int area = h*w;
            max = Math.max(area,max);
            if(height[left]>height[right]) right--;
            else if(height[left]<height[right]) left++;
            else
                {
                right-- ;
                left++;
                }
        }
        return max;
    }
}

