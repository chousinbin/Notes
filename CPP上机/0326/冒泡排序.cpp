#include <bits/stdc++.h>
using namespace std;

const int N = 1e5 + 10;
int n;
double a[N];

void bubble_sort(double a[], int n)
{
    for(int i = 0; i < n; i++)
    {
        for(int j = 0; j + 1 < n - i; j++)
        {
            if(a[j] > a[j + 1]) 
                swap(a[j], a[j + 1]);
        }
    }
}
int main()
{
    cin >> n;
    for(int i = 0; i < n; i++) 
        cin >> a[i];

    bubble_sort(a, n);

    for(int i = 0; i < n; i++)
        cout << a[i] << ' ';

    return 0;
}