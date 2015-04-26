public class Solution {
    public ArrayList<ArrayList<Integer>> threeSum(int[] num){
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        List<Integer> myList = new ArrayList<Integer>();
        HashMap<Integer,Integer> tmp = new HashMap<Integer, Integer>();
        for(int i : num){
            if (tmp.containsKey(i)) {
                tmp.put(i, tmp.get(i) + 1);
                if(tmp.get(i) <= 2)
                    myList.add(i);
            }
            else {
                tmp.put(i, 1);
                myList.add(i);
            }
        }
        int[] myNum = new int[myList.size()];
        for(int i=0;i<myNum.length;i++)
            myNum[i] = myList.get(i);
        Arrays.sort(myNum);
        if(tmp.containsKey(0) && tmp.get(0) >= 3){
            ArrayList<Integer> fin = new ArrayList<Integer>();
            fin.add(0);
            fin.add(0);
            fin.add(0);
            result.add(fin);
        }

        for(int i=0;i<myNum.length-2;i++){
            if(i>0 && myNum[i-1] == myNum[i])
                continue;
            for(int j=i+1;j<myNum.length-1;j++){
                if(myNum[j-1] == myNum[j] && j-1 != i)
                    continue;
                int res = 0 - myNum[i] - myNum[j];
                if(res < myNum[j])
                    break;
                else if(res == myNum[j]){
                    if(res != 0 && tmp.get(res) >= 2){
                        ArrayList<Integer> fin = new ArrayList<Integer>();
                        fin.add(myNum[i]);
                        fin.add(myNum[j]);
                        fin.add(res);
                        result.add(fin);
                        tmp.put(res,1);
                    }
                }
                else{
                    if(tmp.containsKey(res)){
                        ArrayList<Integer> fin = new ArrayList<Integer>();
                        fin.add(myNum[i]);
                        fin.add(myNum[j]);
                        fin.add(res);
                        result.add(fin);
                    }
                }
            }
            
        }
        return result;
    }
}