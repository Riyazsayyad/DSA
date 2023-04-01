package LeetCode;

import javafx.util.Pair;

import java.util.*;

class Solution {
    public static void main(String[] args) {
        ArrayList<Integer> A = new ArrayList<>();
        A.add(3);   A.add(1);   A.add(5);   A.add(8);
        System.out.println(maxCoins(4,A));
    }

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

    public int strStr(String haystack, String needle) {
        int i = 0,j = needle.length();
        while (j < haystack.length()){
            if(haystack.substring(i++, j++).equals(needle)) return i;
        }
        return -1;
    }

    public long countSubarrays(int[] nums, int minK, int maxK) {
        int minKPos = -1,maxKPos = -1,culIndex = -1;
        long temp = 0,ans = 0;
        for (int i = 0; i < nums.length; i++) {
            if(maxK < nums[i] || minK > nums[i]) culIndex = i;
            if(nums[i] == minK) minKPos = i;
            if(nums[i] == maxK) maxKPos = i;


            long smaller = Math.min(minKPos,maxKPos);
            temp = smaller - culIndex;
            ans += Math.max(temp, 0);
        }
        return ans;
    }

    public static int findKthPositive(int[] arr, int k) {
        Set<Integer> set = new HashSet<>();
        for (int x : arr) set.add(x);

        int num = 0,result = 0,size = 0;
        while (size != k){
            if(!set.contains(++num)) size++;
        }

        return num;
    }

    public static int minJumps(int[] arr) {
        Map<Integer,ArrayList<Integer>> map = new HashMap<>();
        Queue<Integer> Q = new LinkedList<>();
        int n = arr.length;
        boolean[] visited = new boolean[n];

        for (int value : arr) map.put(value, new ArrayList<>());
        for (int i = 0; i < n; i++) map.get(arr[i]).add(i);

        int steps = 0;
        Q.offer(0);
        visited[0] = true;

        while (!Q.isEmpty()){
            int size = Q.size();

            while (size-- != 0){
                int cur = Q.poll();

                if(cur == n-1) return steps;

                if (cur-1 >= 0 && !visited[cur-1]) {
                    Q.offer(cur - 1);
                    visited[cur-1] = true;
                    }
                if (cur+1 < n  && !visited[cur+1]){
                    Q.offer(cur+1);
                    visited[cur+1] = true;
                    }
                for(int i : map.getOrDefault(arr[cur],new ArrayList<>())){
                    if(!visited[i]){
                        Q.offer(i);
                        visited[i] = true;
                    }
                }
                map.remove(arr[cur]);
            }
            steps++;
        }
        return -1;
    }

    public long minimumTime(int[] time, int totalTrips) {
        int minTime = Integer.MAX_VALUE;
        for(int t : time) minTime = Math.min(minTime,t);
        long start = 1,end = minTime * totalTrips;

        while (start < end){
            long mid = start + (end - start)/2;
            if(canMakeTrip(mid,time,totalTrips)) end = mid;
            else start = mid + 1;
        }
        
        return start;
    }

    private boolean canMakeTrip(long cTime, int[] time, int totalTrips) {
        int actualTrips = 0;
        for(int x : time){
            actualTrips += cTime / x;
        }
        return actualTrips >= totalTrips;
    }

    public static int minEatingSpeed(int[] piles, int h) {
        int left = 1,right = Arrays.stream(piles).max().getAsInt();
        while (left < right){
            int mid = left + (right - left)/2;
            if(canEat(piles,mid,h)) right = mid;
            else left = mid + 1;
        }

        return left;
    }

    private static boolean canEat(int[] piles, int rate, int h) {
        int actualHours = 0;
        for(int P : piles) actualHours += (P-1)/rate + 1;
        return actualHours <= h;
    }

    public void nextPermutation(int[] nums) {
        int n = nums.length,k,l;

        //break point decreasing sequence
        for(k = n - 2;k >= 0;k--){
            if(nums[k] < nums[k+1]) break;
        }

        //if the whole array is in decreasing sequence
        if(k < 0) reverse(nums,0,n-1);
        else{
            //break point of increasing sequence
            for(l = n - 1;l > k;l--){
                if(nums[l] > nums[k]) break;
            }
            swap(nums,k,l);
            reverse(nums,k+1,n-1);
        }
    }

    void swap(int[] A,int k, int l) {
        int temp = A[k];
        A[k] = A[l];
        A[l] = temp;
    }

