#include<bits/stdc++.h>
using namespace std;
int main()
{
	int a[]={5,8,4};
	int t = upper_bound(a,a+3,8)-a;
	//两个指针相减 得下标
	//括号里先是范围 再是要找的值
	//upper_bound 返回地址 
	cout << a[t];//输出的是8 
	return 0;
} 
