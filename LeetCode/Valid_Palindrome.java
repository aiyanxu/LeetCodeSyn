public class Solution {
    public boolean isPalindrome(String s) {
        if(s == null)
			return false;
		if(s.equals(""))
			return true;
		String tmp = s.replaceAll("[^\\w\\d]", "").toLowerCase();
		for(int i=0,j=tmp.length()-1;i<j;i++,j--){
			char a = tmp.charAt(i);
			char b = tmp.charAt(j);
			if(a == b)
				continue;
			else
				return false;
		}
		return true;
    }
}