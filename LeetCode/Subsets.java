public class Solution {
    public ArrayList<ArrayList<Integer>> subsets(int[] array){
        ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
        res.add(new ArrayList<Integer>());
        if(array == null || array.length == 0)
            return res;
        Arrays.sort(array);
        for(int i=0;i<array.length;i++){
            int size = res.size();
            for(int j=0;j<size;j++){
                ArrayList<Integer> tmp = new ArrayList<Integer>(res.get(j));
                tmp.add(array[i]);
                res.add(tmp);
            }
        }
        return res;
    }
}