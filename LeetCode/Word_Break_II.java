public class Solution {
    public ArrayList<String> wordBreak(String s, Set<String> dict){
        if(s.length() > 60){
            if(!canBreak(s,dict))
                return new ArrayList<String>();
        }
        ArrayList<String>[] solution = new ArrayList[s.length()];
        boolean[] res = new boolean[s.length()];
        for(int i=0;i<res.length;i++)
            res[i] = false;
        for(int i=0;i<solution.length;i++)
            solution[i] = new ArrayList<String>();
        if(dict.contains(s.substring(0, 1))) {
            res[0] = true;
            solution[0].add(s.substring(0,1));
        }
        for(int i=1;i<s.length();i++){
            if(dict.contains(s.substring(0,i+1))){
                res[i] = true;
                solution[i].add(s.substring(0, i + 1));
            }
            for(int j=0;j<i;j++){
                if(res[j]){
                    if(dict.contains(s.substring(j+1,i+1))){
                        res[i] = true;
                        for(String tmp : solution[j]){
                            solution[i].add(( tmp + " " + s.substring(j+1,i+1)).trim());
                        }
                    }
                }
            }
        }
        return solution[solution.length-1];
    }
    
    private boolean canBreak(String s,Set<String> dict){
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