#include<bits/stdc++.h>
using namespace std;
void f(int a[][20],int m,int n)
{
    int max=0,min=11;
    double sum=0,score=0,ret=0;
    for(int i=0;i<m;i++)
    {
        sum=0;
        for(int j=0;j<n;j++)
        {
            sum+=a[i][j];
            if(a[i][j]>max) max=a[i][j];
            if(a[i][j]<min) min=a[i][j];
        }
        score=(sum-max-min)/(n-2);
        if(score>ret) ret=score;
    }
    printf("%.2f",ret);
    
}
int main()
{
    int m,n,a[100][20]={0};;
    cin>>m>>n;
    for(int i=0;i<m;i++)
        {
            for(int j=0;j<n;j++)
            {
                cin>>a[i][j];
            }
        }
        f(a,m,n);
    return 0;
}
