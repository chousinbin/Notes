#include <bits/stdc++.h>
using namespace std;
int main(){
    int x, y, n;
    cin >> n;
    for(int i = 1;i <= n;i++){
        cin >> x >> y;
        int s = 0;
        if(x >= y) swap(x, y);
        for(int j = x + 1;j < y;j++){
            if(j % 2 != 0){
                s += j;
            }
        }
        cout << s << endl;
    }
    return 0;
}

