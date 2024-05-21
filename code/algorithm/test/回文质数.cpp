#include<bits/stdc++.h>
using namespace std;
bool f1(unsigned long long n)//质数
{
    for(int i=2;i*i<n;i++)
        if(n%i==0) return false;
    return true;
}
bool f2(unsigned long long n)//位数
{
    if(n>=10 && n<=100 && n!=11 || n>=1000 && n<=10000) return false;
    if(n>=100000 && n<=1000000 || n>=10000000 && n<=100000000) return false;
    return true;
}
bool f3(unsigned long long n)//回文数
{
    int a[10],i=0;
    while(n>0){a[i]=n%10;n/=10;i++;}
    for(int j=0;j<i;j++) if(a[j]!=a[i-j-1]) return false;
    return true;
}
unsigned long long y[100000];
int main()
{
    unsigned long long a,b,q=0;
    scanf("%lld %lld",&a,&b);
    for(unsigned long long i=a;i<=b;i++)
    {
        if(f3(i) && f2(i))
        {
            y[q++]=i;
        }
    }
    return 0;
}