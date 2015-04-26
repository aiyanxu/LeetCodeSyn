public class Solution {
    public int titleToNumber(String s){
        byte[] arr = s.toUpperCase().getBytes();
        int result = 0;
        for(int i=0;i<arr.length;i++){
            int tmp = arr[i] - 64;
            result += tmp * Math.pow(26,arr.length-1-i);
        }
        return result;
    }
}