#include<bits/stdc++.h>
using namespace std;

int reverse(int x)
{
	int res = 0;
	while(x)
	{
		res = res * 10 + x % 10;
		x /= 10;
	}
	return res;
}

bool isPalindrome(int x)
{
	return x == reverse(x);
}

int main()
{
	int x;
	while(cin >> x && x)
		cout << isPalindrome(x) << endl;
	return 0;
}
