#include <bits/stdc++.h>
using namespace std;

class shape
{
	public:
		virtual double cala() = 0;
};

class san : public shape
{
	double d;
	double height;
	public:
		san(double d, double height)
		{
			this->d = d;
			this->height = height;
		}
		double cala()
		{
			return d * height / 2;
		}
};

class circle : public shape
{
	double r;
	public:
		circle(double r)
		{
			this->r = r;
		}
		double cala()
		{
			return 3.14 * r * r;
		}
};

void fun(shape &s)
{
	cout << s.cala() << endl;
}

void fun2(shape* s)
{
	cout << s->cala() << endl;
}

int main()
{
	san s(2, 8.8);
	circle c(6);
	cout << "ÒýÓÃ" << endl;
	fun(s);
	fun(c);
	cout << "Ö¸Õë" << endl; 
	fun2(&s);
	fun2(&c);
	 
	return 0;
}
