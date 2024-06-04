#include<bits/stdc++.h>
using namespace std;

void displaySortedNumbers(int num1, int num2, int num3)
{
	if(num1 > num2) swap(num1, num2);
	if(num1 > num3) swap(num1, num3);
	if(num2 > num3) swap(num2, num3);
	cout << num1 << ' ' << num2 << ' ' << num3 << endl;
}

int main()
{
	int num1, num2, num3;
	cin >> num1 >> num2 >> num3;

	displaySortedNumbers(num1, num2, num3);
	
	return 0;
}