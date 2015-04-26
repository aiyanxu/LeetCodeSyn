public class Solution {
   public int numTrees(int n){
        if(n<2)
            return 1;
        int[] array = new int[n+1];
        for(int i=0;i<array.length;i++)
            array[i] = 0;
        array[0] = 1;
        array[1] = 1;
        for(int i=2;i<=n;i++){
            for(int j=0;j<i;j++)
                array[i] += array[j]*array[i-j-1];
        }
        return array[n];
   }
}