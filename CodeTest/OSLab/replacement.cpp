#include<bits/stdc++.h>
using namespace std;

const int N = 30;
int n;
int len;
int pages[N];

int head;
int e[N];
int ne[N];
int idx;  //id

void init()  //初始化
{
    head = tail = -1;
    idx = 0;
}

void insert(int x)  //尾插法
{
    if(head == -1) 
    {
        head = idx;
    }
    else
    {
        ne[tail] = idx;
    }
    e[idx] = x;
    ne[idx] = -1;
    idx++;
}

void del(int k)  //删除下标为k的节点的下一个节点
{
    ne[k] = ne[ne[k]];
}

void del_head()  //删除头节点
{
    head = ne[head];
}

int query_len()  //返回链表长度
{
    int cnt = 0;
    for(int i = head; i != -1; i = ne[i])
        cnt++;
    return cnt;
}

int query_val(int x)  //返回x的下标
{
    for(int i = head; i != -1; i = ne[i])
        if(e[i] == x) return i;
    return -1;  //未查到返回-1
}

int query_last(int x)  //返回x上个节点的下标
{
    for(int i = head; ne[i] != -1; i = ne[i])
    {
        if(e[ne[i]] == x) return i;
    }
}

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

void show_state()
{
    cout<<"****"<<endl;
    for(int i = head; i != -1; i = ne[i])
        cout<<e[i]<<endl;
    cout<<"****"<<endl;
}

void output(int cnt)
{
    cout<<"命中次数:"<<cnt<<"   "<<"总数:"<<n<<endl;
    cout<<"缺页率:"<<(double)(n- cnt) / n * 100<<'%'<<endl;
    cout<<"命中率:"<<(double)(cnt) / n * 100<<'%'<<endl;
}

void pause()
{
    system("pause");
    system("cls");
}
void FIFO()
{
    input();
    init();

    int cnt = 0;  //记录成功次数
    
    for(int p = 0; p < n; p++)
    {
        cout<<"当前请求页面为:"<<pages[p]<<endl;
        cout<<"内存上个状态"<<endl;
        show_state();

        if(query_val(pages[p]) != -1)  //从链表里面查pages[p]
        {
            cnt++;
            cout<<"当前页面命中"<<endl;
        }
        else  //查不到
        {
            cout<<"当前页面未命中"<<endl;
            if(query_len() < len)  //有空位置
            {
                insert(pages[p]);
                // Memory.push(pages[p]);
            }
            else  //没空缺
            {
                cout<<"剔除的是:"<<e[head]<<endl;
                del_head();
                insert(pages[p]);
            }
        }

        cout<<"请求完成后状态"<<endl;
        show_state();
        pause();
    }
    output(cnt);
}

void LRU()
{
    input();
    init();

    int cnt = 0;  //记录成功次数

    for(int p = 0; p < n; p++)
    {
        cout<<"当前请求页面为:"<<pages[p]<<endl;
        cout<<"内存上个状态"<<endl;
        show_state();

        if(query_val(pages[p]) != -1)  //如果查到, 找到在内存位置, 不改变内存顺序, 挪到队尾
        {
            cnt++;
            cout<<"当前页面命中"<<endl;
            
            if(e[head] == pages[p]) del_head();
            else del(query_last(pages[p]));

            insert(pages[p]);
            // move(pages[p], Memory);
        }
        else
        {
            cout<<"当前页面未命中"<<endl;
            if(query_len() < len)  //有空位置
            {
                insert(pages[p]);
            }
            else  //没空缺
            {
                cout<<"剔除的是:"<<e[head]<<endl;
                del_head();
                insert(pages[p]);
            }
        }

        cout<<"请求完成后状态"<<endl;
        show_state();
        pause();
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