#include<bits/stdc++.h>
using namespace std;

class A
{
	public:
		virtual void play()
		{
			cout << "a" << endl;
		}
};

class B : public A
{
	public:
		void play()
		{
			cout << "B" << endl;
		}
};


// 必须使用引用或指针
// 如果使用普通传参，会使多态失效 
void c(A &i)
{
	i.play();
}

int main()
{
	B b;
	c(b);
}
