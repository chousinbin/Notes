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
		// string ������ ֻ�� 
		building(const std::string& name, int floor, double area);
		// const ������֤���ݲ����޸ģ� virtual ��֤��̬�� 
		virtual void print() const;
};

#endif
