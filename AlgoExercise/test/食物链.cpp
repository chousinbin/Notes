

#include<bits/stdc++.h>
using namespace std;
const int N=5e5+10;
int p[N],d[N];
int n,m;

int find(int x)
{
    if(x!=p[x])
    {
        int t=find(p[x]);
        d[x]+=d[p[x]];
        p[x]=t;
    }
    return p[x];
}

int main()
{
    scanf("%d%d",&n,&m);
    for(int i=1;i<=n;i++) p[i]=i;
    int res=0;
    while(m--)
    {
        int t,x,y;
        scanf("%d%d%d",&t,&x,&y);
        if(x>n || y>n) res++;
        else
        {
            int px=find(x),py=find(y);
            if(t==1)
            {
                //属于同一棵树 %3！=0 不是同一类 假话
                if(px==py && ( d[x] - d[y] ) %3 != 0) res++;
                else if(px != py)//非同一棵树
                {
                    p[px]=py;//把x树 合并到y的祖宗下(py)
                    d[px]=d[y]-d[x]; //px到py距离=y到py的距离-x到px的距离
                }
            }
            else
            {    //(d[x]-d[y])%3==1 x吃y 
                if(px==py && ( d[x] - d[y] -1 ) %3 != 0) res++;//吃不了 假话
                else if(px != py)
                {
                    p[px]=py;//合并
                    d[px]=d[y]+1-d[x];//?
                }
            }
        }
    }
    printf("%d\n",res);
    return 0;
}