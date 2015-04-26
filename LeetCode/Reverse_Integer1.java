public class Solution {
    public int reverse(int x) {
        int res = 0;
		List<Integer> result_list = new ArrayList<Integer>();
		//设置标志flag，x是否为负数
		boolean flag = false;
		if(x < 0){
			flag = true;
			x = Math.abs(x);
		}
		//当x为个位数
		if(0 <= x && x<10){
			if(flag){
				return -x;
			} else{
				return x;
			}
		}
		while(x >= 10){
			int mod = x % 10;
			x = x/10;
			result_list.add(mod);
		}
		result_list.add(x);
		for(int i=0; i<result_list.size(); i++){
		    if(flag){
				res += (-result_list.get(i))*(Math.pow(10, result_list.size()-1-i));
			}else{
				res += result_list.get(i)*(Math.pow(10, result_list.size()-1-i));
			}
		}
		if(res == Integer.MIN_VALUE)
		    return 0;
		else if(res == Integer.MAX_VALUE)
			return 0;
		else
			return res;
    }
}