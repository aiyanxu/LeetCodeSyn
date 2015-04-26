public class Solution {
    public int[] twoSum(int[] numbers, int target) {
        Map<Integer,Integer> tmp = new HashMap<Integer,Integer>();
		int[] result = new int[2];
		int remain = 0;
		for(int i=0; i<numbers.length; i++){
			remain = target - numbers[i];
			if(tmp.containsKey(remain)){
				result[0] = tmp.get(remain)+1;
				result[1] = i+1;
				break;
 			}else{
 				tmp.put(numbers[i], i);
 			}
		}
		return result;
    }
}