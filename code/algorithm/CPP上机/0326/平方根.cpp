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

    cout << "���������� a b c �����������ÿո������";
    while(cin >> a >> b >> c && a)
    {
        solveQuadraticEquation(a, b, c, discriminant, r1, r2);

        if(discriminant > 0)
            cout << "����������" << r1 << ' ' << r2 << endl;
        else if(discriminant == 0)
            cout << "��һ������" << r1 << endl;
        else cout << "the equation has no root" << endl;
        cout << "���������� a b c �����������ÿո������";
    }
    
    return 0;
}