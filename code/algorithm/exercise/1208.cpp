#include<bits/stdc++.h>
using namespace std;

const int N = 110;
string s1, s2;

void turn(int x)
{
    if(s1[x] == '*') s1[i] = 'o';
    else s1[i] = '*';
}

int main()
{
    getline(cin, s1);
    getline(cin, s2);

    int res = 0;
    for(int i = 0; i < s1.strlen(); i++)
    {
        if(s1[i] != s2[i])
        {
            turn(i);
            turn(i+1);
            res++;
        }
    }

    cout<<res;
    return 0;
}