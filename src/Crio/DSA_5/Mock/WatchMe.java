package Crio.DSA_5.Mock;
import java.util.*;


class WatchMe{
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int numSeasons=sc.nextInt();
        int n =sc.nextInt();
        int[][] pre=new int[n][2];
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<2;j++)
            {
                pre[i][j]=sc.nextInt();
            }
        }

        int[] nums=watchMe(numSeasons,n,pre);
        for(int i=0;i<nums.length;i++)
        {
            System.out.print(nums[i]+" ");
        }
    }

    static ArrayList<ArrayList<Integer>> Graph;
    static int[] result;
    static Set<Integer> visited;
    static int[] watchMe(int numSeasons,int n, int[][] pre){
        result = new int[numSeasons];
        visited = new HashSet<>();
        Graph = new ArrayList<>();

        for (int i = 0; i <= n; i++) {
            Graph.add(new ArrayList<>());
        }
        for (int[] A : pre){
            Graph.get(A[1]).add(A[0]);
        }
        dfs(0);
        return result;
    }

    private static void dfs(int curr) {
        if(visited.contains(curr)) return;
        visited.add(curr);
        result[curr] = (curr);
        for (int x : Graph.get(curr)){
            dfs(x);
        }
    }
}
