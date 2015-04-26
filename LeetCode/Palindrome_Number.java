public class Solution {
    public boolean isPalindrome(int x) {
       if(x<0)
			return false;
		if(x>=0 && x<10)
			return true;
		int div = 1;
		while(x / div >= 10){
			div *= 10;
		}
		while(x != 0){
			int first = x/div;
			int last = x%10;
			if(first != last)
				return false;
			x = (x%div) / 10;
			div /= 100;
		}
		return true;
    }
}