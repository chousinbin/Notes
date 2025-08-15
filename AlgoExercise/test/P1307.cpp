#include<bits/stdc++.h>
using namespace std;
int main()
{
    long long n;
    int high=1;
    cin>>n;
    if(n<0) n=0-n,cout<<'-';
    if(n==0) {
        cout<<0;
        return 0;
    }
    while(n){
        if(n%10==0) high=1;
        if(high==1 && n%10==0) high=1;

        else high=0,cout<<n%10;
        n/=10;
    }

    return 0;
}
