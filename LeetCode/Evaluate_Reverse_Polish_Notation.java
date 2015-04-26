public class Solution {
    public int evalRPN(String[] tokens) {
        if(tokens == null || tokens.length == 0)
            return 0;
        Stack<Integer> stack = new Stack<Integer>();
        for(String s : tokens){
            if(s.equals("+")){
                int a = stack.pop();
                int b = stack.pop();
                stack.push(b+a);
            }
            else if(s.equals("-")){
                int a = stack.pop();
                int b = stack.pop();
                stack.push(b-a);
            }
            else if(s.equals("*")){
                int a = stack.pop();
                int b = stack.pop();
                stack.push(b*a);
            }
            else if(s.equals("/")){
                int a = stack.pop();
                int b = stack.pop();
                stack.push(b/a);
            }
            else{
                stack.push(Integer.valueOf(s));
            }
        }
        return stack.peek();
    }
}