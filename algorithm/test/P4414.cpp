#include<bits/stdc++.h>
using namespace std;
int main()
{
	int a,b,c;
	char std;
	cin>>a>>b>>c;
	if(a>b) swap(a,b);
	if(a>c) swap(a,c);
	if(b>c) swap(b,c);
	
	for(int i=0;i<3;i++)
	{
		cin>>std;
		if(std=='A') cout<<a<<' ';
		if(std=='B') cout<<b<<' ';
		if(std=='C') cout<<c<<' ';
	}
	return 0;
}
