package Crio.DSA_2;
import java.io.*;
import java.util.*;
public class ContainerWithMostWater {
    // Complete the function implementation below
    public int maxArea(int[] height) {
        int n = height.length;
        int i = 0;
        int j = n-1;
        int answer = 0;
        while(i<j){
            int length = Math.min(height[i],height[j]);
            int width = j-i;

            if(height[i]<height[j]){
                answer=Math.max(answer,(length*width));
                while(height[i]<=length && i<j) i++;
            }
            else{
                answer=Math.max(answer,(length*width));
                while(height[j]<=length && i<j) j--;
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int height[] = new int[n];
        for(int i = 0 ; i < n ; i++) {
            height[i] = scanner.nextInt();
        }
        scanner.close();
        int result = new ContainerWithMostWater().maxArea(height);
        System.out.println(result);
    }
}
