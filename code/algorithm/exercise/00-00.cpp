#include <bits/stdc++.h>
using namespace std;
const int N = 1e5 + 10;

int st[N];
int p = -1;

int main()
{
    int n;
    cin >> n;

    while(n--)
    {
        string op;
        cin >> op;
        
        int x;
        if(op == "push")
        {
            cin >> x;
            p++;
            st[p] = x;
        }
        else if(op == "pop")
        {
            if(p >= 0) p--;
        }
        else if(op == "empty")
        {
            if(p == -1) cout << "YES" << endl;
            else cout << "NO" << endl;
        }
        else
        {
            cout << st[p] << endl;
        }
    }
}