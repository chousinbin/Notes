class Solution {
public:
    vector<vector<int>> groupThePeople(vector<int>& groupSizes) {
        vector<vector<int>> a;
        
        int res=0;  //记录当前最大开的组数
        for(int i=0;i<groupSizes.size();i++)
        {
            bool st=false;
            for(int j=0;j<=res;j++)
            {
                if(a[j].size()<groupSizes[i])
                {
                    a[j].push_back(i);
                    st=true;
                    break;
                }
            }
            if(st==false)  //在以上开好的组内都没找到自己的位置 开新组存自己
            {
                res++;
                a[res].push_back(i);
            }
        }
        return a;
    }
};