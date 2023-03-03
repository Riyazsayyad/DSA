package LeetCode;
import javafx.util.Pair;

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

        System.out.println();
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

    public int totalFruit(int[] fruits) {
        int left = 0, right;
        Map<Integer,Integer> map = new HashMap<>();

        for (right = 0; right < fruits.length; ++right) {
            map.put(fruits[right],map.getOrDefault(fruits[right],0)+1);

            if(map.size() > 2){
                map.put(fruits[left],map.get(fruits[left])-1);
                if(map.get(fruits[left]) == 0) map.remove(fruits[left]);
                left++;
            }
        }

        return right - left;
    }

    public long distinctNames(String[] ideas) {
        int n = ideas.length;
        Set<String> ideaSet = new HashSet<>(Arrays.asList(ideas));
        Set<String> validNames = new HashSet<>();

        for(int i = 0;i < n;i++){
            for(int j = 0;j < n;j++){
                if(j != i){
                    String [] ans = swapFirstChar(ideas[i],ideas[j]);
                    if(!ideaSet.contains(ans[0]) && !ideaSet.contains(ans[1])){
                        validNames.add(ans[0].concat(" ").concat(ans[1]));
                    }
                }
            }
        }
        return validNames.size();
    }

    private String[] swapFirstChar(String s1, String s2) {
        StringBuilder word1 = new StringBuilder(s1);
        StringBuilder word2 = new StringBuilder(s2);

        word1.replace(0,1, String.valueOf(s2.charAt(0)));
        word2.replace(0,1, String.valueOf(s1.charAt(0)));

        return new String[]{word1.toString(),word2.toString()};
    }

    public int maxDistance(int[][] grid) {
        int n = grid.length;
        Queue<Pair<Integer,Integer>> Q = new LinkedList<>(),Q1 = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if(grid[i][j] == 1){
                    Q.offer(new Pair<>(i+1,j));
                    Q.offer(new Pair<>(i-1,j));
                    Q.offer(new Pair<>(i,j+1));
                    Q.offer(new Pair<>(i,j-1));
                }
            }
        }
        int steps = 0;
        while (!Q.isEmpty()){
            ++steps;
            while (!Q.isEmpty()){
                Pair<Integer,Integer> pair = Q.poll();
                int row = pair.getKey(),col = pair.getValue();
                if(row >= 0 && col >= 0 && row < n && col < n && grid[row][col] == 0){
                    grid[row][col] = steps;
                    Q1.offer(new Pair<>(row+1,col));
                    Q1.offer(new Pair<>(row-1,col));
                    Q1.offer(new Pair<>(row,col+1));
                    Q1.offer(new Pair<>(row,col-1));
                }
            }
            Queue<Pair<Integer,Integer>> temp = Q;
            Q = Q1;
            Q1 = temp;
        }

        return steps == 1 ? -1 : --steps;
    }

    public int[] shortestAlternatingPaths(int n, int[][] redEdges, int[][] blueEdges) {
        int[][] graph = new int[n][n];
        for (int [] A : graph ) Arrays.fill(A,-n);
        buildGraph(graph,redEdges,blueEdges);
        Queue<int[]> Q = new LinkedList<>();
        Q.offer(new int[]{0,1});
        Q.offer(new int[]{0,-1});
        int len = 0;
        Set<String> visited = new HashSet<>();
        int[] result = new int[n];
        Arrays.fill(result,Integer.MAX_VALUE);
        while (!Q.isEmpty()){
            len++;
            int size = Q.size();
            for (int i = 0; i < size; i++) {
                int[] curr = Q.poll();
                int node = curr[0],color = curr[1];
                int oppColor = -color;

                for (int j = 1; j < n; j++) {
                    if(graph[node][j] == oppColor || graph[node][j] == 0){
                        if(!visited.add(j+""+oppColor)) continue;
                        Q.offer(new int[]{j,oppColor});
                        result[j] = Math.min(result[j],len);
                    }
                }
            }
        }

        for (int i = 1; i < n; i++) {
            if(result[i] == Integer.MAX_VALUE) result[i] = -1;
        }

        return result;
    }

    private void buildGraph(int[][] graph, int[][] redEdges, int[][] blueEdges) {
        for (int [] A: redEdges){
            graph[A[0]][A[1]] = 1;
        }
        for (int [] A: blueEdges){
            if(graph[A[0]][A[1]] == 1) graph[A[0]][A[1]] = 0;
            else graph[A[0]][A[1]] = -1;
        }

    }

    private void bfs(Map<Integer, List<Integer>> redGraph, Map<Integer, List<Integer>> blueGraph, int node) {

    }

    HashMap<Integer,ArrayList<Integer>> graph;
    public long minimumFuelCost(int[][] roads, int seats) {
        graph = new HashMap<>();
        for (int i = 0; i <= roads.length; i++) graph.put(i,new ArrayList<>());

        for (int [] A : roads){
            graph.get(A[0]).add(A[1]);
            graph.get(A[1]).add(A[0]);
        }

        return 0l;
    }

    public String addBinary(String a, String b) {
        int n = a.length() > b.length() ? b.length() - 1 : a.length() - 1;
        String ans = "";
        while (n-- > -1){
            int sum = Integer.parseInt(String.valueOf(a.charAt(n))) + Integer.parseInt(String.valueOf(b.charAt(n)));
            String binary = Integer.toBinaryString(sum);
            System.out.println(binary);
            ans = binary.length() > 1 ?
                    ans.concat(String.valueOf(binary.charAt(1))) : ans.concat(String.valueOf(binary.charAt(0)));

        }
        return ans;
    }

    public int[] twoSum(int[] nums, int target) {
        int n = nums.length;
        int[][] A = new int[n][2];
        for (int i = 0; i < n; i++) {
            A[i][0] = nums[i];
            A[i][1] = i;
        }
        Arrays.sort(A, Comparator.comparingInt(a -> a[0]));
        System.out.println(Arrays.deepToString(A));
        return new int[]{};
    }

    //Merge Sort
    public int[] sortArray(int[] nums) {
        sort(nums,0,nums.length-1);
        return nums;
    }

    private void sort(int[] nums, int start, int end) {

        if(start < end){
            int mid = start + (end - start)/2;

            sort(nums,start,mid);
            sort(nums,mid+1,end);

            merge(nums,start,mid,end);
        }
    }

    private void merge(int[] nums, int start, int mid, int end) {
        int n1 = mid - start + 1,n2 = end - mid;
        int L[] = new int[n1],R[] = new int[n2];

        System.arraycopy(nums,start,L,0,n1);
        System.arraycopy(nums,mid+1,R,0,n2);

        int i = 0, j = 0;

        int k = start;
        while (i < n1 && j < n2) {
            if (L[i] <= R[j]) {
                nums[k] = L[i];
                i++;
            }
            else {
                nums[k] = R[j];
                j++;
            }
            k++;
        }

        while (i < n1) {
            nums[k] = L[i];
            i++;
            k++;
        }

        while (j < n2) {
            nums[k] = R[j];
            j++;
            k++;
        }
    }

    public int compress(char[] chars) {
        if(chars.length == 1) return 1;

        int i = 0,j = 1;
        StringBuilder result = new StringBuilder();

        while (j < chars.length){
            if(chars[i] == chars[j]) j++;
            else {
                if ((j - i) == 1) result.append(chars[i]);
                else result.append(chars[i]).append(j - i);
                i = j++;
            }
        }

        if ((j - i) == 1) result.append(chars[i]);
        else result.append(chars[i]).append(j - i);

        int n = result.length(),k = 0;
        for (char x : result.toString().toCharArray()) chars[k++] = x;

        return n;
    }

}

/*
    public int totalFruit(int[] fruits) {
        Map<Integer,Integer> map = new HashMap<>();
        PriorityQueue<FruitCart> pQ = new PriorityQueue<>((a,b) -> b.count - a.count);

        for(int f : fruits){
            map.put(f,map.getOrDefault(f,0)+1);
        }

        for (Map.Entry<Integer, Integer> entry : map.entrySet()){
            if(pQ.size() <= 2)
            {
                pQ.add(new FruitCart(entry.getKey(),entry.getValue()));
            }
            else
            {
                if(pQ.peek().count < entry.getValue()){
                    pQ.poll();
                    pQ.add(new FruitCart(entry.getKey(),entry.getValue()));
                }
            }
        }

        int sum = 0;
        while (!pQ.isEmpty()){
            sum += pQ.poll().count;
        }

        return sum;
    }

    static class FruitCart{
        int fruit,count;
        private FruitCart(int fruit, int count){
            this.count = count;
            this.fruit = fruit;
        }
    }
 */
