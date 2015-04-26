public class Solution {
    public int[] searchRange(int[] A,int target){
        int[] res = new int[2];
        int low = 0,high = A.length-1;
        while(low<=high){
            int mid = (low+high)/2;
            if(A[mid] == target){
                int i=mid,j=mid;
                while(i >= 0 && A[i] == target)
                    i--;
                while(j < A.length && A[j] == target)
                    j++;
                res[0] = i+1;
                res[1] = j-1;
                return res;
            }
            else if(A[mid] < target)
                low = mid + 1;
            else
                high = mid - 1;
        }
        res[0] = -1;
        res[1] = -1;
        return res;
    }
}