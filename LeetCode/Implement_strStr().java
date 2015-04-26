public class Solution {
    public int strStr(String haystack, String needle){
        if(needle.equals(""))
            return 0;
        int hLen = haystack.length();
        int nLen = needle.length();
        if(hLen < nLen)
            return -1;
        for(int i=0;i<hLen-nLen+1;i++){
            int tmp = i;
            for(int j = i;j<i+nLen;j++){
                char p = haystack.charAt(tmp);
                if(p != needle.charAt(j-i))
                    break;
                else{
                    if(j==i+nLen-1)
                        return i;
                    tmp++;
                }
            }
        }
        return -1;
    }
}