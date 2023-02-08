#include<iostream>
#include<cstdio>
using namespace std;
int main()
{
	int n;
	double sum=0;
	cin>>n;
	if(n>400) sum=(n-400)*.5663,n-=(n-400);
	if(n>150&&n<=400) sum+=(n-150)*.4663,n-=(n-150);
	if(n<=150) sum+=n*.4463;
	printf("%.1f",sum);
	return 0;
}
