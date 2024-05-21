#include<bits/stdc++.h>
using namespace std;

class MyPoint
{
		int x, y;
	
	public:
		MyPoint(int x = 0, int y = 0)
		{
			this->x = x;
			this->y = y;
		}
		// 成员函数 重载 +
		MyPoint operator+ (MyPoint &b)
		{
			MyPoint tmp;
			tmp.x = x + b.x;
			tmp.y = y + b.y;
			return tmp;	
		}

		// 成员函数 重载 一元运算符 后增
		const MyPoint operator++(int) // 参数列表带 int 默认后增，反之前增
		{
			cout << "后增 post - increment" << endl;
			MyPoint old(x, y);
			x++;
			y++;
			return old;
		}
		// 返回引用避免再次调用拷贝构造函数
		const MyPoint& operator++()
		{
			cout << "前增 pre - increment" << endl;
			++x;
			++y;
			return *this;
		}

		/* 全局函数，不属于类，可以访问私有属性 */ 

		// 友元函数重载运算符 - 
		friend MyPoint operator- (MyPoint &a, MyPoint &b);
		// 友元重载 >=
		friend bool operator>= (MyPoint &a, MyPoint &b);
		// 友元重载 *=
		friend void operator*= (MyPoint &a, MyPoint &b);

		// 友元函数 重载 一元运算符
		friend const MyPoint & operator--(MyPoint &a);
		friend const MyPoint operator--(MyPoint &a, int); // 后增

		// 输出符号必须作为友元函数
		friend ostream& operator<<(ostream &, MyPoint &);
		friend istream& operator>>(istream &, MyPoint &);

		int getX()
		{
			return x;
		}
		
		int getY()
		{
			return y;
		}
	
};
// 两点的分量直接相减 
MyPoint operator- (MyPoint &a, MyPoint &b)
{
	MyPoint tmp;
	tmp.x = a.x - b.x;
	tmp.y = a.y - b.y;
	return tmp;	
}
// 两点的 x 相比较 
bool operator>= (MyPoint &a, MyPoint &b)
{
	return a.x >= b.x;
}
// 两点分量直接相乘 
void operator*= (MyPoint &a, MyPoint &b)
{
	a.x *= b.x;
	b.y *= b.y;
//	return a;
}

const MyPoint& operator--(MyPoint &a)
{
	cout << "pre - decrement" << endl;
	--a.x;
	--a.y;
	return a;
}

const MyPoint operator--(MyPoint &a, int)
{
	cout << "post - decrement" << endl;
	MyPoint old(a.x, a.y);
	a.x--;
	a.y--;
	return old;
}

ostream& operator<<(ostream &out, MyPoint &obj)
{
	out << obj.x << ' ' << obj.y;
	return out;
}

istream& operator>>(istream &in, MyPoint &obj)
{
	in >> obj.x >> obj.y;
	return in;
}

int main()
{
	MyPoint a(1, 2);
	MyPoint b(3, 4);
	
	MyPoint c = a + b;
	cout << c.getX() << ' ' << c.getY() << endl;
	
	MyPoint d = a - b;
	cout << d.getX() << ' ' << d.getY() << endl;
	
	cout << (a >= b) << endl;
	
	a *= b;
	cout << a.getX() << endl;
	// 前增与后增
	cout << a.getX() << ' ' << a.getY() << endl;
	++a;
	a++;
	cout << a.getX() << ' ' << a.getY() << endl;
	// 前减与后减
	cout << a.getX() << ' ' << a.getY() << endl;
	--a;
	a--;
	cout << a;

	// 验证输入输出
	MyPoint p4;
	cin >> p4;
	cout << p4 << endl;

	return 0;
}