    void reverse(int[] A,int l,int r){
        while(l<r){
            int temp = A[l];
            A[l] = A[r];
            A[r] = temp;
            l++; r--;
        }
    }

    static Long maxTripletProduct(long[] arr, int n)
    {
        //n = 7
        //arr[] = {-3, -5, 1, 0, 8, 3, -2}

        long max1,max2,max3;
        max1 = max2 = max3 = Long.MIN_VALUE;
        long min1,min2;
        min1 = min2 = Long.MAX_VALUE;

        for (long num : arr){

            if(max1 < num){
                max3 = max2;
                max2 = max1;
                max1 = num;
            }
            else if(num > max2){
                max3 = max2;
                max2 = num;
            }
            else if(num > max3){
                max3 = num;
            }

            if(min1 > num){
                min2 = min1;
                min1 = num;
            }
            else if(min2 > num) min2 = num;
        }

        //System.out.println(max1+" "+max2+" "+max3+" "+min1+" "+min2);
        return Math.max(max1 * min1 * min2,max1 * max2 * max3);
    }

    ArrayList A;
    Random rand = new Random();
    public Solution(ListNode head) {
        A = new ArrayList<>();
        while(head != null){
            A.add(head.val);
            head = head.next;
        }
    }

    public int getRandom() {
        int randomIndex = rand.nextInt(A.size());
        return (int) A.get(randomIndex);
    }

    public TreeNode sortedListToBST(ListNode head) {
        if(head == null) return null;
        //Finding size
        int size = 0;
        ListNode curr = head;
        while (curr != null){
            ++size;
            curr = curr.next;
        }

        //Forming array
        int A[] = new int[size];
        curr = head;
        for (int i = 0; i < size; i++) {
            A[i] = curr.val;
            curr = curr.next;
        }

        //Forming BT
        return buildBST(A,0,A.length-1);
    }

    private TreeNode buildBST(int[] A, int left, int right) {
        if(left > right) return null;
        int mid = left + (right - left)/2;
        TreeNode root = new TreeNode(A[mid]);
        root.left = buildBST(A,left,mid-1);
        root.right = buildBST(A,mid+1,right);
        return root;
    }

    public static boolean isPalindrome(ListNode head)
    {
        if(head == null && head.next == null) return false;

        ListNode curr = head;
        int size = 0;
        while (curr != null){
            curr = curr.next;
            ++size;
        }

        int[] A = new int[size/2];
        ListNode slow = head, fast = head;
        while(slow != null && fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }

        curr = head;
        int i = (size/2) - 1;
        while (curr != slow){
            A[i--] = curr.val;
            curr = curr.next;
        }

        i = 0;
        slow = size % 2 == 0 ? slow : slow.next;
        while (slow != null){
            //System.out.println(slow.val);
            if(A[i++] != slow.val) return false;
            slow = slow.next;
        }

        return true;
    }

    public int totalFruitT(int[] fruits) {
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

    boolean check(TreeNode l,TreeNode r){
        if(l == null || r == null) return l == r;
        if(l.val != r.val) return false;
        return check(l.left,r.right) && check(l.right,r.left);
    }

    public boolean isSymmetric(TreeNode root) {
        return root == null || check(root.left,root.right);
    }

    public ListNode mergeKLists(ListNode[] lists) {

        PriorityQueue<Integer> Q = new PriorityQueue<>();
        for (ListNode head : lists){
            while (head != null){
                Q.offer(head.val);
                head = head.next;
            }
        }

        ListNode T = new ListNode(-1);
        ListNode result = T;
        while (!Q.isEmpty()){
            T.next = new ListNode(Q.poll());
            T = T.next;
        }

        return result.next;
    }

    //Deception Reason:  Mathematics
    static long maxPossibleValue(int N, int[] A, int[] B) {
        long x , y, mn = (long)1e10, ans = 0, tot = 0;
        for(int i = 0; i < N; i++){
            x = A[i];
            y = B[i];
            if(y % 2 == 1) y--;
            if(y >= 2) mn = Math.min(mn,x);
            ans += y*x;
            tot += y;
        }
        if(tot % 4 != 0) ans -= 2l * mn;

        return ans;
    }

    static int  maxCoins(int N, ArrayList<Integer> arr) {
        //Write your code here
        int result = 0;
        Map<Integer,Integer> map = new TreeMap<>();

        for (int i = 0; i < N; i++) {
            map.put(i,arr.get(i));
        }

        int index,value;
        for(Map.Entry<Integer,Integer> entry : map.entrySet()){
            index = entry.getKey(); value = entry.getValue();
            result +=  value + ((index - 1) >= 0 ? arr.get(index - 1) : 1) + ((index + 1) < N ? arr.get(index + 1) : 1);
            arr.remove(index);
        }

        return result;
    }

    ArrayList<String> paths;
    public int sumNumbers(TreeNode root) {
        paths = new ArrayList<>();
        inOrder(root,new StringBuilder(""));
        int result = 0;
        for(String num : paths){
            result += Integer.parseInt(num);
        }
        return result;
    }

    private void inOrder(TreeNode root,StringBuilder path){
        if(root == null) return;
        path.append(root.val);
        if(root.left == null && root.right == null) paths.add(path.toString());

        inOrder(root.left,path);
        inOrder(root.right,path);

        path.replace(path.length()-1,path.length(),"");
    }

    public boolean isCompleteTree(TreeNode root) {
        boolean end = false;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()) {
            TreeNode cur = queue.poll();
            if(cur == null) end = true;
            else{
                if(end) return false;
                queue.add(cur.left);
                queue.add(cur.right);
            }
        }
        return true;
    }

