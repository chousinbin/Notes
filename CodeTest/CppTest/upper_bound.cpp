#include<bits/stdc++.h>
using namespace std;
int main()
{
	int a[]={5,8,4};
	int t = upper_bound(a,a+3,8)-a;
	//����ָ����� ���±�
	//���������Ƿ�Χ ����Ҫ�ҵ�ֵ
	//upper_bound ���ص�ַ 
	cout << a[t];//�������8 
	return 0;
} 
