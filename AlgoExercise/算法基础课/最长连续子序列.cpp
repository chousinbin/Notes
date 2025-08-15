#include<bits/stdc++.h>
using namespace std;
const int N=5e5+10,M=1e6+10;
int n,k;
int a[N],cnt[N];

int main()
{
    cin>>n>>k;
    for(int i=1;i<=n;i++) cin>>a[i];

    int res=0,l,r;
    for(int i=1,j=1,t=0;i<=n;i++)
    {
        if(cnt[a[i]]==0) t++;
        cnt[a[i]]++;

        while(t>k)
        {
            if(cnt[a[j]]==1) t--;
            cnt[a[j]]--;
            j++;
        }

        if(i-j+1>res)
        {
            res=i-j+1;
            l=j,r=i;
        }
    }
    cout<<l<<' '<<r;
    return 0;
}