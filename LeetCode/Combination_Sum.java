public class Solution {
    public ArrayList<ArrayList<Integer>> combinationSum(int[] candidates, int target){
        ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
        if(candidates.length == 0 || candidates == null)
            return res;
        Arrays.sort(candidates);
        ArrayList<Integer> item = new ArrayList<Integer>();
        helper(candidates,target,0,item,res);
        return res;
    }
    private void helper(int[] candidates,int target,int start,ArrayList<Integer> item, ArrayList<ArrayList<Integer>> res){
        if(sum(item) == target){
            res.add(new ArrayList<Integer>(item));
            return;
        }
        if(sum(item) > target)
            return;
        for(int i=start;i<candidates.length;i++){
            if(i>0 && candidates[i] == candidates[i-1])
                continue;
            item.add(candidates[i]);
            helper(candidates,target,i,item,res);
            item.remove(item.size()-1);
        }
    }
    private int sum(ArrayList<Integer> item){
        int res = 0;
        if(item != null)
            for(int i : item)
                res += i;
        return res;
    }
}