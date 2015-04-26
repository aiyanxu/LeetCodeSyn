public class Solution {
    public int singleNumber(int[] A) {
        HashSet<Integer> tmp = new HashSet<Integer>();
        for(int i=0;i<A.length;i++){
            if(tmp.contains(A[i]))
                tmp.remove(A[i]);
            else
                tmp.add(A[i]);
        }
        return (Integer)(tmp.toArray()[0]);
    }
}