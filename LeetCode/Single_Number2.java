public class Solution {
    public int singleNumber(int[] A) {
        int res = 0;
		Map<Integer,Integer> tmp = new HashMap<Integer,Integer>();
		
		for(int i=0; i<A.length; i++){
			if(!tmp.containsKey(A[i]))
				tmp.put(A[i], 1);
			else
				tmp.put(A[i], tmp.get(A[i])+1);
		}
		
		for(int key : tmp.keySet()){
			if(tmp.get(key) == 1)
				res = key;
		}
		return res;
    }
}