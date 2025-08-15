#include<bits/stdc++.h>
using namespace std;
const int N=1e6+10;
int a[N];
int n,c;
long long res;

int main()
{
    cin>>n>>c;
    for(int i=1;i<=n;i++)
    {
        scanf("%d",&a[i]);
    }

    sort(a+1,a+n+1);

    for(int i=1;i<=n;i++)
    {
        int l=1,r=n;
        while(l<r)
        {
            int mid=l+r>>1;
            if(a[mid]>=a[i]-c) r=mid;
            else l=mid+1;
        }
        if(a[l]==a[i]-c)
        {
            int ll=l;
            l=1,r=n;
            while(l<r)
            {
                int mid=l+r+1>>1;
                if(a[mid]<=a[i]-c) l=mid;
                else r=mid-1;
            }
            res+=r-ll+1;
        }
    }
    cout<<res;
    return 0;
}