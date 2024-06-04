#include<bits/stdc++.h>
using namespace std;

double m(int x)
{
	double sum = 0;
	
	for(int i = 1; i <= x; i ++)
		sum += pow(-1, i + 1) / (i * 2 - 1);
		
	return 4 * sum;
} 

int main()
{
	cout << "i\tm(i)" << endl;
	
	int n = 9;
	for(int i = 0; i <= n; i++)
	{
		int x = i * 100 + 1;
		cout << x << "\t" << m(x) << endl;
	}
	
	return 0;
}
