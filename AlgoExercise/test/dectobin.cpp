#include<bits/stdc++.h>
using namespace std;

string decimal_to_binary(int n)
{
    char a[2]={'0','1'};
    string str;
	while(n)
    {
        str+=a[n%2];
        n/=2;
    }
    reverse(str.begin(),str.end());
    return str;
}

int main()
{
    int n;
    cin>>n;
    cout<<decimal_to_binary(n);
    return 0;
}