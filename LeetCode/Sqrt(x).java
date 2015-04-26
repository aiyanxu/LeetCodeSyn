public class Solution {
    public int sqrt(int x){
        int start = 0;
        int end = x/2 < Math.sqrt(Integer.MAX_VALUE)? x/2+1 : (int)Math.sqrt(Integer.MAX_VALUE);
        while(start <= end){
            int mid = (start+end)/2;
            int res = mid * mid;
            if (res == x)
                return mid;
            else if (res < x)
                start = mid + 1;
            else
                end = mid - 1;
        }
        return (start+end)/2;
    }
}