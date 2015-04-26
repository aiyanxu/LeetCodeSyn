public class Solution {
    public void rotate(int[][] matrix){
        for(int i=0;i<matrix.length;i++)
            for(int j=i+1;j<matrix.length;j++){
                int tmp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = tmp;
            }
        for(int i=0,j=matrix.length-1;i<j;i++,j--){
            for(int m=0;m<matrix.length;m++){
                int temp = matrix[m][i];
                matrix[m][i] = matrix[m][j];
                matrix[m][j] = temp;
            }
        }
    }
}