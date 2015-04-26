public class Solution {
    public int compareVersion(String version1, String version2) {
        String[] tmp1 = version1.split("\\.");
        String[] tmp2 = version2.split("\\.");
        int commonLength = tmp1.length < tmp2.length ? tmp1.length : tmp2.length;
        for(int i=0;i<commonLength;i++){
            int a = Integer.parseInt(tmp1[i]);
            int b = Integer.parseInt(tmp2[i]);
            if(a < b)
                return -1;
            else if(a>b)
                return 1;
            else
                continue;
        }
        if(tmp1.length > tmp2.length){
            for(int i=commonLength;i<tmp1.length;i++){
                if(Integer.parseInt(tmp1[i]) != 0)
                    return 1;
            }
        }
        if (tmp1.length < tmp2.length){
                for(int i=commonLength;i<tmp2.length;i++){
                    if(Integer.parseInt(tmp2[i]) != 0)
                        return -1;
                }
        }

        return 0;
    }
}