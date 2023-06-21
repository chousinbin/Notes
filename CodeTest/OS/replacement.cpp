#include<bits/stdc++.h>
using namespace std;

const int N = 30;
int n;
int len;

int pages[N];
int cnt[N];  //cnt[x]Ϊxҳ�������ù��Ĵ���

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
    cout<<"��ǰ�ڴ�״̬(���������ȵ����)"<<endl;
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
    cout<<"���д���:"<<cnt<<"   "<<"����:"<<n<<endl;
    cout<<"ȱҳ��:"<<(double)(n- cnt) / n * 100<<'%'<<endl;
    cout<<"������:"<<(double)(cnt) / n * 100<<'%'<<endl;
}

void FIFO()
{
    input();
    queue<int> Memory;  //�ڴ�

    int p = 0;  //ָ������ҳ��λ��
    int cnt = 0;  //��¼�ɹ�����
    
    while(p < n)
    {
        if(query(p, Memory))  //����鵽
        {
            cnt++;
            cout<<"��ǰҳ������"<<endl;
        }
        else  //�鲻��
        {
            cout<<"��ǰҳ��δ����"<<endl;
            if(Memory.size() < len)  //�п�λ��
            {
                Memory.push(pages[p]);
            }
            else  //û��ȱ
            {
                cout<<"�޳�����:"<<Memory.front()<<endl;
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
        if(x == Memory.front())  //�ҵ�
        {
            if(i == 0 || i == Memory.size() - 1)  //��ͷ���β�ҵ�
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
    queue<int> Memory;  //�ڴ�

    int p = 0;  //ָ������ҳ��λ��
    int cnt = 0;  //��¼�ɹ�����

    while(p < n)
    {
        if(query(p, Memory))  //����鵽, �ҵ����ڴ�λ��, ���ı��ڴ�˳��, Ų����β
        {
            cnt++;
            move(pages[p], Memory);
            cout<<"��ǰҳ������"<<endl;
        }
        else
        {
            cout<<"��ǰҳ��δ����"<<endl;
            if(Memory.size() < len)  //�п�λ��
            {
                Memory.push(pages[p]);
            }
            else  //û��ȱ
            {
                cout<<"�޳�����:"<<Memory.front()<<endl;
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