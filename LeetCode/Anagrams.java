public class Solution {
    public List<String> anagrams(String[] strs) {
        List<String> res = new ArrayList<String>();
        HashMap<String,List<String>> tmp = new HashMap<String, List<String>>();
        for(String t : strs){
            char[] ch = t.toCharArray();
            Arrays.sort(ch);
            String s = String.valueOf(ch);
            if (tmp.containsKey(s))
                tmp.get(s).add(t);
            else{
                List<String> ls = new ArrayList<String>();
                ls.add(t);
                tmp.put(s,ls);
            }
        }
        Iterator iterator = tmp.values().iterator();
        while(iterator.hasNext()){
            ArrayList<String> item = (ArrayList<String>)iterator.next();
            if(item.size()>1)
                res.addAll(item);
        }
        return res;
        
    }
}