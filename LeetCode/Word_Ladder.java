public class Solution {
    public int ladderLength(String start, String end, Set<String> dict) {
        Queue<String> words = new LinkedList<String>();
        Queue<Integer> len = new LinkedList<Integer>();
        words.add(start);
        len.add(1);
        while(!words.isEmpty()){
            String word = words.poll();
            int length = len.poll();
            if(word.equals(end))
                return length;
            for(int i=0;i<word.length();i++){
                char[] arr = word.toCharArray();
                for(char c = 'a'; c<='z'; c++){
                    if(arr[i] == c)
                        continue;
                    arr[i] = c;
                    String str = String.valueOf(arr);
                    if(dict.contains(str)){
                        words.add(str);
                        len.add(length+1);
                        dict.remove(str);
                    }
                }
            }
        }
        return 0;
    }
}