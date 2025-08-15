#include<bits/stdc++.h>
using namespace std;
const int N=20;
int n;
char g[N][N];//棋盘
bool col[N],dg[N],udg[N];//竖、正斜、反斜状态
int pp;
void dfs(int u)
{
    if(u==n)
    {
        for(int i=0;i<n;i++) cout<<g[i]<<endl;
        cout<<endl;
        pp++; 
        return;
    }
    //枚举列
    for(int i=0;i<n;i++)
    {
        if(!col[i] && !dg[u+i] && !udg[n-u+i])//竖、正斜、反斜都不能有皇后
        {
            g[u][i]='Q';//确定皇后
            col[i]=dg[u+i]=udg[n-u+i]=true;//标记
            dfs(u+1);//递归进入下一行
            col[i]=dg[u+i]=udg[n-u+i]=false;//恢复
            g[u][i]='.';
        }
    }
}

int main()
{
    cin>>n;
    
    for(int i=0;i<n;i++)
        for(int j=0;j<n;j++)
            g[i][j]='.';
    
    dfs(0);
    cout<<pp;
    return 0;
}
