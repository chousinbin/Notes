#include<bits/stdc++.h>
using namespace std;
const int N=1010,INF=0x3f3f3f3f;
int n,m,p[N],q;
int x[N],y[N],l[N][N];

struct Edge
{
    int a,b;
    double w;
}edges[N];
bool cmp(Edge x,Edge y)
{
    return x.w<y.w;
}
int find(int x)
{
    if(x!=p[x]) p[x]=find(p[x]);
    return p[x];
}
double kruskal()
{
    sort(edges,edges+m,cmp);
    for(int i=1;i<=n;i++) p[i]=i;
    double res=0;
    for(int i=1;i<=m;i++)
    {
        int a=edges[i].a,b=edges[i].b;
        double w=edges[i].w;
        if(find(a)!=find(b))
        {
            p[find(a)]=find(b);
            res+=w;
        }
    }
    return res;
}

int main()
{
    cin>>n>>m;
    for(int i=1;i<=n;i++)
    {
        cin>>x[i]>>y[i];
        for(int j=1;j<i;j++)
        {
            double d=sqrt((x[i]-x[j])*(x[i]-x[j])+(y[i]-y[j])*y[i]-y[j]);
            edges[++q]={i,j,d};
            l[i][j]=q;
        }
    }
    for(int i=1;i<=m;i++)
    {
        int a,b;
        cin>>a>>b;
        edges[l[a][b]].w=0.0;
        edges[l[b][a]].w=0.0;
    }
    double t=kruskal();
    printf("%.2f",t);
    return 0;
}
