public class Solution {
    public int singleNumber(int[] A){
        HashMap<Integer,Integer> map = new HashMap<Integer, Integer>();
        for(int i=0;i<A.length;i++){
            if(map.containsKey(A[i]))
                map.put(A[i],map.get(A[i])+1);
            else
                map.put(A[i],1);
        }
        for(int k : map.keySet())
            if(map.get(k) != 3)
                return k;
        return -1;
    }
}