public class Solution {
    public int trailingZeroes(int n) {
        int res = 0;
        int x = 5;
        while(n >= x) {
            res += n/x;
            x *= 5;
        }
        return res;
    }
}