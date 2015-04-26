public class Solution {
     public String largestNumber(int[] num){
        Integer[] tmp = new Integer[num.length];
        int i = 0;
        for(int val : num)
            tmp[i++] = Integer.valueOf(val);
        Arrays.sort(tmp,new Comparator<Integer>(){
            public int compare(Integer o1, Integer o2){
                return (Integer.toString(o2) + Integer.toString(o1)).compareTo(Integer.toString(o1)+Integer.toString(o2));
            }
        });
        StringBuilder sb = new StringBuilder();
        for (int val : tmp)
            sb.append(Integer.toString(val));
        String res =  sb.toString().replaceAll("^0+","");
        if (res.equals(""))
            return "0";
        else
            return res;
    }
}