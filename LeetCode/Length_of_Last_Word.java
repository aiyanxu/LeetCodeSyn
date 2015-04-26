public class Solution {
    public int lengthOfLastWord(String s) {
        String[] array = s.split(" ");
        if(array.length == 0)
			return 0;
		String last = array[array.length-1];
		return last.length();
    }
}