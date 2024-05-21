#include<bits/stdc++.h>
using namespace std;

void f(int n)
{
    if(n > 9)
    {
        f(n / 10);
        cout << n % 10 << endl;
    }
    else
        cout << n << endl;
}

int main()
{
    int x;
    cin >> x;

    f(x);

    return 0;
}