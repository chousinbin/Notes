#include<bits/stdc++.h>
using namespace std;

int binary_to_decimal(string str)
{
    int res=0;
   for(int i=0;i<str.size();i++)
   {
       res=res*2+(str[i]-'0');
   }
    return res;
}

int main()
{
    string str;
    cin>>str;
    cout<<binary_to_decimal(str);
    return 0;
}