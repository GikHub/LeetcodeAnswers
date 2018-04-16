package greedy;

public class Onetwotwo {
	public int maxProfit(int[] prices) {
        int profit=0;
        for(int i=1;i<prices.length;i++){
        	if(prices[i]>prices[i-1]){
        		profit+=prices[i]-prices[i-1];
        	}
        }
        return profit;
    }
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
