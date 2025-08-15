#include<iostream>
using namespace std;
int main()
{
	long s,v,h,m,tim;
	cin>>s>>v;
	if(s%v)
	{
		tim=11+s/v;
	}else{
		tim=10+s/v;
	}
	h=tim/60;
	m=tim%60;
	h-=7;
	m=60-m;
	if(h<0){
		h+=24;
	}
	if(h<10){
		cout<<"0"<<h<<":";
	}else{
		cout<<h<<":";
	}
	if(m==60){
		cout<<"00";
	}else if(m<10){
		cout<<"0"<<m<<endl;
	}else{
		cout<<m<<endl;
	}
	return 0;
}
