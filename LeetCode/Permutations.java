public class Solution {
    public ArrayList<ArrayList<Integer>> permute(int[] num) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
        if(num == null || num.length == 0)
            return res;
        boolean[] used = new boolean[num.length];
        ArrayList<Integer> item = new ArrayList<Integer>();
        helper(num,used,item,res);
        return res;
    }
    
    private void helper(int[] num, boolean[] used,ArrayList<Integer>item,ArrayList<ArrayList<Integer>> res){
        if(item.size() == num.length){
            res.add(new ArrayList<Integer>(item));
            return;
        }
        for(int i=0;i<num.length;i++){
            if(!used[i]){
                item.add(num[i]);
                used[i] = true;
                helper(num,used,item,res);
                item.remove(item.size()-1);
                used[i] = false;
            }
        }
    }
}