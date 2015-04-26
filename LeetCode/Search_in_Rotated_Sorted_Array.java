public class Solution {
    public int search(int[] A,int target){
        if (A == null || A.length == 0)
            return -1;
        int low = 0;
        int high = A.length - 1;
        while(low <= high){
            int mid = (low+high)/2;
            if (A[mid] == target)
                return mid;
            else if (A[mid] >= A[low]){
                if (A[mid] > target && A[low] <= target){
                    high = mid - 1;
                }else {
                    low = mid + 1;
                }
            }else {
                if (A[mid] < target && A[high] >= target){
                    low = mid + 1;
                }else {
                    high = mid - 1;
                }
            }
        }
        return -1;
    }
}