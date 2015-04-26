public class Solution {
    public boolean isValidSudoku(char[][] board) {
        List<HashSet<Character>> container = new ArrayList<HashSet<Character>>();
        for(int i=0;i<27;i++){
            HashSet<Character> tmp = new HashSet<Character>();
            container.add(tmp);
        }
        for(int i=0; i<9; i++){
            for(int j=0;j<9;j++){
                char t = board[i][j];
                if(t == '.')
                    continue;
                else{
                    if(container.get(i).contains(t))
                        return false;
                    else
                        container.get(i).add(t);

                    if(container.get(9+j).contains(t))
                        return false;
                    else
                        container.get(9+j).add(t);

                    if(container.get(18+(i/3)*3+j/3).contains(t))
                        return false;
                    else
                        container.get(18+(i/3)*3+j/3).add(t);
                }
            }
        }
        return true;
    }
}