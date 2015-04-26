public class Solution {
    public String reverseWords(String s) {
        String res = "";
		String[] array = s.trim().replaceAll(" +"," ").split(" ");
		for(int i=0,j=array.length-1; i< j;i++,j--){
			String tmp = array[i].trim();
			array[i] =array[j].trim();
			array[j] = tmp;
		}
		for( String str : array){
			res += str + " ";
		}
		return res.trim();
    }
}