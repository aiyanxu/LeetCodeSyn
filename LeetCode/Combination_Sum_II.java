public class Solution {
    public ArrayList<ArrayList<Integer>> combinationSum2(int[] num,int target){
        ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
        if(num == null || num.length == 0)
            return res;
        ArrayList<Integer> item = new ArrayList<Integer>();
        Arrays.sort(num);
        helper(num, target, 0, item, res);
        return res;
    }
    private void helper(int[] num,int target,int start,ArrayList<Integer> item,ArrayList<ArrayList<Integer>> res){
        if(target == 0){
            res.add(new ArrayList<Integer>(item));
            return;
        }
        if(target < 0 || start >= num.length)
            return;
        for(int i=start;i<num.length;i++){
            if(i>start && num[i] == num[i-1])
                continue;
            item.add(num[i]);
            helper(num, target - num[i], i + 1, item, res);
            item.remove(item.size()-1);
        }
    }
}