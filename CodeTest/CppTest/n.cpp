#include<bits/stdc++.h>
using namespace std;
const int N=20;
int n;
char g[N][N];//����
bool col[N],dg[N],udg[N];//������б����б״̬
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
    //ö����
    for(int i=0;i<n;i++)
    {
        if(!col[i] && !dg[u+i] && !udg[n-u+i])//������б����б�������лʺ�
        {
            g[u][i]='Q';//ȷ���ʺ�
            col[i]=dg[u+i]=udg[n-u+i]=true;//���
            dfs(u+1);//�ݹ������һ��
            col[i]=dg[u+i]=udg[n-u+i]=false;//�ָ�
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
