public class Solution {
    public int minPathSum(int[][] grid){
        int rowLength = grid.length;
        int columLength = grid[0].length;
        int[][] sumArray = new int[rowLength][columLength];
        for(int i=0;i<rowLength;i++)
            for(int j=0;j<columLength;j++)
                sumArray[i][j] = 0;
        sumArray[0][0] = grid[0][0];
        for(int i=1;i<columLength;i++)
            sumArray[0][i] = sumArray[0][i-1] + grid[0][i];
        for(int j=1;j<rowLength;j++)
            sumArray[j][0] = sumArray[j-1][0] + grid[j][0];
        for(int i=1;i<rowLength;i++){
            for(int j=1;j<columLength;j++){
                sumArray[i][j] = Math.min(sumArray[i-1][j],sumArray[i][j-1]) + grid[i][j];
            }
        }
        return sumArray[rowLength-1][columLength-1];
    }
}