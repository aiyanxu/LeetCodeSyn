public class Solution {
   public int minDistance(String word1,String word2){
        int m = word1.length();
        int n = word2.length();
        int leftCell = 0,rightCell = 0, cornerCell = 0;
        int[][] c = new int[m+1][n+1];
        for(int i=0;i<=m;i++)
            c[i][0] = i;
        for(int j=0;j<=n;j++)
            c[0][j] = j;
        for(int i=1;i<=m;i++){
            for(int j=1;j<=n;j++){
                leftCell = c[i][j-1] + 1;
                rightCell = c[i-1][j] + 1;
                cornerCell = c[i-1][j-1] + (word1.charAt(i-1)== word2.charAt(j-1)? 0 : 1);
                c[i][j] = Math.min(Math.min(leftCell,rightCell),cornerCell);
            }
        }
        return c[m][n];
   }
}