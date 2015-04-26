public class Solution {
    public boolean canJump(int[] A) {
        int reach = 0;
        for(int i=0;i<=reach&&i<A.length;i++){
            reach = Math.max(i+A[i],reach);
        }
        if(reach < A.length-1)
            return false;
        return true;
    }
}