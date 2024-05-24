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
		// ��Ա���� ���� +
		MyPoint operator+ (MyPoint &b)
		{
			MyPoint tmp;
			tmp.x = x + b.x;
			tmp.y = y + b.y;
			return tmp;	
		}

		// ��Ա���� ���� һԪ����� ����
		const MyPoint operator++(int) // �����б�� int Ĭ�Ϻ�������֮ǰ��
		{
			cout << "���� post - increment" << endl;
			MyPoint old(x, y);
			x++;
			y++;
			return old;
		}
		// �������ñ����ٴε��ÿ������캯��
		const MyPoint& operator++()
		{
			cout << "ǰ�� pre - increment" << endl;
			++x;
			++y;
			return *this;
		}

		/* ȫ�ֺ������������࣬���Է���˽������ */ 

		// ��Ԫ������������� - 
		friend MyPoint operator- (MyPoint &a, MyPoint &b);
		// ��Ԫ���� >=
		friend bool operator>= (MyPoint &a, MyPoint &b);
		// ��Ԫ���� *=
		friend void operator*= (MyPoint &a, MyPoint &b);

		// ��Ԫ���� ���� һԪ�����
		friend const MyPoint & operator--(MyPoint &a);
		friend const MyPoint operator--(MyPoint &a, int); // ����

		// ������ű�����Ϊ��Ԫ����
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
// ����ķ���ֱ����� 
MyPoint operator- (MyPoint &a, MyPoint &b)
{
	MyPoint tmp;
	tmp.x = a.x - b.x;
	tmp.y = a.y - b.y;
	return tmp;	
}
// ����� x ��Ƚ� 
bool operator>= (MyPoint &a, MyPoint &b)
{
	return a.x >= b.x;
}
// �������ֱ����� 
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
	// ǰ�������
	cout << a.getX() << ' ' << a.getY() << endl;
	++a;
	a++;
	cout << a.getX() << ' ' << a.getY() << endl;
	// ǰ������
	cout << a.getX() << ' ' << a.getY() << endl;
	--a;
	a--;
	cout << a;

	// ��֤�������
	MyPoint p4;
	cin >> p4;
	cout << p4 << endl;

	return 0;
}
