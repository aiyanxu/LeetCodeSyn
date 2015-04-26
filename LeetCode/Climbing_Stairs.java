public class Solution {
    public int climbStairs(int n) {
        int a = 2,b = 3,c = 5;
		if(n < 4)
			return n;
		for(int i=4; i<=n; i++){
			c = a + b;
			a = b;
			b = c;
		}
		return c;
    }
}