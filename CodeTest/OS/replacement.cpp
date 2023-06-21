#include<bits/stdc++.h>
using namespace std;

const int N = 30;
int n;
int len;

int pages[N];
int cnt[N];  //cnt[x]为x页面的最近用过的次数

void input()
{
    cout<<"请输入内存长度(1-10):";
    cin>>len;
    cout<<"请输入请求页数(1-30):";
    cin>>n;

    for(int i = 0; i < n; i++)
    {
        cout<<"输入第"<<i + 1<<"个页面ID:";
        cin>>pages[i];
    }
}

bool query(int p, queue<int> Memory)
{
    if(Memory.empty()) return false;
    for(int i = 0; i < Memory.size(); i++)
    {
        if(Memory.front() == pages[p]) return true;
        Memory.push(Memory.front());
        Memory.pop();
    }
    return false;
}

void show_state(queue<int> Memory)
{
    cout<<"当前内存状态(上面是最先到达的)"<<endl;
    cout<<"****"<<endl;
    for(int i = 0; i < Memory.size(); i++)
    {
        cout<<Memory.front()<<endl;
        Memory.push(Memory.front());
        Memory.pop();
    }
    cout<<"****"<<endl;

}

void output(int cnt)
{
    cout<<"命中次数:"<<cnt<<"   "<<"总数:"<<n<<endl;
    cout<<"缺页率:"<<(double)(n- cnt) / n * 100<<'%'<<endl;
    cout<<"命中率:"<<(double)(cnt) / n * 100<<'%'<<endl;
}

void FIFO()
{
    input();
    queue<int> Memory;  //内存

    int p = 0;  //指向请求页的位置
    int cnt = 0;  //记录成功次数
    
    while(p < n)
    {
        if(query(p, Memory))  //如果查到
        {
            cnt++;
            cout<<"当前页面命中"<<endl;
        }
        else  //查不到
        {
            cout<<"当前页面未命中"<<endl;
            if(Memory.size() < len)  //有空位置
            {
                Memory.push(pages[p]);
            }
            else  //没空缺
            {
                cout<<"剔除的是:"<<Memory.front()<<endl;
                Memory.pop();
                Memory.push(pages[p]);
            }
        }

        show_state(Memory);

        p++;
    }
    output(cnt);
}

void move(int x, queue<int> &Memory)
{
    int temp;
    int len = Memory.size();

    for(int i = 0; i < len; i++)
    {
        if(x == Memory.front())  //找到
        {
            if(i == 0 || i == Memory.size() - 1)  //队头或队尾找到
            {
                Memory.push(Memory.front());
                Memory.pop();
                return;
            }
            
            temp = Memory.front();
            Memory.pop();
        }
        else
        {
            Memory.push(Memory.front());
            Memory.pop();
        }
    }
    Memory.push(temp);
}

void LRU()
{
    input();
    queue<int> Memory;  //内存

    int p = 0;  //指向请求页的位置
    int cnt = 0;  //记录成功次数

    while(p < n)
    {
        if(query(p, Memory))  //如果查到, 找到在内存位置, 不改变内存顺序, 挪到队尾
        {
            cnt++;
            move(pages[p], Memory);
            cout<<"当前页面命中"<<endl;
        }
        else
        {
            cout<<"当前页面未命中"<<endl;
            if(Memory.size() < len)  //有空位置
            {
                Memory.push(pages[p]);
            }
            else  //没空缺
            {
                cout<<"剔除的是:"<<Memory.front()<<endl;
                Memory.pop();
                Memory.push(pages[p]);
            }
        }
        show_state(Memory);

        p++;
    }
    output(cnt);
}

void menu()
{

}

int main()
{
    LRU();
    return 0;
}