package Crio.DSA_2;

public class BestTimeToBuyAndSellStocks {
    // Implement your solution Here
    public int maxProfit(int[] prices) {

        int i=1;
        int sum=0;
        int n =prices.length;
        while(i!=n){
            if(prices[i]>prices[i-1])
                sum+=prices[i]-prices[i-1];
            i++;
        }return sum;

        /*int maxProfit =0;
        for (int i=1;i<prices.length;i++){
            if(prices[i]>prices[i-1])
                maxProfit+=prices[i]-prices[i-1];
        }return maxProfit;*/

        /*
        int sum=0;
        int i =0;
        int j =1;
        int n =prices.length;
        if(n==1)
            return 0;
        //7, 1, 5, 3, 6, 4
        while(i!=(n-1)){
            if(prices[i]<prices[j] ){
                sum+=(prices[j]-prices[i]);
                System.out.println(prices[i]+" "+prices[j]+" "+sum);
                i++;
                j++;
            }
            else if(j==(n-1)){i++; j=i+1; }
            else j++;
        }
        return sum;

         */
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
