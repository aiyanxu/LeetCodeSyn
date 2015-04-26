public class Solution {
    public int search(int[] A, int target) {
       int low = 0;
		int high = A.length-1;
		int mid = (low+high)/2;
		while(low <= high){
			if(A[mid] == target){
				return mid;
			}
			else if(A[mid] > target){
				if(A[mid] < A[low]){
					high = mid - 1;
				}else{
					if(A[low] == target){
						return low;
					}else if(A[low] > target){
						low = mid + 1;
					}else{
						high = mid -1;
					}
				}
			}
			else{
				if(A[mid]<A[low]){
					if(A[high] == target){
						return high;
					}else if(A[high] > target){
						low = mid+1;
					}else{
						high = mid-1;
					}
				}else{
					low = mid + 1;
				}
			}
			mid = (low+high)/2;
		}
		return -1;
    }
}