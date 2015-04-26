public class Solution {
    public ArrayList<ArrayList<Integer>> fourSum(int[] num, int target){
        ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
        if(num.length<4)
            return res;
        Arrays.sort(num);
        for(int i=0;i<num.length-3;i++){
            if(num[i] > target/4)
                break;
            if(i==0 || num[i] > num[i-1]){
                ArrayList<ArrayList<Integer>> tmp = threeSum(num,target-num[i],i+1,num.length-1);
                if(tmp != null)
                    res.addAll(tmp);
            }
        }
        return res;
    }
    
    public ArrayList<ArrayList<Integer>> threeSum(int[] num,int target,int low,int high) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
        if(num.length < 3)
            return res;
        for(int i=low;i<high-1;i++){
            if(num[i] > target/3)
                break;
            if(i == low || num[i] > num[i-1]){
                int remain = target-num[i];
                int start = i + 1;
                int end = num.length-1;
                while(start<end){
                    if(num[start] + num[end] == remain){
                        ArrayList<Integer> tmp = new ArrayList<Integer>();
                        tmp.add(num[low-1]);
                        tmp.add(num[i]);
                        tmp.add(num[start]);
                        tmp.add(num[end]);
                        res.add(tmp);
                        start++;
                        end--;
                        while (start<end && num[start] == num[start-1])
                            start++;
                        while(start<end && num[end] == num[end+1])
                            end--;
                    }else if(num[start] + num[end] < remain){
                        start++;
                    }else
                        end--;
                }
            }
        }
        return res;
    }
}