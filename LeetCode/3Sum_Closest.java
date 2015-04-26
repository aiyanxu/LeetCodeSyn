public class Solution {
    public int threeSumClosest(int[] num,int target){
        Arrays.sort(num);
        int result = num[0]+num[1]+num[2];
        int min = Math.abs(target-result);
        for(int i=0;i<num.length-2;i++){
            if(num[i] > target/3)
                break;
            if(i == 0 || num[i] > num[i-1]){
                int start = i + 1;
                int end = num.length-1;
                while(start<end){
                    int sum = num[i] + num[start]+num[end];
                    int diff = Math.abs(sum-target);
                    if(diff == 0){
                        return target;
                    }
                    if(diff < min){
                        min = diff;
                        result = sum;
                    }
                    if(sum < target)
                        start++;
                    else
                        end--;
                }
            }
        }
        return result;
    }
}