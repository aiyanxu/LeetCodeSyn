public class Solution {
    public String longestCommonPrefix(String[] strs) {
        if(strs.length == 0)
			return "";
        int min = Integer.MAX_VALUE;
		String min_str = "";
		for(String str : strs)
			if(min > str.length()){
				min = str.length();
				min_str = str;
			}
		boolean flag = true;
		for(int i=min; i>=0; i--){
			for(int j=0; j<strs.length; j++){
				if(!strs[j].substring(0,i).equals(min_str.substring(0,i))){
					flag = false;
					break;
				}else{
					flag = true;
				}
			}
			if(flag) return min_str.substring(0,i);
		}
		return "";
    }
}