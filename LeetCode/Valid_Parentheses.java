public class Solution {
    public boolean isValid(String s) {
        Map<Character,Character> table = new HashMap<Character,Character>();
		table.put(']', '[');
		table.put('}', '{');
		table.put(')', '(');
		Stack<Character> stack = new Stack<Character>();
		for(char c : s.toCharArray()){
			switch(c){
			case '(':
			case '{':
			case '[':
				stack.push(c);
				break;
			case ']':
			case ')':
			case '}':
				if(stack.isEmpty())
					return false;
				char top = stack.pop();
				if(top != table.get(c))
					return false;
			}
		}
		if(stack.isEmpty()){
			return true;
		}
		return false;
    }
}