public class Solution {
    public int findMin(int[] num){
        if (num.length == 1)
            return num[0];
        int low = 0;
        int high = num.length-1;
        int mid;
        while (low < high){
            mid = (low+high)/2;
            if(mid < high && num[mid+1] < num[mid])
                return num[mid+1];
            if(mid > low && num[mid]<num[mid-1])
                return num[mid];
            if(num[high] > num[mid]){
                high = mid-1;
            }
            else{
                low = mid+1;
            }
        }
        return num[(low+high)/2];
    }
}