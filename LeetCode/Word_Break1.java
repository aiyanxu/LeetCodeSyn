public class Solution {
   public boolean wordBreak(String s,Set<String> dict){
        if(dict.contains(s))
            return true;
        Set<String> fail = new HashSet<String>();
        return helper(s,dict,fail);
    }
    private boolean helper(String rest,Set<String> dict,Set<String> fail){
        if(fail.contains(rest))
            return false;
        if(dict.contains(rest))
            return true;
        if("".equals(rest))
            return true;
        for(int i=1;i<=rest.length();i++){
            String subStr = rest.substring(0,i);
            if(dict.contains(subStr)){
                if(helper(rest.substring(i),dict,fail))
                    return true;
            }
        }
        fail.add(rest);
        return false;
    }
}