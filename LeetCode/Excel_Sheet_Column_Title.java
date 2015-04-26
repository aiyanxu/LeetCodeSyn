public class Solution {
    public String convertToTitle(int n) {
        List<Integer> tmplist = new ArrayList<Integer>();
        HashMap<Integer,String> transform = new HashMap<Integer, String>();
        transform.put(1,"A");
        transform.put(2,"B");
        transform.put(3,"C");
        transform.put(4,"D");
        transform.put(5,"E");
        transform.put(6,"F");
        transform.put(7,"G");
        transform.put(8,"H");
        transform.put(9,"I");
        transform.put(10,"J");
        transform.put(11,"K");
        transform.put(12,"L");
        transform.put(13,"M");
        transform.put(14,"N");
        transform.put(15,"O");
        transform.put(16,"P");
        transform.put(17,"Q");
         transform.put(18,"R");
        transform.put(19,"S");
        transform.put(20,"T");
        transform.put(21,"U");
        transform.put(22,"V");
        transform.put(23,"W");
        transform.put(24,"X");
        transform.put(25,"Y");
        transform.put(0,"Z");


        while(n != 0){
            int last = n % 26;
            tmplist.add(last);
            if(last == 0)
                n -= 26;
            n = n / 26;
        }

        StringBuilder sb = new StringBuilder();
        for(int i=tmplist.size()-1;i>=0;i--){
            sb.append(transform.get(tmplist.get(i)));
        }

        return sb.toString();
    }
}