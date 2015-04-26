public class Solution {
    public String addBinary(String a, String b) {
         int m = a.length();
        int n = b.length();
        int flag = 0;
        StringBuilder sb = new StringBuilder();
        int commonLength = m <= n? m : n;
        for(int count=0, i=a.length()-1,j=b.length()-1; count<commonLength;count++,i--,j--){
            int plus1 = Character.getNumericValue(a.charAt(i));
            int plus2 = Character.getNumericValue(b.charAt(j));
            int res = plus1 + plus2+ flag;
            if(res == 0){
                sb.append("0");
                flag = 0;
            }
            else if(res == 1){
                sb.append("1");
                flag = 0;
            }
            else if(res == 2){
                sb.append("0");
                flag = 1;
            }
            else{
                sb.append("1");
                flag = 1;
            }
        }
        if(m>n){
            for(int i=m-commonLength-1;i>=0;i--){
                int res = Character.getNumericValue(a.charAt(i))+flag;
                if(res == 0 || res == 1){
                    flag = 0;
                    sb.append(res);
                }
                if(res == 2){
                    flag =  1;
                    sb.append("0");
                }
            }
        }
        if(n>m){
            for(int i=n-commonLength-1;i>=0;i--){
                int res = Character.getNumericValue(b.charAt(i))+flag;
                if(res == 0 || res == 1){
                    flag = 0;
                    sb.append(res);
                }
                if(res == 2){
                    flag =  1;
                    sb.append("0");
                }
            }
        }
        if(flag == 1)
            sb.append(1);
        return sb.reverse().toString();
    }
}