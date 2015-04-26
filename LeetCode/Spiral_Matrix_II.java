public class Solution {
    public int[][] generateMatrix(int n) {
        int[][] matrix = new int[n][n];
        int row = n;
        int col = n;

        int x=0;
        int y=0;
        int count = 0;

        while(row>0&&col>0){
            if(row == 1){
                for(int i=0;i<col;i++)
                    matrix[x][y++] = ++count;
                break;
            }

            for (int i=0;i<col-1;i++)
                matrix[x][y++] = ++count;

            for (int i=0;i<row-1;i++)
                matrix[x++][y] = ++count;

            for (int i=0;i<col-1;i++)
                matrix[x][y--] = ++count;

            for (int i=0;i<row-1;i++)
                matrix[x--][y] = ++count;

            x++;
            y++;
            row -= 2;
            col -= 2;
        }
        return matrix;
    }
}