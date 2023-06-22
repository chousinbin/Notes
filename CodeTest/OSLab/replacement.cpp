#include<bits/stdc++.h>
using namespace std;

const int N = 30;
int n;  //页面请求数
int len;  //标记内存占用长度
int pages[N];  //页面请求序列

int head, tail;
int e[N];
int r[N];
int ne[N];
int idx;  //id

void init()  //链表初始化
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
    tail = idx++;
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

int query_val(int x)  //返回值为x的节点的下标 && 也充当查询内存中有无值为x的节点, 如果有返回下标0~n, 没有的话返回-1
{
    for(int i = head; i != -1; i = ne[i])
        if(e[i] == x) return i;
    return -1;  //未查到返回-1
}

int query_last(int x)  //返回值为x的节点的上个节点的下标
{
    for(int i = head; ne[i] != -1; i = ne[i])
    {
        if(e[ne[i]] == x) return i;
    }
    return -1;
}

void pause()  //暂停任意键继续清屏
{
    cout<<"请按任意键继续";
    getchar();
    system("cls");
}

void input()
{
    cout<<"请输入内存长度(1-10):";
    cin>>len;
    cout<<"请输入页请求数(1-30):";
    cin>>n;

    for(int i = 0; i < n; i++)
    {
        printf("输入第%02d个页面ID:", i + 1);
        cin>>pages[i];
    }
    getchar();
    pause();
}

void show_state()
{
    cout<<"====Memory===="<<endl;
    for(int i = head; i != -1; i = ne[i])
        cout<<"id -> "<<e[i]<<"  "<<"R -> "<<r[i]<<endl;
    cout<<"=============="<<endl;
}

void pre_state()
{
    cout<<endl<<"请求完成之前内存状态"<<endl;
    show_state();
    cout<<endl;
}

void last_state()
{
    cout<<endl<<"请求完成之后内存状态"<<endl;
    show_state();
    pause();
}

void output(int cnt)
{
    cout<<"命中次数:"<<cnt<<"   "<<"总数:"<<n<<endl;
    cout<<"缺页率:"<<(double)(n- cnt) / n * 100<<'%'<<endl;
    cout<<"命中率:"<<(double)(cnt) / n * 100<<'%'<<endl;
    pause();
}

void FIFO()
{
    input();
    init();
    int cnt = 0;  //记录成功次数
    
    for(int p = 0; p < n; p++)
    {
        cout<<"当前请求页面为: <"<<pages[p]<<'>'<<endl;
        pre_state();

        if(query_val(pages[p]) != -1)  //从链表里面查pages[p]
        {
            cnt++;
            cout<<"当前请求页面命中"<<endl;
        }
        else  //查不到
        {
            cout<<"当前请求页面未命中"<<endl;
            if(query_len() < len)  //有空位置
            {
                insert(pages[p]);
            }
            else  //没空缺
            {
                cout<<"被置换掉的是: <"<<e[head]<<'>'<<endl;
                del_head();
                insert(pages[p]);
            }
        }

        last_state();
    }
    output(cnt);
}

void LRU()  //最近最少使用
{
    input();
    init();
    int cnt = 0;  //记录成功次数

    for(int p = 0; p < n; p++)
    {
        cout<<"当前请求页面为: <"<<pages[p]<<'>'<<endl;
        pre_state();

        if(query_val(pages[p]) != -1)  //如果查到, 找到在内存位置, 不改变内存顺序, 挪到队尾
        {
            cnt++;
            cout<<"当前请求页面命中"<<endl;
            
            if(e[head] == pages[p]) del_head();  //如果在链表头, 删除头节点
            else del(query_last(pages[p]));  //不在链表头, 查找x节点的上一个节点的下标, 删除这个x节点

            insert(pages[p]);  //移到链表尾
        }
        else
        {
            cout<<"当前请求页面未命中"<<endl;
            if(query_len() < len)  //有空位置
            {
                insert(pages[p]);
            }
            else  //没空缺
            {
                cout<<"被置换掉的是: <"<<e[head]<<'>'<<endl;
                del_head();
                insert(pages[p]);
            }
        }

        last_state();
    }
    output(cnt);
}

void SecondChance()
{
    input();
    init();
    int cnt = 0;  //记录成功次数
    
    for(int p = 0; p < n; p++)
    {
        cout<<"当前请求页面为: <"<<pages[p]<<'>'<<endl;
        pre_state();

        if(query_val(pages[p]) != -1)  //从链表里面查pages[p]
        {
            cnt++;
            cout<<"当前请求页面命中"<<endl;
            r[query_val(pages[p])] = 1;  //命中, 标志位为置为1
        }
        else  //查不到
        {
            cout<<"当前请求页面未命中"<<endl;
            if(query_len() < len)  //有空位置
            {
                insert(pages[p]);
            }
            else  //没空缺
            {
                while(r[head] == 1)  //如果表头标志位为1
                {
                    insert(e[head]);  //挪到链表尾,标志位归0, 这里插入新节点标志位默认为0, 
                    del_head();  //删除表头
                }

                del_head();
                insert(pages[p]);
            }
        }

        last_state();
    }
    output(cnt);
}

void menu()
{
    cout<<"=======主菜单======="<<endl;
    cout<<"1. FIFO算法"<<endl;
    cout<<"2. LRU算法"<<endl;
    cout<<"3. SecondChance算法"<<endl;
    cout<<"0. 退出程序"<<endl;
    cout<<"====================="<<endl;
}

int main()
{
    int choice;
    while(true)
    {
        menu();
        cout<<"请输入你的选项:";
        cin>>choice;

        pause();
        
        switch(choice)
        {
            case 0 :
                return 0;
                break;
            case 1 :
                FIFO();
                break;
            case 2 :
                LRU();
                break;
            case 3 :
                SecondChance();
                break;
            default :
                cout<<"此选项无效"<<endl;
                pause();
        }
    }
    return 0;
}