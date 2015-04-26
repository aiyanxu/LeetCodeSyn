public class Solution {
    public int findMin(int[] num) {
        if(num.length == 1)
			return num[0];
		if((num[0] < num[1]) && (num[0] < num[num.length-1]))
			return num[0];
		if((num[num.length-1] < num[0]) && (num[num.length-1] < num[num.length-2]))
			return num[num.length-1];
		
		for(int i=1;i<=num.length-2;i++){
			if((num[i] < num[i-1]) && (num[i] < num[i+1])){
				return num[i];
			}
		}
		return -1;
    }
}