    private int getHeight(TreeNode root,int h) {
        if(root == null) return 0;
        return Math.max(getHeight(root.left,h+1),getHeight(root.right,h+1));
    }

    public  static int specialPalindrome(String a, String b){
        //Code Here
        return -1;
    }
/*
    // Accepted Solution using Doubly linked list
    private static class LL{
        LL back,front;
        String val;
        private LL(String val){
            this.val = val;
        }
    }
    LL head;

//    public BrowserHistory(String homepage) {
//        head = new LL(homepage);
//        head.front = head;
//        head.back = head;
//    }

    public void visit(String url) {
        LL curr = new LL(url);
        head.front = curr;
        curr.back = head;
        head = curr;
    }

    public String back(int steps) {
        for (int i = 0; i < steps; i++) {
            head = head.back;
        }
        return head.val;
    }

    public String forward(int steps) {
        for (int i = 0; i < steps; i++) {
            head = head.front;
        }
        return head.val;
    }
    //END
*/

    private HashMap<Integer,ArrayList<int[]>> Graph;
    private HashSet<Integer> visited;
    int result1;
    public int minScore(int n, int[][] roads) {
        Graph = new HashMap<>();
        visited = new HashSet<>();
        result1 = Integer.MAX_VALUE;

        for (int i = 0; i <= n; i++) Graph.put(i,new ArrayList<>());

        for (int[] road : roads) {
            Graph.get(road[0]).add(new int[]{road[1], road[2]});
            Graph.get(road[1]).add(new int[]{road[0], road[2]});
        }

        dfs(1);

        return result1;
    }

    private void dfs(int node) {
        visited.add(node);
        for (int[] A : Graph.get(node)){
            result1 = Math.min(A[1], result1);
            if(!visited.contains(A[0])) dfs(A[0]);
        }
    }

    class TrieNode{
        String item;
        TrieNode[] children;

        public TrieNode(){
            item = "";
            children = new  TrieNode[26];
        }
    }

    private TrieNode root;
    private int maxWordLen;
//    public WordDictionary() {
//        maxWordLen = 0;
//        root = new TrieNode();
//    }

    public void addWord(String word) {
        maxWordLen = Math.max(maxWordLen,word.length());
        TrieNode curr = root;
        for (int i = 0; i < word.length(); i++) {
            int index = word.charAt(i) - 'a';
            if(curr.children[index] == null) curr.children[index] = new TrieNode();
            curr = curr.children[index];
        }
        curr.item = word;
    }

    public boolean search(String word) {
        return match(word.toCharArray(),0,root);
    }

    private boolean match(char[] word, int i, TrieNode root) {
        if(i == word.length) return !root.item.equals("");

        if(word[i] != '.') return root.children[word[i]-'a'] != null && match(word,i+1,root.children[word[i]-'a']);
        else{
            for (int j = 0; j < word.length; j++) {
                if(root.children[j] != null){
                    if(match(word,i+1,root.children[j])) return true;
                }
            }
        }
        return false;
    }

