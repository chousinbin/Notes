#include<bits/stdc++.h>
using namespace std;

void display(int x)
{
	double sum = 0;
	for(int i = 1; i <= x; i++)
		sum += i * 1.0 / (i + 1);
	printf("%d\t%.4f\n", x, sum);
}
int main()
{
	int n = 20;
	for(int i = 1; i <= 20; i++)
		display(i);
	return 0;
} 
