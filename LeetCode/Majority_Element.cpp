#include<vector>
#include<map>
using namespace std;

class Solution {
public:
    int majorityElement(vector<int> &num) {
        map<int,int> m;
        for(int i=0;i<num.size();i++){
            if(m.find(num.at(i)) == m.end())
                m[num.at(i)] = 1;
            else
                m[num.at(i)] += 1;
            if(m[num.at(i)] > num.size() / 2)
                return num.at(i);
        }
        return 0;
    }
};