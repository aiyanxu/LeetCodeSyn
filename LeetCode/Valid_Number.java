public class Solution {
    public boolean isNumber(String s) {
        if(null==s)
            return false;
        return s.matches("^\\s*[\\+|\\-]{0,1}[0-9]*(([\\.]{0,1}[0-9]+)|([0-9]+[\\.]{0,1}))([e|E][\\+|\\-]{0,1}[0-9]+){0,1}\\s*$");
    }
}