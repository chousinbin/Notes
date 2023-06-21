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

void init()  //��ʼ��
{
    head = tail = -1;
    idx = 0;
}

void insert(int x)  //β�巨
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

void del(int k)  //ɾ���±�Ϊk�Ľڵ����һ���ڵ�
{
    ne[k] = ne[ne[k]];
}

void del_head()  //ɾ��ͷ�ڵ�
{
    head = ne[head];
}

int query_len()  //����������
{
    int cnt = 0;
    for(int i = head; i != -1; i = ne[i])
        cnt++;
    return cnt;
}

int query_val(int x)  //����x���±�
{
    for(int i = head; i != -1; i = ne[i])
        if(e[i] == x) return i;
    return -1;  //δ�鵽����-1
}

int query_last(int x)  //����x�ϸ��ڵ���±�
{
    for(int i = head; ne[i] != -1; i = ne[i])
    {
        if(e[ne[i]] == x) return i;
    }
}

void input()
{
    cout<<"�������ڴ泤��(1-10):";
    cin>>len;
    cout<<"����������ҳ��(1-30):";
    cin>>n;

    for(int i = 0; i < n; i++)
    {
        cout<<"�����"<<i + 1<<"��ҳ��ID:";
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
    cout<<"���д���:"<<cnt<<"   "<<"����:"<<n<<endl;
    cout<<"ȱҳ��:"<<(double)(n- cnt) / n * 100<<'%'<<endl;
    cout<<"������:"<<(double)(cnt) / n * 100<<'%'<<endl;
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

    int cnt = 0;  //��¼�ɹ�����
    
    for(int p = 0; p < n; p++)
    {
        cout<<"��ǰ����ҳ��Ϊ:"<<pages[p]<<endl;
        cout<<"�ڴ��ϸ�״̬"<<endl;
        show_state();

        if(query_val(pages[p]) != -1)  //�����������pages[p]
        {
            cnt++;
            cout<<"��ǰҳ������"<<endl;
        }
        else  //�鲻��
        {
            cout<<"��ǰҳ��δ����"<<endl;
            if(query_len() < len)  //�п�λ��
            {
                insert(pages[p]);
                // Memory.push(pages[p]);
            }
            else  //û��ȱ
            {
                cout<<"�޳�����:"<<e[head]<<endl;
                del_head();
                insert(pages[p]);
            }
        }

        cout<<"������ɺ�״̬"<<endl;
        show_state();
        pause();
    }
    output(cnt);
}

void LRU()
{
    input();
    init();

    int cnt = 0;  //��¼�ɹ�����

    for(int p = 0; p < n; p++)
    {
        cout<<"��ǰ����ҳ��Ϊ:"<<pages[p]<<endl;
        cout<<"�ڴ��ϸ�״̬"<<endl;
        show_state();

        if(query_val(pages[p]) != -1)  //����鵽, �ҵ����ڴ�λ��, ���ı��ڴ�˳��, Ų����β
        {
            cnt++;
            cout<<"��ǰҳ������"<<endl;
            
            if(e[head] == pages[p]) del_head();
            else del(query_last(pages[p]));

            insert(pages[p]);
            // move(pages[p], Memory);
        }
        else
        {
            cout<<"��ǰҳ��δ����"<<endl;
            if(query_len() < len)  //�п�λ��
            {
                insert(pages[p]);
            }
            else  //û��ȱ
            {
                cout<<"�޳�����:"<<e[head]<<endl;
                del_head();
                insert(pages[p]);
            }
        }

        cout<<"������ɺ�״̬"<<endl;
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