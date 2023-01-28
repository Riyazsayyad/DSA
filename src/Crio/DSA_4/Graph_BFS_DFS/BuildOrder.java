package Crio.DSA_4.Graph_BFS_DFS;
import java.util.*;

public class BuildOrder {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        int p = sc.nextInt();
        int d = sc.nextInt();

        sc.nextLine();
        ArrayList<String> project = new ArrayList<>();
        for(String val:sc.nextLine().split(" ")){
            // System.out.print(val+" ");
            project.add(val);
        }

        ArrayList<ArrayList<String> > dependencies = new ArrayList<>();
        for(int i=0;i<d;i++){
            ArrayList<String> dependency = new ArrayList<>();
            for(String dep:sc.nextLine().split(" ")){
                dependency.add(dep);
            }
            dependencies.add(dependency);
        }
        ArrayList<String> ans = buildOrder(project,dependencies);

        for(String proj:ans){
            System.out.print(proj+" ");
        }
        sc.close();
    }
    static ArrayList<ArrayList<String>> adj;
    static boolean[] visited;
    static boolean[] traversed;

    public static ArrayList<String> buildOrder(ArrayList<String> project,ArrayList<ArrayList<String> > dependencies){
        int n = project.size();
        for (int i = 0; i <= n; i++) {
            adj.add(new ArrayList<>());
        }
        for (ArrayList<String> D : dependencies){
            //adj.get(D.indexOf())
        }
        return new ArrayList<>();
    }

}
