package LeetCode;
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
