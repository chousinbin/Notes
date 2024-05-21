#include<bits/stdc++.h>
using namespace std;

const int N = 6;
char g[N][N], backup[N][N];

void turn(int x, int y)
{
    int dx[] = {1, 0, -1, 0, 0};
    int dy[] = {0, 1, 0, -1, 0};

    for(int i = 0; i < 5; i++)
    {
        int a = x + dx[i];
        int b = y + dy[i];

        if(a < 0 || a > 4 || b < 0 || b > 4) continue;
        g[a][b] ^= 1;
    }
}

int main()
{
    int t;
    cin>>t;

    while(t--)
    {
        for(int i = 0; i < 5; i++)
            cin>>g[i];
        
        memcpy(backup, g, sizeof g);

        int res = 10;

        for(int op = 0; op < 32; op++)
        {
            int step = 0;
            for(int i = 0; i < 5; i++)
            {
                if(op >> i & 1)
                {
                    step++;
                    turn(0, i);
                }
            }

            for(int i = 0; i < 4; i++)
            {
                for(int j = 0; j < 5; j++)
                {
                    if(g[i][j] != '1')
                    {
                        step++;
                        turn(i + 1, j);
                    }
                }
            }

            bool isDark = false;
            for(int i = 0; i < 5; i++)
            {
                if(g[4][i] == '0')
                {
                    isDark = true;
                    break;
                }
            }

            if(!isDark)
            {
                res = min(res, step);
            }
            memcpy(g, backup, sizeof g);
        }

        if(res > 6 )
            res = -1;

        cout<<res<<endl;
    }
    return 0;
}