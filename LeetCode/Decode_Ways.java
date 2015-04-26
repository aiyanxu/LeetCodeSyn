public class Solution {
     public int numDecodings(String s) {
        if (s.equals("") || s==null)
            return 0;
        int[] res = new int[s.length()];
        String first = s.substring(0,1);
        if(first.equals("0"))
            return 0;
        else
            res[0] = 1;
        for(int i=1;i<s.length();i++){
            if(i==1){
                if (Integer.valueOf(s.substring(i,i+1)) != 0){
                    if (Integer.valueOf(s.substring(i-1,i+1)) <= 26)
                        res[1] = 2;
                    else
                        res[1] = 1;
                }
                else{
                    if (Integer.valueOf(s.substring(i-1,i+1)) <= 26)
                        res[1] = 1;
                    else
                        return 0;
                }
                continue;
            }
            String current = s.substring(i,i+1);
            String combine = s.substring(i-1,i+1);
            String previous = s.substring(i-1,i);
            if(Integer.valueOf(current) == 0){
                if (Integer.valueOf(previous) == 0)
                    return 0;
                else{
                    if(Integer.valueOf(combine) > 26)
                        return 0;
                    else
                        res[i] = res[i-2];
                }
            }else{
                if (Integer.valueOf(previous) == 0)
                    res[i] = res[i-1];
                else {
                    if (Integer.valueOf(combine) <= 26) {
                        res[i] = res[i - 1] + res[i - 2];
                    } else {
                        res[i] = res[i - 1];
                    }
                }
            }
        }
        return res[res.length-1];
    }
}