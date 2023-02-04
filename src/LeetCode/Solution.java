package LeetCode;
import java.util.*;

class Solution {
    public static int[][] insert(int[][] A, int[] N) {
        ArrayList<int []> result = new ArrayList<>();

        int index = 0,n = A.length;

        while (index < n && A[index][1] < N[0]){
            result.add(A[index++]);
        }

        while (index < n && A[index][0] <= N[1]){
            int [] temp = A[index++];

            N[0] = Math.min(temp[0],N[0]);
            N[1] = Math.max(temp[1],N[1]);
        }
        result.add(N);

        while (index < n) result.add(A[index++]);

        return result.toArray(new int[result.size()][]);
    }

    public static void main(String[] args) {

        System.out.println(convert("PAYPALISHIRING",4));;
    }

    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<int[]> Q = new PriorityQueue<>(
                
                (a,b) -> (int) Math.sqrt((b[0]*b[0]) + (b[1]*b[1])) -
                         (int) Math.sqrt((a[0]*a[0]) + (a[1]*a[1]))
        );

        for (int[] arr : points){
            if(Q.size() < k){
                Q.offer(arr);
            }else{
                int I = (int) Math.sqrt(Math.pow(arr[0],2) + Math.pow(arr[1],2)); //current
                int T = (int) Math.sqrt(Math.pow(Q.peek()[0],2) + Math.pow(Q.peek()[1],2)); //present
                if(I < T){
                    Q.poll();
                    Q.offer(arr);
                }
            }

        }
        int[][] result = new int[k][2];
        int i=0;
        while(!Q.isEmpty()) result[i++] = Q.poll();
        return result;
    }

    public static String convert(String s, int numRows) {
        char [][] A = new char[9][9];
        int i = 0,sLength = s.length(),n = numRows;
        int row = 0,col = 0;

        while(i < sLength){
            //traverse column
            while (--n != 0 && i < sLength){
                A[row++][col] = s.charAt(i++);
            }
            n = numRows;

            //traverse diagonal
            while (--n != 0 && i < sLength){
                A[row--][col++] = s.charAt(i++);
            }
            n = numRows;
        }

        StringBuilder result = new StringBuilder();

        for(char [] arr: A){
            for(char ltr : arr){
                if(ltr != '\u0000'){
                    result.append(ltr);
                }
            }
        }

        return result.toString();
    }
}

