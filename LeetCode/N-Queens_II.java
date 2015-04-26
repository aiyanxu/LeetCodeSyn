public class Solution {
    public int totalNQueens(int n) {
        int[] res = {0};
        helper(n,0,new int[n], res);
        return res[0];
    }
    private void helper(int n, int row, int[] columnForRow, int [] res)
{
    if(row == n){
        res[0] += 1;
        return;
    }
    for(int i=0;i<n;i++)
    {
        columnForRow[row] = i;
        if(check(row,columnForRow))
        {
            helper(n,row+1,columnForRow,res);
        }
    }
}
private boolean check(int row, int[] columnForRow)
{
    for(int i=0;i<row;i++)
    {
        if(columnForRow[row]==columnForRow[i] || Math.abs(columnForRow[row]-columnForRow[i])==row-i)
            return false;
    }
    return true;
}
}