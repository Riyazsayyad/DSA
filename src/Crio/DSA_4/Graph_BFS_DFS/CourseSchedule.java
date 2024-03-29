package Crio.DSA_4.Graph_BFS_DFS;
import java.util.*;
class CourseSchedule {
    static ArrayList<ArrayList<Integer>> adj;
    static boolean[] visited;
    static boolean[] traversed;
    public static boolean courseSchedule(int numCourses, int[][] prerequisites) {
        adj = new ArrayList<>();
        for (int i = 0; i <= numCourses; i++) {
            adj.add(new ArrayList<>());
        }
        visited = new boolean [numCourses+1];
        traversed = new boolean [numCourses+1];

        for (int[] A : prerequisites){
            int x = A[0];
            int y = A[1];
            adj.get(y).add(x);
        }

        for (int i = 1; i <= numCourses; i++) {
            if(!visited[i]){
                if (isCyclic(i,visited,traversed))  return false;
            }
        }
        return true;
    }

    private static boolean isCyclic(int curr,boolean[] visited,boolean[] callStack) {
        visited[curr] = true;
        callStack[curr] = true;
        if(adj.get(curr).size() > 0){
            for (int i = 0; i < adj.get(curr).size(); i++) {
                int u = adj.get(curr).get(i);
                if(!visited[u]){
                    if(isCyclic(u,visited,callStack)) return true;
                }
                else if(callStack[u]) return true;
            }
        }
        callStack[curr] = false;
        return false;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int [][] edgeList = new int[m][2];
        for(int i=0;i<m;i++)
        {
            edgeList[i][0] = sc.nextInt();
            edgeList[i][1] = sc.nextInt();
        }
        boolean ans=courseSchedule(n,edgeList);
        if(ans)
            System.out.println("true");
        else
            System.out.println("false");
    }
}
