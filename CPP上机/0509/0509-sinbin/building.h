#ifndef BUILDING_H
#define BUILDING_H

#include<bits/stdc++.h>
using namespace std;

class building
{
	protected:
		string bname;
		int bfloors;
		double bareas;
	public:
		// string 传引用 只读 
		building(const std::string& name, int floor, double area);
		// const 函数保证数据不被修改， virtual 保证多态性 
		virtual void print() const;
};

#endif
