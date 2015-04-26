public class Solution {
    public int searchInsert(int[] A, int target) {
        if(A[0] > target)
            return 0;
        if(A.length == 0 || A==null)
            return 0;
        for(int i=0;i<A.length-1;i++) {
            if (A[i] == target)
                return i;
            if(A[i]<target && target<A[i+1])
                return i+1;
        }
        if(A[A.length-1] == target)
            return A.length-1;
        else if(A[A.length-1] > target)
            return A.length-1;
        else
            return A.length;
    }
}