public class Solution {
    public void merge(int A[], int m, int B[], int n) {
        if(n==0)
            return;
        if(m==0){
            for(int i=0;i<n;i++)
				A[i] = B[i];
            return;
        }
        int length = m + n;
		while(m != 0&&n != 0){
			if(A[m-1]>=B[n-1]){
				A[length-1] = A[m-1];
				m--;
			}else{
				A[length-1] = B[n-1];
				n--;
			}
			length--;
		}
		while(m!=0){
			A[length-1] = A[m-1];
			length--;
			m--;
		}
		while(n!=0){
			A[length-1] = B[n-1];
			n--;
			length--;
		}
    }
}