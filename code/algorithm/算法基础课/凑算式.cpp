#include<bits/stdc++.h>
using namespace std;
int res;
const int N=10;
int num[N];
bool st[N];

int get(int x,int y)
{
    int res=0;
    for(int i=x;i<=y;i++)
    {
        res=res*10+num[i];
    }
    return res;
}

void dfs(int u)
{
    if(u>9)
    {
        int a=get(1,3),b=get(4,6),c=get(7,9);
        if(a+b==c) res++;
        return;
    }

    for(int i=1;i<=9;i++)
    {
        if(!st[i])
        {
            num[u]=i;
            st[i]=true;
            dfs(u+1);
            st[i]=false;
        }
    }
}

int main()
{
    dfs(1);
    cout<<res;
    return 0;
}