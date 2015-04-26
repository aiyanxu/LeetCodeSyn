public class Solution {
   public boolean wordBreak(String s,Set<String> dict){
        if(dict.contains(s))
            return true;
        boolean[] res = new boolean[s.length()];
        for(int i=0;i<res.length;i++)
            res[i] = false;
        if(dict.contains(s.substring(0, 1)))
            res[0] = true;
        for(int i=1;i<s.length();i++){
            if(dict.contains(s.substring(0,i+1))){
                res[i] = true;
                continue;
            }
            for(int j=0;j<i;j++){
                if(res[j]){
                    if(dict.contains(s.substring(j+1,i+1))){
                        res[i] = true;
                        break;
                    }
                }
            }
        }
        return res[res.length-1];
    }
}