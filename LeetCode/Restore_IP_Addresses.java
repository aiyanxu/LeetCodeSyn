public class Solution {
    public ArrayList<String> restoreIpAddresses(String s){
        return restore(new int[0],s);
    }

    private ArrayList<String> restore(int[] tokens,String rest){
        ArrayList<String> total = new ArrayList<String>();
        if(tokens.length == 4){
            if("".equals(rest)){
                String ip = "";
                for(int i=0;i<4;i++){
                    if(!"".equals(ip))
                        ip += '.';
                    ip += String.valueOf(tokens[i]);
                }
                total.add(ip);
            }
            return total;
        }

        for(int i=1;i<=3 && i<=rest.length();i++){
            String subStr = rest.substring(0,i);
            int sub = Integer.parseInt(subStr);
            if((subStr.startsWith("0") && i>1) || sub > 255)
                break;
            int[] ts = new int[tokens.length+1];
            System.arraycopy(tokens,0,ts,0,tokens.length);
            ts[tokens.length] = sub;
            total.addAll(restore(ts,rest.substring(i)));
        }
        return total;
    }
}