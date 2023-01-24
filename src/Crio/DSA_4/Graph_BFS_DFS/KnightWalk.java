package Crio.DSA_4.Graph_BFS_DFS;
import java.util.*;

class KnightWalk{


    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int n;
        n=sc.nextInt();
        int starting_pos[]=new int[2];
        int ending_pos[]=new int[2];
        starting_pos[0]=sc.nextInt();
        starting_pos[1]=sc.nextInt();
        ending_pos[0]=sc.nextInt();
        ending_pos[1]=sc.nextInt();
        System.out.println(knightWalk(starting_pos,ending_pos,n));

    }

    static boolean[][] visited;
    static int knightWalk(int starting_pos[], int ending_pos[], int n)
    {
        int x1 = starting_pos[0],y1 = starting_pos[1];
        int x2 = ending_pos[0], y2 = ending_pos[1];
        if(x1 == x2 && y1 == y2) return 0;
        visited = new boolean[n+1][n+1];
        visited[x1][y1] = true;
        Queue<DistPairs> Q = new LinkedList<>();
        Q.offer(new DistPairs(x1,y1));
        /*
        (r+2, c+1), (r+2, c-1), (r-2, c+1), (r-2, c-1), (r+1, c+2), (r+1, c-2), (r-1, c+2), (r-1, c-2)
        took below array from above combination of possible steps by knight
         */
        int[] X = {2,2,-2,-2,1,-1,1,-1};
        int[] Y = {1,-1,1,-1,2,2,-2,-2};
        int ans = 0;

        while (!Q.isEmpty()){
            ans++;
            int size = Q.size();
            while (size-- != 0){
                DistPairs obj = Q.poll();
                x1 = obj.row; y1 = obj.col;
                for (int i = 0; i < 8; i++) {
                    int nx = x1 + X[i],ny = y1 + Y[i];
                    if(nx == x2 && ny == y2) return ans;
                    if(isValidate(nx,ny,n)){
                        visited[nx][ny] = true;
                        Q.offer(new DistPairs(nx,ny));
                    }
                }
            }

        }
        return -1;
    }

    private static boolean isValidate(int nx, int ny,int n) {
        return  nx > -1 && nx < n && ny > -1 && ny < n && !visited[nx][ny];
    }

    private static class DistPairs{
        int row,col;
        private DistPairs(int row,int col){
            this.row = row;
            this.col = col;
        }
    }
}









/**
 * Eucledian Distance Attempt
 public static void main(String[] args){
 Scanner sc = new Scanner(System.in);
 int n;
 n=sc.nextInt();
 int[] starting_pos =new int[2];
 int[] ending_pos =new int[2];
 starting_pos[0]=sc.nextInt();
 starting_pos[1]=sc.nextInt();
 ending_pos[0]=sc.nextInt();
 ending_pos[1]=sc.nextInt();
 System.out.println(knightWalk(starting_pos,ending_pos,n));

 }
 static int x2,y2;
 static int knightWalk(int[] starting_pos, int[] ending_pos, int n)
 {
 PriorityQueue<DistPairs> pQ = new PriorityQueue<>(Comparator.comparingInt(a -> a.euclideanDistance));
 boolean[][] visited = new boolean[n][n];

 int x1 = starting_pos[0],y1 = starting_pos[1];
 x2 = ending_pos[0]; y2 = ending_pos[1];
 int eucDist = getEucDistance(x1,y1),ans = 0;

 pQ.offer(new DistPairs(x1,y1,eucDist,0));
 while (!pQ.isEmpty()){

 DistPairs obj = pQ.poll();
 int r = obj.row,c = obj.col,d = obj.pathDistance;
 ans = Math.max(d,ans);
 if(r == x2 && c == y2) return d;

 if(r+2 < n && c+1 < n && !visited[r+2][c+1]){
 visited[r+2][c+1] = true;
 pQ.offer(new DistPairs(r+2,c+1,getEucDistance(r+2,c+1),d+1));
 }

 if(r+2 < n && c-1 > -1 && !visited[r+2][c-1]){
 visited[r+2][c-1] = true;
 pQ.offer(new DistPairs(r+2,c-1,getEucDistance(r+2,c-1),d+1));
 }

 if(r-2 > -1 && c+1 < n && !visited[r-2][c+1]){
 visited[r-2][c+1] = true;
 pQ.offer(new DistPairs(r-2,c+1,getEucDistance(r-2,c+1),d+1));
 }

 if(r-2 > -1 && c-1 > -1 && !visited[r-2][c-1]){
 visited[r-2][c-1] = true;
 pQ.offer(new DistPairs(r-2,c-1,getEucDistance(r-2,c-1),d+1));
 }

 if(r+1 < n && c+2 < n && !visited[r+1][c+2]){
 visited[r+1][c+2] = true;
 pQ.offer(new DistPairs(r+1,c+2,getEucDistance(r+1,c+2),d+1));
 }

 if(r+1 < n && c-2 > -1 && !visited[r+1][c-2]){
 visited[r+1][c-2] = true;
 pQ.offer(new DistPairs(r+1,c-2,getEucDistance(r+1,c-2),d+1));
 }

 if(r-1 > -1 && c+2 < n && !visited[r-1][c+2]){
 visited[r-1][c+2] = true;
 pQ.offer(new DistPairs(r-1,c+2,getEucDistance(r-1,c+2),d+1));
 }

 if(r-1 > -1 && c-2 > -1 && !visited[r-1][c-2]){
 visited[r-1][c-2] = true;
 pQ.offer(new DistPairs(r-1,c-2,getEucDistance(r-1,c-2),d+1));
 }

 }
 return ans;
 }

 private static int getEucDistance(int x1, int y1) {
 return (int) Math.sqrt(Math.pow(x2 - x1,2) + Math.pow(y2 - y1,2));
 }

 private static class DistPairs{
 int row,col, euclideanDistance,pathDistance;
 private DistPairs(int row,int col,int euclDist,int pathD){
 this.row = row;
 this.col = col;
 this.euclideanDistance = euclDist;
 this.pathDistance = pathD;
 }
 }
 */