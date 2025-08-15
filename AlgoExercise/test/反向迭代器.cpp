#include<bits/stdc++.h>
using namespace std;

int main()
{
	vector<int> v = {3, 1, 2, 5, 4};
	sort(v.begin(), v.end());
	vector<int>::reverse_iterator rit;
	for(rit = v.rbegin(); rit != v.rend(); rit++)
    cout << *rit << ' ';
}
