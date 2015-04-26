public class Solution {
    public int removeDuplicates(int[] A) {
        if (A.length < 2)
			return A.length;

		int i = 0, j = 1;
		while (j < A.length) {
			if (A[j] == A[i]) {
				j++;
			} else {
				A[++i] = A[j];
				j++;
			}
		}
		
		return i+1;
    }
}