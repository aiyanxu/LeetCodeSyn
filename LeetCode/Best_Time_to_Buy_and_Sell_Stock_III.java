public class Solution {
    public int maxProfit(int[] prices) {
         if (prices == null || prices.length == 0)
            return 0;
        int[] left = new int[prices.length];
        int lowest = prices[0];
        int leftMax = Integer.MIN_VALUE;
        for (int i=0;i<prices.length;i++){
            if(prices[i] < lowest)
                lowest = prices[i];
            int temp = prices[i] - lowest;
            if (temp > leftMax)
                leftMax = temp;
            left[i] = leftMax;
        }
        int highest = prices[prices.length-1];
        int rightMax = Integer.MIN_VALUE;
        int[] right = new int[prices.length];
        int res = 0;
        for (int i=prices.length-1;i>=0;i--){
            if (prices[i] > highest)
                highest = prices[i];
            int temp = highest - prices[i];
            if (temp > rightMax)
                rightMax = temp;
            right[i] = rightMax;
            res = Math.max(res,right[i] + left[i]);
        }
        return res;
    }
}