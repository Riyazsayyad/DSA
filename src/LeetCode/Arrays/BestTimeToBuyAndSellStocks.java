package LeetCode.Arrays;

public class BestTimeToBuyAndSellStocks {
    // Implement your solution Here
    public int maxProfit(int[] prices) {
        int lsf = Integer.MAX_VALUE;
        int op = 0;
        int pist = 0;

        for(int i = 0; i < prices.length; i++){
            if(prices[i] < lsf){
                lsf = prices[i];
            }
            pist = prices[i] - lsf;
            if(op < pist){
                op = pist;
            }
        }
        return op;
    
    }

    public static void main(String[] args) {
        //Scanner scanner = new Scanner(System.in);
        int[] prices = {7,1,5,3,6,4};
        //for (int i = 0; i < prices.length; i++)
            //prices[i] = scanner.nextInt();
        //scanner.close();

        int result = new BestTimeToBuyAndSellStocks().maxProfit(prices);
        System.out.print(Integer.toString(result));
    }
}
