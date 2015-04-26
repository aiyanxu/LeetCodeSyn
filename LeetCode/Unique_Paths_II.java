public class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid){
        if(obstacleGrid[0][0] == 1)
            return 0;
        int rowLength = obstacleGrid.length;
        int columLength = obstacleGrid[0].length;
        int[][] uniquePath = new int[rowLength][columLength];
        boolean obstacle = false;
        for(int i=0;i<rowLength;i++){
            if(obstacleGrid[i][0] == 1){
                obstacle = true;
            }
            if(obstacle)
                uniquePath[i][0] = 0;
            else
                uniquePath[i][0] = 1;
        }
        obstacle = false;
        for(int j=0;j<columLength;j++){
            if(obstacleGrid[0][j] == 1){
                obstacle = true;
            }
            if(obstacle)
                uniquePath[0][j] = 0;
            else
                uniquePath[0][j] = 1;
        }
        for(int i=1;i<rowLength;i++){
            for(int j=1;j<columLength;j++){
                if(obstacleGrid[i][j] == 1)
                    uniquePath[i][j] = 0;
                else
                    uniquePath[i][j] = uniquePath[i][j-1] + uniquePath[i-1][j];
            }
        }
        return uniquePath[rowLength-1][columLength-1];
    }
}