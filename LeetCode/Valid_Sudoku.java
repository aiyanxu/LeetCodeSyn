public class Solution {
       public boolean isValidSudoku(char[][] board){
        if(board == null || board.length != 9)
            return false;
        for(int i=0;i<9;i++){
            for(int j=0;j<9;j++){
                if(board[i][j] == '.')
                    continue;
                else{
                    for (int k = 0; k < 9; k++) {
                        if (k != j && board[i][j] == board[i][k])
                            return false;
                    }
                    for (int k = 0; k < 9; k++) {
                        if (k != i && board[i][j] == board[k][j])
                            return false;
                    }
                    for (int row = i / 3 * 3; row < i / 3 * 3 + 3; row++) {
                        for (int col = j / 3 * 3; col < j / 3 * 3 + 3; col++) {
                            if ((row != i || col != j) && board[row][col] == board[i][j])
                                return false;
                        }
                    }
                }
            }
        }
        return true;
    }
}