#include<bits/stdc++.h>
using namespace std;

template<typename T>
T fun(T x, T y)
{
	return x > y ? x : y;    
}

int main()
{
    cout << fun(1, 2);
    cout << fun(1.1, 2.22);
    
    return 0;
}
