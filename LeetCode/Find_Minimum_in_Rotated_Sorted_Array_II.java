public class Solution {
    public int findMin(int num[]){
        return helper(num,0,num.length-1);
    }

    private int helper(int[] num,int low,int high){
        if(low > high)
            return num[0];
        if(low == high)
            return num[low];
        int mid = (low+high)/2;
        if(mid<high && num[mid+1] < num[mid])
            return num[mid+1];
        if(mid>low && num[mid] < num[mid-1])
            return num[mid];
        if(num[low] == num[mid] && num[high] == num[mid])
            return Math.min(helper(num,low,mid-1),helper(num,mid+1,high));
        if(num[high] >= num[mid])
            return helper(num,low,mid-1);
        return helper(num,mid+1,high);
    }
}