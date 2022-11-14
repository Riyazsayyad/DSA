package LeetCode.Arrays;

public class RemoveStones {
    public static int removeStones(int[][] stones) {
        int n = stones.length, count = 0;
        for (int i = n-1; i >=1 ; i--) {
            for (int j = i-1; j >=0 ; j--) {
                if(stones[i][0]==stones[j][0] || stones[i][1]==stones[j][1])
                {
                    count++;
                    System.out.println(i+" "+j+" "+count);
                    break;
                }
            }
        }
        return count;
    }

    public static void main(String[] args){
        int[][] a ={{0,0},{0,1},{1,0},{1,2},{2,1},{2,2}};
        //{{0,0},{0,1},{1,0},{1,2},{2,1},{2,2}}
        System.out.println(removeStones(a));
    }
}
