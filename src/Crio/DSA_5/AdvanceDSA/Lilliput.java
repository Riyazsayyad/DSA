package Crio.DSA_5.AdvanceDSA;
import java.util.*;

public class Lilliput {
    // Implement Your solution Here
    static int[] segmentTree;
    public static Vector<Integer> lilliput(int n, int heights[], int num_actions, String actions[]) {
        segmentTree = new int[4 * n];
        Vector<Integer> result = new Vector<>();
        buildSegmentTree(0,n-1,0,heights);
        for (String A : actions){
            String[] arr = A.split(" ");
            if(arr[0].equals("q")){
                int ans = query(0,0,n-1, Integer.parseInt(arr[1]), Integer.parseInt(arr[2]));
                result.add(ans);
            }
            else update(0,0,n-1,Integer.parseInt(arr[1]), Integer.parseInt(arr[2]));
        }

        return result;
    }

    private static void update(int index, int left, int right, int uInd, int value) {
        if (left == right) {
            segmentTree[index] = value;
            return;
        }
        int mid = (left + right) / 2;
        if (uInd <= mid) {
            update(2 * index + 1, left, mid, uInd, value);
        } else {
            update(2 * index + 2, mid + 1, right, uInd, value);
        }
        segmentTree[index] = Math.min(segmentTree[2 * index + 1], segmentTree[2 * index + 2]);
    }



    private static int query(int index, int left, int right, int l, int r) {
        if(right < l || left > r) return Integer.MAX_VALUE; // no overlap
        if(left >= l && right <= r) return segmentTree[index]; //complete overlap

        int mid = (left + right) / 2;
        int left_sum = query(2 * index + 1,left,mid,l,r);
        int right_sum = query(2 * index + 2,mid + 1,right,l,r);

        return Math.min(left_sum,right_sum);
    }

    private static void buildSegmentTree(int left, int right, int index,int[] heights) {
        if(left == right) {
            segmentTree[index] = heights[left];
            return;
        }

        int mid = (left + right) / 2;
        buildSegmentTree(left,mid,2 * index + 1,heights);
        buildSegmentTree(mid + 1,right,2 * index + 2,heights);

        segmentTree[index] = Math.min(segmentTree[2 * index + 1] , segmentTree[2 * index + 2]);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n, q;

        n = sc.nextInt();
        int heights[] = new int[n];
        for (int i = 0; i < n; i++) {
            heights[i] = sc.nextInt();
        }

        q = sc.nextInt(); // Num actions
        sc.nextLine();

        String actions[] = new String[q];
        for (int i = 0; i < q; i++) {
            actions[i] = sc.nextLine();
        }
        sc.close();

        Vector<Integer> answer = lilliput(n, heights, q, actions);
        for (int i = 0; i < answer.size(); i++)
            System.out.println(answer.get(i));
    }
}
