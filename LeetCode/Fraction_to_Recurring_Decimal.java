public class Solution {
   public String fractionToDecimal(int numerator,int denominator){
        if(numerator == 0)
            return "0";
        String res = "";
        if(numerator < 0 ^ denominator < 0)
            res += "-";
        long num = numerator,den = denominator;
        num = Math.abs(num);
        den = Math.abs(den);
        res += num/den;
        long r = num % den;
        if(r == 0)
            return res;
        else
            res += ".";
        HashMap<Long,Integer> map = new HashMap<Long,Integer>();
        while(r != 0){
            if(map.containsKey(r)){
                int beg = map.get(r);
                String part1 = res.substring(0,beg);
                String part2 = res.substring(beg,res.length());
                res = part1 + "(" + part2 + ")";
                return res;
            }
            map.put(r,res.length());
            r *= 10;
            res += r/den;
            r = r % den;
        }
        return res;
    }
}