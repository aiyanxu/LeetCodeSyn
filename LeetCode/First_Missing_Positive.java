public class Solution {
    public int firstMissingPositive(int[] A) {
        int res = 1;
		Set<Integer> tmp = new HashSet<Integer>();
		for(int i : A){
			if(i>0)
				tmp.add(i);
		}
		for(int i=1; i<Integer.MAX_VALUE;i++){
			if(!tmp.contains(i)){
				res = i;
				break;
			}
		}
		return res;
    }
}