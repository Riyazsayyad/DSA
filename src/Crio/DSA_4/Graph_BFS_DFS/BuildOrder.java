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
    static HashMap<String,ArrayList<String>> adj;
    static Set<String> visited;
    static Set<String> traversed;
    static ArrayList<String> ans;

    public static ArrayList<String> buildOrder(ArrayList<String> project,ArrayList<ArrayList<String> > dependencies){
        adj = new HashMap<>();
        ans = new ArrayList<>();
        visited = new HashSet<>();
        traversed = new HashSet<>();

        for (String s : project) {
            adj.put(s, new ArrayList<>());
        }

        for (ArrayList<String> A: dependencies){
            adj.get(A.get(1)).add(A.get(0));
        }

        for (String p : project){
            if(!visited.contains(p)) dfs(p);
        }
        boolean cyclePresent = false;
        visited.clear();

        for (String p : project){
            if(!visited.contains(p)){
                if (isCyclic(p,visited,traversed)){
                    cyclePresent = true;
                    break;
                }
            }
        }

        if(cyclePresent) {
            ans.clear();
            ans.add("-1");
        }

        return ans;

    }

    private static boolean isCyclic(String curr, Set<String> visited, Set<String> traversed) {
        visited.add(curr);
        traversed.add(curr);
        for (int i = 0; i < adj.get(curr).size(); i++) {
            String u = adj.get(curr).get(i);
            if(!visited.contains(u)){
                if(isCyclic(u,visited,traversed)) return true;
            }
            else if(traversed.contains(u)) return true;
        }
        traversed.remove(curr);
        return false;

    }

    private static void dfs(String curr) {
        visited.add(curr);
        for (int i = 0; i < adj.get(curr).size(); i++) {
            String u = adj.get(curr).get(i);
            if(!visited.contains(u)) dfs(u);
        }
        ans.add(curr);
    }
}
