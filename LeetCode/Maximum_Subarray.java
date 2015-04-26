public class Solution {
    public int maxSubArray(int[] A) {
        int max = Integer.MIN_VALUE;
		int current_sum = 0;
		if(A.length == 1)
			return A[0];
		for(int i=0; i<A.length; i++){
			current_sum += A[i];
			if(current_sum > max)
				max = current_sum;
			if(current_sum < 0)
				current_sum = 0;
			
		}
		return max;
    }
}