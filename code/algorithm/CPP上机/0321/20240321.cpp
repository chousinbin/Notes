#include<bits/stdc++.h>
using namespace std;

void array_reference(int a[], int n)
{
    cout << "�β������һ��Ԫ�صĵ�ַ��" << &a[0];
    a[0] = 0;
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
    cout << "��֤�����Ǵ�������" << endl << endl;
    int n = 3;
    int a[n] = {1, 2, 3};
    cout << "ԭ���飺";
    for(int i = 0; i < n; i++)
    {
        cout << a[i] << ' ';
    }
    cout << endl;
    array_reference(a, n);
    cout << endl << "�޸�֮������飺";
    for(int i = 0; i < n; i++)
    {
        cout << a[i] << ' ';
    }
    cout << endl;
    cout << "ʵ�������һ��Ԫ�صĵ�ַ��" << &a[0] << endl;
    cout << "�β���ʵ�������һ��Ԫ�صĵ�ַ��ͬ�����������������ݵ�ַ";
    puts("");
    puts("");
    
    // ��֤ swap ��ֵ
    int x = 9, y = 22;
    cout << "��֤ swap ��ֵ" << endl;
    cout << "ԭֵ��" << x << ' ' << y << endl;
    swap_value(x, y);
    cout << "��ֵ����֮��" << x << ' ' << y << endl << endl;
    
    // ��֤ swap ������
    cout << "��֤ swap ������" << endl;
    cout << "ԭֵ��" << x << ' ' << y << endl;
    swap_reference(x, y);
    cout << "�����ý���֮��" << x << ' ' << y << endl << endl;
    
    // ��֤ swap ��ָ��
    cout << "��֤ swap ��ָ��" << endl;
    cout << "ԭֵ��" << x << ' ' << y << endl;
    swap_pointer(&x, &y);
    cout << "��ָ�뽻��֮��" << x << ' ' << y << endl << endl;

    // 6.4
    int num = 65535;
    while(num)
    {
        cout << num % 10;
        num /= 10;
    }

    return 0;
}