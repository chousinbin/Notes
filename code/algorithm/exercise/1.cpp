#include<iostream>
using namespace std;
int main()
{
	char q;
	int nums=0,chars=0;
	while(cin>>q)
	{
		if(q>='0'&&q<'9') nums++;
		else if(q>='a'&&q<='z') chars++;
		else if(q>='A'&&q<='Z') chars++;
	}
	cout<<nums<<chars; 
	return 0;
}
