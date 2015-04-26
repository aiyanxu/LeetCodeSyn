public class Solution {
    public int findPeakElement(int[] num) {
        if(num.length == 1)
			return 0;
		if(num[0] > num[1])
			return 0;
		for(int i=1; i<num.length-1;i++){
			if(num[i] > num[i-1] && num[i] > num[i+1])
				return i;
		}
		return num.length-1;
    }
}