#include<bits/stdc++.h>
using namespace std;
int mon[13] = {0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31}; 
bool check(int date)
{
	int year = date / 10000;
	int month = date % 10000 / 100;
	int day = date % 100;
	// 月数非法 
	if(month == 0 || month > 12) return false;
	// 除了 2 月的月天数非法 
	if(day == 0 || month != 2 && day > mon[month]) return false;
	// 2 月平年闰年的特判
	if(month == 2)
	{
		int leap = year % 100 && year % 4 == 0 || year % 400 == 0;//是闰年的话为1否则为0
		if(day > 28 + leap) return false; 
	} 
	return true;
}
int main()
{
	int a, b;
	cin >> a >> b;
	
	int res = 0; 
	for(int i = 1000; i <= 9999; i++)
	{
        // 把date和翻转过来的x拼接在一起形成回文数 
		int date = i,x = i;
		while(x)
		{
		    date = date * 10 + x % 10;
		    x /= 10;
		}
		//判断是否在范围之内
		if(date < a || date > b) continue;
		//判断日期是否合法 
		if(check(date)) res++;
	}
	
	cout<<res;
	return 0; 
}