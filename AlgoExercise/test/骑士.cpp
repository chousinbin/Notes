#include<bits/stdc++.h>
using namespace std;
const int N=1e5+10;

int main()
{
    int k;
    cin>>k;
    
    int day=0;
    int sum=0;

    for(int i=1;i<=k;i++)
    {
        for(int j=1;j<=i;j++)
        {
            sum+=i;
            day++;
            if(day==k)
            {
                cout<<sum;
                return 0;
            }
        }
    }
}