public class Solution {
    public int longestConsecutive(int[] num){
        if(num.length == 0)
            return 0;
        HashSet<Integer> set = new HashSet<Integer>();
        for(int n : num)
            set.add(n);
        int max = 1;
        for(int n : num){
            int count = 1;
            int left = n-1;
            int right = n+1;

            while(set.contains(left)){
                count += 1;
                set.remove(left);
                left--;
            }
            while(set.contains(right)){
                count += 1;
                set.remove(right);
                right++;
            }
            max = Math.max(max,count);
        }
        return max;
    }
}