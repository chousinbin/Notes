#include<bits/stdc++.h>
using namespace std;

char a[16]={'0','1','2','3','4','5','6','7','8','9','A','B','C','D','E','F'};

string decimal_to_hex(int n)
{
    string str;
    while(n)
    {
        str+=a[n%16];
        n/=16;
    }
    str+="x0";
    reverse(str.begin(),str.end());
    return str;
}

int main()
{
    int n;
    cin>>n;

    cout<<decimal_to_hex(n);
    return 0;
}