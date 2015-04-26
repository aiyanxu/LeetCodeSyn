public class Solution {
    public int maxProfit(int[] prices) {
        int max_profile = 0;
		int tmp_profile = 0; 
		int lowest_price = Integer.MAX_VALUE;
		for(int i=0;i<prices.length;i++){
			if(prices[i] < lowest_price)
				lowest_price = prices[i];
			tmp_profile = prices[i]-lowest_price;
			if(tmp_profile > max_profile)
				max_profile = tmp_profile;
		}
		return max_profile;
    }
}