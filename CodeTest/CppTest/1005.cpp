#include<bits/stdc++.h>
using namespace std;
int a[100000];//���һ��
int b[120];//��������һ���� 
bool cmp(int a,int b)
{
	return a>b;
}
int main()
{
	int n,k;
	cin>>k;
	for(int i=0;i<k;i++)
	{
		cin>>n;
		b[i]=n;
		while(n!=1)
		{
			if(n%2==0) n/=2;
			else n=3*n+1;
			a[n]=1;//����ԭ������ ֻҪ���־ͱ��һ�� 
		}
	}
	
	sort(b,b+k,cmp);
	int ret=1;
	for(int i=0;i<k;i++)
	{
		if(a[b[i]]==0) //���������� û���ֹ� �ǹؼ��� 
		{
			if(ret==0) cout<<' '; 
			cout<<b[i];
			ret=0;
		}
	}
	return 0;
} 
