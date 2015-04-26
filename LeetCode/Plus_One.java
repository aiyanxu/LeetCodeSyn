public class Solution {
    public int[] plusOne(int[] digits){
		int res = 1;
		for(int i=digits.length-1;i>=0;i--){
			res += digits[i];
			digits[i] = res % 10;
			res /= 10;
			if(res == 0)
				return digits;
		}
		int[] new_digits = new int[digits.length+1];
		for(int i=1;i<new_digits.length;i++){
			new_digits[i] = digits[i-1];
		}
		new_digits[0] = 1;
		return new_digits;
	}
}