//既约分数
#include<bits/stdc++.h>
using namespace std;
//直接利用gcd函数求最大公约数 二重循环暴力求解
int gcd(int a,int b)
{
    return b?gcd(b,a%b):a;  
}

int main()
{
    int res=0;
    for(int i=1;i<=2020;i++)
    {
        for(int j=1;j<=2020;j++)
        {
            if(gcd(i,j)==1) res++;
        }
    }

    cout<<res;
    return 0;
}