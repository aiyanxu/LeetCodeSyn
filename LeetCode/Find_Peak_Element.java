public class Solution {
    public int findPeakElement(int[] num) {
        return find_peak_element(num,0,num.length-1);
    }
    
    private int find_peak_element(int[] num, int low, int high){
		int mid = (low+high)/2;
		if((mid == 0 || num[mid] >= num[mid-1]) && (mid == num.length-1 || num[mid] >= num[mid+1]))
			return mid;
		else if(mid > 0 && num[mid] < num[mid-1])
			return find_peak_element(num,low,mid-1);
		else
			return find_peak_element(num,mid+1,high);
	}
}