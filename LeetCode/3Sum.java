public class Solution {
    public ArrayList<ArrayList<Integer>> threeSum(int[] num) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
        if(num.length < 3)
            return res;
        Arrays.sort(num);
        for(int i=0;i<num.length-2;i++){
            if(num[i] > 0)
                break;
            if(i == 0 || num[i] > num[i-1]){
                int negate = -num[i];
                int start = i + 1;
                int end = num.length-1;
                while(start<end){
                    if(num[start] + num[end] == negate){
                        ArrayList<Integer> tmp = new ArrayList<Integer>();
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
                    }else if(num[start] + num[end] < negate){
                        start++;
                    }else
                        end--;
                }
            }
        }
        return res;
    }
}