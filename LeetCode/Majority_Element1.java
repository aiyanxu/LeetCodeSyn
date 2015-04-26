public class Solution {
    public int majorityElement(int[] num) {
        int threshold = num.length / 2;
		HashMap<Integer,Integer> tmp = new HashMap<Integer,Integer>();
		for(int i : num){
			if(tmp.containsKey(i))
				tmp.put(i, tmp.get(i)+1);
			else
				tmp.put(i, 1);
			if(tmp.get(i) > threshold)
				return i;
		}
		return -1;
    }
}