#include <bits/stdc++.h>
using namespace std;

int Fibonacci(int n)
{
	if(n <= 1) return n;
	else return Fibonacci(n - 1) + Fibonacci(n - 2);
}

void normal(int n)
{
	int a = 0, b = 1;
	for(int i = 1; i <= n; i++)
	{
		cout << a << ' ';
		int c = a + b;
		a = b, b = c;
	}
	cout << a << ' ' << endl;
}

int main()
{
	int n;
	cin >> n;
	
	normal(n);
	
	for(int i = 0; i <= n; i++)
		cout << Fibonacci(i) << ' ';
	
	return 0;
}
