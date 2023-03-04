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


    static int[] watchMe(int numSeasons,int n, int[][] pre){
        Map<Integer,ArrayList<Integer>> Graph = new HashMap<>();
        for (int i = 0; i < numSeasons; i++) {
            Graph.put(i,new ArrayList<>());
        }

        int[] inDegree = new int[numSeasons];
        for(int[] A: pre){
            Graph.get(A[1]).add(A[0]);
            inDegree[A[0]]++;
        }

        Queue<Integer> independentSeasons = new LinkedList<>();
        for (int i = 0; i < numSeasons; i++) {
            if (inDegree[i] == 0) independentSeasons.offer(i);
        }


        ArrayList<Integer> result = new ArrayList<>();
        while (!independentSeasons.isEmpty()){
            int curr = independentSeasons.poll();
            result.add(curr);
            for (int next : Graph.get(curr)){
                inDegree[next]--;
                if(inDegree[next] == 0) independentSeasons.add(next);
            }
        }

        if(result.size() != numSeasons) return new int[]{};
        else{
            int[] resArr = new int[numSeasons];
            for (int i = 0; i < numSeasons; i++) {
                resArr[i] = result.get(i);
            }
            return resArr;
        }
    }

    /*
            List<Integer>[] graph = new List[numSeasons];
        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }
        int[] inDegree = new int[numSeasons];
        for (int[] prereq : pre) {
            int a = prereq[0];
            int b = prereq[1];
            graph[b].add(a);
            inDegree[a]++;
        }
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < numSeasons; i++) {
            if (inDegree[i] == 0) {
                queue.add(i);
            }
        }
        List<Integer> result = new ArrayList<>();
        while (!queue.isEmpty()) {
            int curr = queue.poll();
            result.add(curr);
            for (int next : graph[curr]) {
                inDegree[next]--;
                if (inDegree[next] == 0) {
                    queue.add(next);
                }
            }
        }
        if (result.size() == numSeasons) {
            int[] resArr = new int[numSeasons];
            for (int i = 0; i < n; i++) {
                resArr[i] = result.get(i);
            }
            return resArr;
        } else {
            return new int[0];
        }
     */
}
