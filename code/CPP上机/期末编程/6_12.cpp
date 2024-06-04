#include<bits/stdc++.h>
using namespace std;

double display(int x)
{
	double sum = 0;
	for(int i = 1; i <= x; i++)
		sum += i * 1.0 / (i + 1);
	return sum;
}

int main()
{
	cout << "i\tm(i)"<< endl; 
	
	for(int i = 1; i <= 20; i++)
		cout << i << "\t" << display(i) << endl;
		
	return 0;
} 
