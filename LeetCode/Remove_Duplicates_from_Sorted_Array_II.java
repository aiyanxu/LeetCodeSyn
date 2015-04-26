public class Solution {
    public int removeDuplicates(int[] A){
        if(A.length < 3)
            return A.length;
        int i=0, j=1,count = 1;
        while(j<A.length){
            if(A[j] == A[i]){
                count += 1;
                if(count < 3){
                    A[++i] = A[j];
                    j++;
                }else{
                    while(j<A.length && A[j] == A[i])
                        j++;
                    if(j<A.length) {
                        A[++i] = A[j];
                        count = 1;
                        j++;
                    }else{
                        break;
                    }
                }
            }else{
                count = 1;
                A[++i] = A[j];
                j++;
            }
        }
        return i+1;
    }
}