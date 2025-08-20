#include<bits/stdc++.h>
using namespace std;
const int N=1e5+10;
int q[N],cnt[N],n;

int main()
{
    cin>>n;
    for(int i=1;i<=n;i++) cin>>q[i];

    int res=0;
    for(int i=1,j=1;i<=n;i++)
    {
        cnt[q[i]]++;
        while(j<i && cnt[q[i]]>1)
        {
            cnt[q[j]]--;
            j++;
        }
        res=max(res,i-j+1);
    }
    cout<<res;
    return 0;
}