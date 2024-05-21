#include<bits/stdc++.h>
using namespace std;

template<class T>
class sample{
	T n;
	public:
		sample(){}
		sample(T i) { n = i;}
		sample<T> operator+(sample<T> &);
		void dis() { cout << n << endl; }
};

template<class T>
sample<T> sample<T>::operator+(sample<T> &s)
{
	sample<T> temp;
	temp.n = n + s.n;
	return temp;
}

int main()
{
	sample<int> s1(10), s2(20), s3;
	sample<double> s4;
	s3 = s1 + s2;
	s3.dis();
	
	return 0;
}
