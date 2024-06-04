#include<bits/stdc++.h>
using namespace std;

void reverse(const int list[], int newList[], int SIZE)
{
	for(int i = 0; i < SIZE; i++)
	{
		newList[i] = list[SIZE - i - 1];
	}
}

void printArray(int list[], int SIZE)
{
	for(int i = 0; i < SIZE; i++)
		cout << list[i] << ' ';
}

int main()
{
	const int SIZE = 6;
	int list[] = {1, 2, 3, 4, 5, 6};
	int newList[SIZE];
	
	reverse(list, newList, SIZE);
	
	printArray(list, SIZE);
	
	cout << endl;
	
	printArray(newList, SIZE);
	
	return 0;
}
