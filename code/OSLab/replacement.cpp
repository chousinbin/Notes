#include<bits/stdc++.h>
using namespace std;

const int N = 30;
int n;  //ҳ��������
int len;  //����ڴ�ռ�ó���
int pages[N];  //ҳ����������

int head, tail;
int e[N];
int r[N];
int ne[N];
int idx;  //id


void init()  //�����ʼ��
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
    tail = idx++;
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

int query_val(int x)  //����ֵΪx�Ľڵ���±� && Ҳ�䵱��ѯ�ڴ�������ֵΪx�Ľڵ�, ����з����±�0~n, û�еĻ�����-1
{
    for(int i = head; i != -1; i = ne[i])
        if(e[i] == x) return i;
    return -1;  //δ�鵽����-1
}

int query_last(int x)  //����ֵΪx�Ľڵ���ϸ��ڵ���±�
{
    for(int i = head; ne[i] != -1; i = ne[i])
    {
        if(e[ne[i]] == x) return i;
    }
    return -1;
}

void pause()  //��ͣ�������������
{
    cout<<"�밴���������";
    getchar();
    system("cls");
}

void input()
{
    cout<<"�������ڴ泤��(1-10):";
    cin>>len;
    cout<<"������ҳ������(1-30):";
    cin>>n;

    for(int i = 0; i < n; i++)
    {
        printf("�����%02d��ҳ��ID:", i + 1);
        cin>>pages[i];
    }
    getchar();
    pause();
}

void show_state(bool st_location, bool st_type)
{
    if(st_location) cout<<endl<<"�������֮ǰ�ڴ�״̬"<<endl;
    else cout<<endl<<"�������֮���ڴ�״̬"<<endl;

    cout<<"====Memory===="<<endl;
    for(int i = head; i != -1; i = ne[i])
    {
        if(st_type) cout<<"id -> "<<e[i]<<"  "<<"R -> "<<r[i]<<endl;
        else cout<<"id -> "<<e[i]<<endl;
    }
    cout<<"=============="<<endl;
}

void output(int cnt)
{
    cout<<"���д���:"<<cnt<<"   "<<"����:"<<n<<endl;
    cout<<"ȱҳ��:"<<(double)(n- cnt) / n * 100<<'%'<<endl;
    cout<<"������:"<<(double)(cnt) / n * 100<<'%'<<endl;
    pause();
}

void FIFO()
{
    input();
    init();
    int cnt = 0;  //��¼�ɹ�����
    
    for(int p = 0; p < n; p++)
    {
        cout<<"��ǰ����ҳ��Ϊ: <"<<pages[p]<<'>'<<endl;
        show_state(true, false);

        if(query_val(pages[p]) != -1)  //�����������pages[p]
        {
            cnt++;
            cout<<"��ǰ����ҳ������"<<endl;
        }
        else  //�鲻��
        {
            cout<<"��ǰ����ҳ��δ����"<<endl;
            if(query_len() < len)  //�п�λ��
            {
                insert(pages[p]);
            }
            else  //û��ȱ
            {
                cout<<"���û�������: <"<<e[head]<<'>'<<endl;
                del_head();
                insert(pages[p]);
            }
        }

        show_state(false, false);
        pause();
    }
    output(cnt);
}

void LRU()  //�������ʹ��
{
    input();
    init();
    int cnt = 0;  //��¼�ɹ�����

    for(int p = 0; p < n; p++)
    {
        cout<<"��ǰ����ҳ��Ϊ: <"<<pages[p]<<'>'<<endl;
        show_state(true, false);

        if(query_val(pages[p]) != -1)  //����鵽, �ҵ����ڴ�λ��, ���ı��ڴ�˳��, Ų����β
        {
            cnt++;
            cout<<"��ǰ����ҳ������"<<endl;
            
            if(e[head] == pages[p]) del_head();  //���������ͷ, ɾ��ͷ�ڵ�
            else del(query_last(pages[p]));  //��������ͷ, ����x�ڵ����һ���ڵ���±�, ɾ�����x�ڵ�

            insert(pages[p]);  //�Ƶ�����β
        }
        else
        {
            cout<<"��ǰ����ҳ��δ����"<<endl;
            if(query_len() < len)  //�п�λ��
            {
                insert(pages[p]);
            }
            else  //û��ȱ
            {
                cout<<"���û�������: <"<<e[head]<<'>'<<endl;
                del_head();
                insert(pages[p]);
            }
        }

        show_state(false, false);
        pause();
    }
    output(cnt);
}

void SecondChance()
{
    input();
    init();
    int cnt = 0;  //��¼�ɹ�����
    
    for(int p = 0; p < n; p++)
    {
        cout<<"��ǰ����ҳ��Ϊ: <"<<pages[p]<<'>'<<endl;
        show_state(true, true);

        if(query_val(pages[p]) != -1)  //�����������pages[p]
        {
            cnt++;
            cout<<"��ǰ����ҳ������"<<endl;
            r[query_val(pages[p])] = 1;  //����, ��־λΪ��Ϊ1
        }
        else  //�鲻��
        {
            cout<<"��ǰ����ҳ��δ����"<<endl;
            if(query_len() < len)  //�п�λ��
            {
                insert(pages[p]);
            }
            else  //û��ȱ
            {
                while(r[head] == 1)  //�����ͷ��־λΪ1
                {
                    insert(e[head]);  //Ų������β,��־λ��0, ��������½ڵ��־λĬ��Ϊ0, 
                    del_head();  //ɾ����ͷ
                }

                del_head();
                insert(pages[p]);
            }
        }

        show_state(false, true);
        pause();
    }
    output(cnt);
}

void menu()
{
    cout<<"=======���˵�======="<<endl;
    cout<<"1. FIFO�㷨"<<endl;
    cout<<"2. LRU�㷨"<<endl;
    cout<<"3. SecondChance�㷨"<<endl;
    cout<<"0. �˳�����"<<endl;
    cout<<"====================="<<endl;
}

int main()
{
    int choice;
    while(true)
    {
        menu();
        cout<<"���������ѡ��:";
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
                cout<<"��ѡ����Ч"<<endl;
                pause();
        }
    }
    return 0;
}