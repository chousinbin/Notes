#include<bits/stdc++.h>
using namespace std;

double computeCommission(int x)
{
	if(x <= 5000) return x * 0.08;
	else if(x <= 10000) return 5000 * 0.08 + (x - 5000) * 0.1;
	else return 5000 * 0.08 + 5000 * 0.1 + (x - 10000) * 0.12;
}

int main()
{
	cout << "Sale Amout\tCommission" << endl;
	for(int i = 10000; i <= 100000; i += 5000)
		cout << i << "\t\t" << computeCommission(i) << endl;

	return 0;
}
