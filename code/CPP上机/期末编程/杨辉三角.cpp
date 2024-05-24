#include<bits/stdc++.h>
using namespace std;
const int N = 100;
int a[N][N];

void yh(int n)
{
	for(int i = 1; i <= n; i++)
		a[i][1] = a[i][i] = 1;
		
	for(int i = 2; i <= n; i++)
		for(int j = 2; j <= i - 1; j++)
			a[i][j] = a[i - 1][j] + a[i - 1][j - 1];
			
	for(int i = 1; i <= n; i++)
	{
		int px = n - i >> 1;
		for(int i = 0; i < px; i++) cout <<"    ";
		for(int j = 1; j <= i; j++)
			printf("%4d ", a[i][j]);
		cout << endl;
	}
}
int main()
{
	int n;
	cin >> n;
	yh(n); 
}
