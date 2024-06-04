#include<bits/stdc++.h>
using namespace std;

int reverse(int number)
{
    int res = 0;
    while(number)
    {
        res = res * 10 + number % 10;
        number /= 10;
    }
    return res;
}