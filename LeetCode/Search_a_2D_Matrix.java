public class Solution {
   public boolean searchMatrix(int[][] matrix, int target){
        int rowLength = matrix.length;
        int columLength = matrix[0].length;
        int targetRow = rowLength;
        for(int i=0;i<rowLength;i++){
            if(matrix[i][columLength-1] > target){
                targetRow = i;
                break;
            }
            if(matrix[i][columLength-1] == target)
                return true;
        }
        if(targetRow == rowLength)
            return false;
        int low=0,high = columLength-1;
        while(low<=high){
            int mid = (low+high)/2;
            if(matrix[targetRow][mid] == target)
                return true;
            else if(matrix[targetRow][mid]>target){
                high = mid-1;
            }
            else
                low = mid + 1;
        }
        return false;
    }
}