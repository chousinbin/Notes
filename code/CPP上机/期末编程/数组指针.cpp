#include<iostream>
using namespace std;

int main()
{
	int a[5] = {1, 2, 3, 4, 5};
	*(a + 2) = 99;
	int *p = &a[0];

	cout << *p << endl;

	for(int i = 0; i < 5; i++)
		cout << a[i] << ' ';
}
