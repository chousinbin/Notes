#include<bits/stdc++.h>
using namespace std;

void solveQuadraticEquation(int a, int b, int c, double &discriminant
    , double &r1, double &r2 )
{
    discriminant = pow(b, 2) - 4 * a * c;

    if(discriminant > 0)
    {
        r1 = (-b + sqrt(discriminant)) / (2 * a);
        r2 = (-b - sqrt(discriminant)) / (2 * a);
    }
    else if(discriminant == 0)
        r1 = (-b + sqrt(discriminant)) / (2 * a);

    return;
}

int main()
{
    int a, b, c;
    double discriminant, r1, r2;

    cout << "请依次输入 a b c 三个参数，用空格隔开：";
    while(cin >> a >> b >> c && a)
    {
        solveQuadraticEquation(a, b, c, discriminant, r1, r2);

        if(discriminant > 0)
            cout << "有两个根：" << r1 << ' ' << r2 << endl;
        else if(discriminant == 0)
            cout << "有一个根：" << r1 << endl;
        else cout << "该方程式没有根" << endl;
        cout << "请依次输入 a b c 三个参数，用空格隔开：";
    }
    
    return 0;
}