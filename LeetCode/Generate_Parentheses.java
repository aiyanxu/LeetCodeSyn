public class Solution {
    public ArrayList<String> generateParenthesis(int n){
        ArrayList<String> result = new ArrayList<String>();
        generate(0,0,"",n,result);
        return result;
    }

    private void generate(int left,int right,String s,int n,ArrayList<String> res){
        if (left < right){
            return;
        }
        if(left == n && right == n){
            res.add(s);
            return;
        }
        if(left == n){
            generate(left,right+1,s+")",n,res);
            return;
        }
        generate(left+1,right,s+"(",n,res);
        generate(left,right+1,s+")",n,res);
    }
}