#include<bits/stdc++.h>
using namespace std;
int n,q[6];
int f(string s)
{
	if(s=="one"||s=="first"||s=="a"||s=="another") {q[n++]=1;return 0;}
	if(s=="two"||s=="secod"||s=="both") {q[n++]=4;return 0;}
	if(s=="three"||s=="third") {q[n++]=9;return 0;}
	if(s=="four") {q[n++]=16;return 0;}
	if(s=="five") {q[n++]=25;return 0;}
	if(s=="six") {q[n++]=36;return 0;}
	if(s=="seven") {q[n++]=49;return 0;}
	if(s=="eight") {q[n++]=64;return 0;}
	if(s=="nine") {q[n++]=81;return 0;}
	if(s=="ten") {q[n++]=0;return 0;}
	if(s=="eleven") {q[n++]=21;return 0;}
	if(s=="twelve") {q[n++]=44;return 0;}
	if(s=="thirteen") {q[n++]=69;return 0;}
	if(s=="fourteen") {q[n++]=96;return 0;}
	if(s=="fifteen") {q[n++]=25;return 0;}
	if(s=="sixteen") {q[n++]=56;return 0;}
	if(s=="seventeen") {q[n++]=89;return 0;}
	if(s=="eighteen") {q[n++]=24;return 0;}
	if(s=="nineteen") {q[n++]=61;return 0;}
	if(s=="twenty") {q[n++]=0;return 0;}
	return 0;
}
void quick_sort(int q[],int l,int r)
{
	if(l>=r) return;
	int x=q[(l+r)/2],i=l-1,j=r+1;
	while(i<j)
	{
		do i++;while(q[i]<x);
		do j--;while(q[j]>x);
		if(i<j) swap(q[i],q[j]);
	}
	quick_sort(q,l,j);
	quick_sort(q,j+1,r);
}
int main()
{
	string s[6];
	for(int i=0;i<6;i++)
    {
        cin>>s[i];
        f(s[i]);
    }
	quick_sort(q,0,n-1);
	for(int i=0;i<6;i++) if(q[i]) cout<<q[i];
	if(n==0) cout<<0;
	return 0;
}
