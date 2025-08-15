#include<bits/stdc++.h>
using namespace std;

const int N = 1e5 + 10;
void array_reference(int a[], int n)
{
    cout << "ԭ���飺";
    for(int i = 0; i < n; i++)
    {
        cout << a[i] << ' ';
    }
    cout << endl << "�޸�֮������飺";
    a[0] = 0;
    for(int i = 0; i < n; i++)
    {
        cout << a[i] << ' ';
    }
    puts("");
}

void swap_value(int x, int y)
{
    int temp = x;
    x = y;
    y = temp;
}

void swap_reference(int &x, int &y)
{
    int temp = x;
    x = y;
    y = temp;
}

void swap_pointer(int *p1, int *p2)
{
    int temp = *p1;
    *p1 = *p2;
    *p2 = temp;
}

int main()
{
    // ��֤�����Ǵ�������
    cout << "��֤�����Ǵ�������" << endl;
    int n = 3;
    int a[n] = {1, 2, 3};
    array_reference(a, n);
    
    // ��֤ swap ��ֵ
    int x = 9, y = 22;
    cout << "��֤ swap ��ֵ" << endl;
    cout << "ԭֵ��" << x << ' ' << y << endl;
    swap_value(x, y);
    cout << "��ֵ����֮��" << x << ' ' << y << endl;
    
    // ��֤ swap ������
    cout << "��֤ swap ������" << endl;
    cout << "ԭֵ��" << x << ' ' << y << endl;
    swap_reference(x, y);
    cout << "�����ý���֮��" << x << ' ' << y << endl;
    
    // ��֤ swap ��ָ��
    int *p1, *p2;
    *p1 = 1;
    *p2 = 2;
    cout << "��֤ swap ��ָ��" << endl;
    cout << "ԭֵ��" << *p1 << ' ' << *p2 << endl;
    swap_pointer(p1, p2);
    cout << "��ָ�뽻��֮��" << *p1 << ' ' << *p2 << endl;

    return 0;
}