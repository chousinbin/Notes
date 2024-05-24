#include<bits/stdc++.h>
using namespace std;

class Rational
{
		double numerator;
		double denominator;
		
	public:
		Rational(int numerator = 0, int denominator = 0)
		{
			this->numerator = numerator;
			this->denominator = denominator;
		}
		
		~Rational()
		{
//			cout << "GoodBye~" << numerator << ' ' << denominator << endl;
			cout << "GoodBye ~" << endl;
		}
		
		
		Rational operator+(Rational & b)
		{
			Rational tmp;
			tmp.numerator = numerator + b.numerator;
			tmp.denominator = denominator + b.denominator;
			return tmp;
		}
		
		double getNumerator()
		{
			return numerator;
		}
		
		double getDenominator()
		{
			return denominator;
		}
		
		Rational& operator++()
		{
			++numerator;
			++denominator;
			return *this;
		}
		
		Rational operator++(int)
		{
			Rational old(numerator, denominator);
			numerator++;
			denominator++;
			return old;
		}
		
		friend Rational& operator--(Rational &r);
		friend Rational operator--(Rational &r, int);
		
		friend ostream& operator<<(ostream&, Rational&);
		friend istream& operator>>(istream&, Rational&);
		
		friend Rational operator*(Rational &a, Rational &b);
};

Rational operator*(Rational &a, Rational &b)
{
	Rational tmp;
	tmp.numerator = a.numerator * b.numerator;
	tmp.denominator = a.denominator * b.denominator;
	return tmp;
}

Rational& operator--(Rational &r)
{
	--r.numerator;
	--r.denominator;
	return r;
}

Rational operator--(Rational &r, int)
{
	Rational old(r.numerator, r.denominator);
	r.numerator--;
	r.denominator--;
	return old;
}

ostream& operator<<(ostream& out, Rational& obj)
{
	out << "Numerator: " <<obj.getNumerator() << " Denominator: " << obj.getDenominator();
	return out;
}

istream& operator>>(istream& in, Rational& obj)
{
	in >> obj.numerator >> obj. denominator;
	return in;
}

int main()
{
	Rational a, b;
	cin >> a >> b;
	cout << "a " << a << endl;
	cout << "b " << b << endl;
	 	
	Rational c = a + b;
	cout << "c = a + b = " << c << endl;
	
	Rational d = a * b;
	cout << "d = a * b = " << d << endl;
	
	a++;
	cout << "a post ++ " << a << endl;
	++a;
	cout << "a pre  ++ " << a << endl;
	--a;
	cout << "a pre  -- " << a << endl;
	a--;
	cout << "a post -- " << a << endl;
	
	return 0;
}
