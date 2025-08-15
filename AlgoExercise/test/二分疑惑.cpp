#include<bits/stdc++.h>
using namespace std;
const int N=1e5+10;
int h[N],w[N];
int n,k;
bool check(int d)
{
    int res=0;
    for(int i=0;i<n;i++)
    {
        res+=(h[i]/d)*(w[i]/d);
    }
    if(res<k) return false;  //个数不够 边长长了
    else return true;   //个数多了或正好 边长短了
}
int main()
{
    cin>>n>>k;

    for(int i=0;i<n;i++)
    {
        cin>>h[i]>>w[i];
    }

    int l=1,r=1e5;
    while(l<r)
    {
        int mid=l+r+1>>1;
        if(check(mid)) l=mid;
        else r=mid-1;
    }

    cout<<l;
    return 0;
}