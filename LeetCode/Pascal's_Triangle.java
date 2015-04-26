public class Solution {
    public ArrayList<ArrayList<Integer>> generate(int numRows) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
        if(numRows == 0)
            return res;
        ArrayList<Integer> first = new ArrayList<Integer>();
        first.add(1);
        ArrayList<Integer> second = new ArrayList<Integer>();
        second.add(1);
        second.add(1);
        if(numRows == 1){
            res.add(first);
            return res;
        }
        if(numRows == 2){
            res.add(first);
            res.add(second);
            return res;
        }
        res.add(first);
        res.add(second);
        for(int i=2;i < numRows;i++){
            ArrayList<Integer> pre = res.get(i-1);
            ArrayList<Integer> tmp = new ArrayList<Integer>();
            for(int j=0;j<=i;j++){
                if(j==0||j==i)
                    tmp.add(1);
                else
                    tmp.add(pre.get(j)+pre.get(j-1));
            }
            res.add(tmp);
        }
        return res;
    }
}