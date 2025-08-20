#include<bits/stdc++.h>
using namespace std;
const int N=510;
int n,m;
int g[N][N];//因为边数非常多 所以邻接矩阵
int d[N];//表示每个结点到1的距离
bool st[N];//状态
int dijkstra()
{
    //把距离初始化为最大值
    memset(d,0x3f,sizeof d);
    d[1]=0;
    //迭代n此 每次可以确定一个点到起点的最短距离
    for(int i=0;i<n;i++)
    {
        int t=-1;
        for(int j=1;j<=n;j++)
            //如果结点j没有被确定为最短路径 
            //并且
            //没有进行过更新或者发现更短路径
            //进行更新
            if(!st[j] && (t==-1 || d[t]>d[j]))
                t=j;
        //如果找到了就break
        if(t==n) break;
        //t结点已确定
        st[t]=true;
        //因为找到了距离最小的结点t 
        //用t更新其他的结点到起点的最短距离
        for(int j=1;j<=n;j++)
            d[j]=min(d[j],d[t]+g[t][j]);
    }
    if(d[n]==0x3f3f3f3f) return -1;
    else return d[n];
}
int main()
{
    cin>>n>>m;
    //因为可能有多条重边 ①和②的组合操作 只保留最短的边
    memset(g,0x3f,sizeof g);//①
    while(m--)
    {
        int a,b,c;
        cin>>a>>b>>c;
        g[a][b]=min(g[a][b],c);//②
    }
    cout<<dijkstra();
    return 0;
}

