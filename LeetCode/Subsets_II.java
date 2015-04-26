public class Solution {
    public ArrayList<ArrayList<Integer>> subsetsWithDup(int[] array){
        ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
        res.add(new ArrayList<Integer>());
        if(array == null || array.length == 0)
            return res;
        Arrays.sort(array);
        int start = 0;
        for(int i=0;i<array.length;i++){
            int size = res.size();
            for(int j=start;j<size;j++){
                ArrayList<Integer> tmp = new ArrayList<Integer>(res.get(j));
                tmp.add(array[i]);
                res.add(tmp);
            }
            if(i<array.length-1 && array[i] == array[i+1])
                start = size;
            else
                start = 0;
        }
        return res;
    }
}