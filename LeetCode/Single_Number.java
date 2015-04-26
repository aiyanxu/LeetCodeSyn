public class Solution {
     public int singleNumber(int[] A){
        int res = 0;
        for(int val : A)
            res = res ^ val;
        return res;
    }
}