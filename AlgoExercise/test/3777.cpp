#include<bits/stdc++.h>
using namespace std;
const int N = 210;

int n;
string str, s;

void turn(int i)
{
    if(s[i] == 'W') s[i] = 'B';
    else s[i] = 'W';
}

bool check(char c)
{
    int q[N], k = 0;
    s = str;
    for(int i = 0; i < n - 1; i++)
    {
        if(s[i] != c)
        {
            turn(i);
            turn(i + 1);

            q[k] = i + 1;
            k++;
        }
    }

    if(s[n - 1] != c) return false;
    
    cout<<k<<endl;

    if(k > 0)
    {
        for(int i = 0; i < k; i++)
            cout<<q[i]<<' ';
        cout<<endl;
    }

    return true;
}
int main()
{
    int t;
    cin>>t;

    while(t--)
    {
        
        cin>>n>>str;
        
        if(!check('B') && !check('W'))
            cout<<-1<<endl;
    }
    return 0;
}