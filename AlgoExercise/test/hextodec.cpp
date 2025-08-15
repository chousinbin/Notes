#include<bits/stdc++.h>
using namespace std;

int hex_to_decimal(string str)
{
    int a=1;
    if(str[0]=='-')
    {
        a=-1;
        str=str.substr(1);
    }
    str=str.substr(2);

    int res=0;
	for(int i=0;i<str.size();i++)
    {
        int t;
        if(str[i]>='a' && str[i]<='f') t=str[i]-'a'+10;
        else if(str[i]>='A' && str[i]<='F') t=str[i]-'A'+10;
        else t=str[i]-'0';
        res=res*16+t;
    }
    return res*a;
}

int main()
{
    string str;
    cin>>str;
    cout<<hex_to_decimal(str);
    return 0;
}