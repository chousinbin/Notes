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


// ����ʹ�����û�ָ��
// ���ʹ����ͨ���Σ���ʹ��̬ʧЧ 
void c(A &i)
{
	i.play();
}

int main()
{
	B b;
	c(b);
}
