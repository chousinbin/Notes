#include <bits/stdc++.h>
using namespace std;

const int N = 1e5 + 10;

int qu[N];
int qhead, qend;

void init()
{
	qhead = 0;
	qend = -1;
}

void push(int x)
{
	qu[++qend] = x;
}

void pop()
{
	qhead++;
}

bool empty()
{
	if(qhead > qend) return true;
	return false;
}

int query()
{
	return qu[qhead];
}

int main()
{
	init();
	int n;
	cin >> n;

	while(n--)
	{
		string op;
		cin >> op;
		int x;

		if(op == "push")
		{
			cin >> x;
			push(x);
		}
		else if(op == "pop")
		{
			pop();
		}
		else if(op == "empty")
		{
			if(empty()) cout << "YES" << endl;
			else cout << "NO" << endl;
		}
		else
		{
			cout << query() << endl;
		}
	}
	return 0;
}