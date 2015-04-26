public class Solution {
    public boolean search(int[] A, int target){
        if(A == null || A.length == 0)
            return false;
        int low = 0;
        int high = A.length-1;
        while(low <= high){
            int mid = (low+high)/2;
            if(A[mid] == target)
                return true;
            if(A[mid] > A[low]){
                if (A[mid] > target && A[low] <= target){
                    high = mid -1;
                }
                else {
                    low = mid + 1;
                }
            }else if (A[mid] < A[low]){
                if(A[mid] < target && A[high] >= target){
                    low = mid + 1;
                }else {
                    high = mid - 1;
                }
            }
            else {
                low += 1;
            }
        }
        return false;
    }
}