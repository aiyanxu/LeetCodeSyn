public class Solution {
    public int lengthOfLongestSubstring(String s) {
        if(s == null)
			return 0;
		if(s.equals(""))
		    return 0;
		if(s.length() == 1)
			return 1;
		int max_length = 1;
		int begin = 0;
		Map<Character,Integer> position = new HashMap<Character,Integer>();
		for(int current=0;current<s.length();current++){
			char c = s.charAt(current);
			if(!position.containsKey(c)){
				position.put(c, current);
			}else{
				if(position.get(c)>=begin){
					begin = position.get(c) + 1;
					position.put(c, current);
				}else{
					position.put(c, current);
				}	
			}
			if(current-begin+1 >= max_length)
				max_length = current-begin+1;
		}
		return max_length;
    }
}