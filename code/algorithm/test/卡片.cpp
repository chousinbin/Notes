#include<bits/stdc++.h>
using namespace std;
const int N=2100;
int a[N];

bool f(int x)
{
    while(x>0)
    {
        if(a[x%10]<1) return false;
        a[x%10]--;
        x/=10;
    }
    return true;
}

int main()
{
    for(int i=0;i<=9;i++)
    {
        a[i]=2021;
    }

    int res=0;
    int cnt=0;

    while(f(++res)==true)
    {
        cnt++;
    }

    cout<<cnt;
    return 0;
}