package Crio.DSA_2.Binary_Search;
import java.util.*;
public class KthSmallestElementInMatrix {
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        List<ArrayList<Integer>>Matrix = new ArrayList<ArrayList<Integer>>();
        for (int i = 0; i < n; i++) {
            ArrayList<Integer>row = new ArrayList<>();
            for (int j = 0; j < n; j++) {
                row.add(sc.nextInt());
            }
            Matrix.add(row);
        }
        int ans = kthSmallestElementInMatrix(Matrix,k);
        System.out.print(ans);
    }

    static int upperBound(ArrayList<Integer> arr, int mid){
        int index = Collections.binarySearch(arr,mid);
        if(index < 0) index = -index-1;
        return index;
    }

    static int kthSmallestElementInMatrix(List<ArrayList<Integer>>Matrix, int k){
        int n = Matrix.size();
        int low = Matrix.get(0).get(0);
        int high = Matrix.get(n-1).get(n-1);

        while (low<=high){
            int mid =(low+high)/2;
            int count =0;

            for (ArrayList<Integer> matrix : Matrix) {
                count += upperBound(matrix,mid);
            }
            if(count<k) low=mid+1;
            else high=mid-1;

        }
        return --low;
    }
}
//    upperBound(matrix,mid)