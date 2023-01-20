package Crio.DSA_4.Graph;
import java.util.*;

class RottingOranges{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while((t--)>0){
            int n,m;
            n= sc.nextInt();
            m=sc.nextInt();
            ArrayList<ArrayList<Integer> > a = new ArrayList<ArrayList<Integer> >();
            for(int i=0;i<n;i++){
                a.add(new ArrayList<Integer>());
            }
            for(int i=0;i<n;i++){
                for(int j = 0;j<m;j++){
                    a.get(i).add(sc.nextInt());
                }
            }
            int ans  = RottingOranges.rottingOranges(a);
            System.out.println(ans);
        }
        sc.close();
    }

    public static int rottingOranges(ArrayList<ArrayList<Integer>> A){
        Queue<OrangePair> Q = new LinkedList<>();
        for (int i = 0; i < A.size(); i++) {
            for (int j = 0; j < A.get(i).size(); j++) {
                if(A.get(i).get(j) == 2)  Q.offer(new OrangePair(i,j,0));
            }
        }
        int maxTime = 0;
        while (!Q.isEmpty()){
            OrangePair obj = Q.poll();
            int row = obj.I, col = obj.J, time = obj.T;
            maxTime = Math.max(maxTime,time);
            //down
            if(row+1 < A.size() && A.get(row+1).get(col) == 1){
                A.get(row+1).set(col,2);
                Q.offer(new OrangePair(row+1,col,time+1));
            }
            //up
            if(row-1 > -1 && A.get(row-1).get(col) == 1){
                A.get(row-1).set(col,2);
                Q.offer(new OrangePair(row-1,col,time+1));
            }
            //left
            if(col+1 < A.get(0).size() && A.get(row).get(col+1) == 1){
                A.get(row).set(col+1,2);
                Q.offer(new OrangePair(row,col+1,time+1));
            }
            //right
            if(col-1 > -1 && A.get(row).get(col-1) == 1){
                A.get(row).set(col-1,2);
                Q.offer(new OrangePair(row,col-1,time+1));
            }
        }

        for (ArrayList<Integer> integers : A) {
            for (int j = 0; j < integers.size(); j++) {
                if (integers.get(j) == 1) return -1;
            }
        }

        return maxTime;
    }

    private static class OrangePair{
        int I,J,T;
        private OrangePair(int I, int J,int T){
            this.I = I;
            this.J = J;
            this.T = T;
        }
    }
}
