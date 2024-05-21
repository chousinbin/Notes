#include<bits/stdc++.h>
using namespace std;

double m(int x)
{
	int end = 2 * x - 1;
	double sum = 0;
	
	for(int i = 1; i <= x; i ++)
		sum += pow(-1, i + 1) / (i * 2 - 1);
		
	return 4 * sum;
} 
int main()
{
	int n = 9;
	for(int i = 0; i <= n; i++)
	{
		int x = i * 100 + 1;
		double ret = m(x);
		printf("%d\t%.4f\n", x, ret);
	}
	return 0;
}
