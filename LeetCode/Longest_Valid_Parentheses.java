public class Solution {
    public int longestValidParentheses(String s) {
         if (s == null || s.length() == 0)
            return 0;
        int start = -1;
        int maxLength = 0;
        Stack<Integer> stack = new Stack<Integer>();
        for (int i=0;i<s.length();i++){
            if (s.charAt(i) == '(')
                stack.push(i);
            else {
                if(!stack.empty()){
                    stack.pop();
                    if (stack.isEmpty())
                        maxLength = Math.max(i-start,maxLength);
                    else
                        maxLength = Math.max(i-stack.peek(),maxLength);
                }else
                    start = i;
            }
        }
        return maxLength;
    }
}