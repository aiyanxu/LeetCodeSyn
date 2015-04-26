#include <set>
using namespace std;
class Solution {
public:
    int singleNumber(int A[], int n){
      set<int> res;
      int ret;
      for(int i=0;i<n;i++){
        if (res.find(A[i]) == res.end())
          res.insert(A[i]);
        else
          res.erase(A[i]);
      }
      ret = *(res.begin());
      return ret;
    }
};