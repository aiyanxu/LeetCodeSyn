public class Solution {
   public ArrayList<ArrayList<String>> partition(String s){
        ArrayList<ArrayList<String>> res = new ArrayList<ArrayList<String>>();
        if(s=="" || s.length()==0 || s==null)
            return res;
        ArrayList<String> item = new ArrayList<String>();
        helper(s,0,s.length()-1,item,res);
        return res;
    }

    private void helper(String s,int start,int end,ArrayList<String> item,ArrayList<ArrayList<String>> res){
        if(isEqual(s,item)){
            res.add(new ArrayList<String>(item));
            return;
        }
        for(int i=start;i<=end;i++){
            String tmp = s.substring(start,i+1);
            if(isPalindrome(tmp)){
               item.add(tmp);
                helper(s,i+1,end,item,res);
                item.remove(item.size()-1);
            }
        }
        return;
    }

    private boolean isPalindrome(String a){
        return new StringBuilder(a).reverse().toString().equals(a);
    }
    private boolean isEqual(String a, ArrayList<String> item){
        StringBuilder sb = new StringBuilder();
        for(String i : item)
            sb.append(i);
        if(sb.toString().equals(a))
            return true;
        return false;
    }
}