public class Solution {
    public int uniquePaths(int m,int n){
        int[][] uniquePath = new int[m][n];
        for(int i=0;i<m;i++){
            uniquePath[i][0] = 1;
        }
        for(int j=0;j<n;j++){
            uniquePath[0][j] = 1;
        }
        for(int i=1;i<m;i++){
            for(int j=1;j<n;j++){
                uniquePath[i][j] = uniquePath[i][j-1] + uniquePath[i-1][j];
            }
        }
        return uniquePath[m-1][n-1];
    }
}