    public boolean canPlaceFlowers(int[] A, int n) {
        int size = A.length;
        for(int i = 0;i < size;i++){
            if(n == 0) return true;
            if(A[i-1 < 0 ? 0 : i-1] != 1 && A[i+1 >= size ? i : i+1] != 1 && A[i] != 1){
                A[i] = 1;
                n--;
            }
        }
        return n == 0;
    }

    HashMap<Integer,ArrayList<int[]>> G;
    int count;
    public int minReorder(int n, int[][] connections) {
        G = new HashMap<>();
        count = 0;
        for (int i = 0; i < n; i++) {
            G.put(i,new ArrayList<>());
        }
        for (int [] A : connections){
            G.get(A[0]).add(new int[]{A[1],1});
            G.get(A[1]).add(new int[]{A[0],0});
        }
        dfs(0,-1);
        return count;
    }

    private void dfs(int node, int parent) {
        for(int[] A : G.get(node)){
            if(A[0] != parent){
                if(A[1] == 1) count++;
                dfs(A[0],node);
            }
        }
    }


    private int[] parent;
    private int[] rank;

    public int find(int x) {
        if (x == parent[x]) return x;
        return parent[x] = find(parent[x]);
    }

    public void union(int x, int y) {
        int xParent = find(x);
        int yParent = find(y);

        if (xParent == yParent) return;


        if (rank[xParent] > rank[yParent]) parent[yParent] = xParent;
        else if (rank[xParent] < rank[yParent]) parent[xParent] = yParent;
        else {
            parent[xParent] = yParent;
            rank[yParent]++;
        }
    }
    //result += size * (remaining node - size)
    public long countPairs(int n, int[][] edges) {
        parent = new int[n];
        rank = new int[n];

        for (int i = 0; i < n; i++) parent[i] = i;

        Map<Integer,Integer> map = new HashMap<>();

        for (int [] A : edges){
            if(find(A[0]) != find(A[1])){
                union(A[0],A[1]);
            }
        }

        for (int i = 0; i < n; i++) {
            int parent = find(i);
            map.put(parent,map.getOrDefault(parent,0)+1);
        }

        long result = 0;
        long remainingNodes = n;

        for(Map.Entry<Integer,Integer> entry : map.entrySet()){
            long size = entry.getValue();
            result += size * (remainingNodes - size);
            remainingNodes -= size;
        }
        return result;
    }

/*
    boolean[] inRecursion;
    boolean[] visited1;
    int[] count1;
    int result1 = -1;
    public int longestCycle(int[] edges) {
        int n = edges.length;
        visited1 = new boolean[n];
        inRecursion = new boolean[n];
        count1 = new int[n];

        Arrays.fill(count1,1);

        for(int i = 0;i < n;i++){
            if(!visited1[i]) dfs(i,edges);
        }

        return result1;
    }

    void dfs(int parent,int[] edges){
        if(parent != -1){
            visited1[parent] = true;
            inRecursion[parent] = true;

            int child = edges[parent];
            if(child != -1 && !visited1[child]){
                count1[child] = count1[parent] + 1;
                dfs(child,edges);
            }
            else if(child != -1 && inRecursion[child]){
                result1 = Math.max(result1, count1[parent] - count1[child]+1);
            }
            inRecursion[parent] = false;
        }
    }
*/

    public int longestCycle(int[] edges) {
        int ans = -1;
        int time = 1;
        int[] timeVisited = new int[edges.length];

        for (int i = 0; i < edges.length; ++i) {
            if (timeVisited[i] > 0)
                continue;
            final int startTime = time;
            int u = i;
            while (u != -1 && timeVisited[u] == 0) {
                timeVisited[u] = time++;
                u = edges[u]; // Move to next node
            }
            if (u != -1 && timeVisited[u] >= startTime)
                ans = Math.max(ans, time - timeVisited[u]);
        }
        return ans;
    }


    int[][] dp;
    public int minPathSum(int[][] grid) {
        int m = grid.length,n = grid[0].length;
        dp = new int[m][n];
        for(int [] A: dp) Arrays.fill(A,-1);
        return findMinPath(grid,0,0,m,n);
    }

    private int findMinPath(int[][] grid, int r, int c,int m,int n) {
        if(r >= m || c >= n) return Integer.MAX_VALUE;
        if(r == m-1 && c == n-1) return grid[r][c];
        if(dp[r][c] != -1) return dp[r][c];
        return dp[r][c] = Math.min(findMinPath(grid,r+1,c,m,n),findMinPath(grid,r,c+1,m,n))+grid[r][c];
    }




}




