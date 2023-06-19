#include<bits/stdc++.h>
using namespace std;

const int N = 10;

struct Node
{
    int pid;
    int arrival_time;
    int burst_time;
    int start_time;
    int end_time;
    int turnaround_time;
    int waiting_time;
    int priority;
    int state; //0Ϊδ����, 1Ϊ��������������, 2Ϊ��������, 3Ϊ�������
}PCB[N];

bool cmp_arrival(Node x, Node y)
{
    return x.arrival_time < y.arrival_time;
}

int in()
{
    int n;
    cout<<"�����������:";
    cin>>n;
    for(int i = 0; i < n; i++)
    {
        PCB[i].pid = i + 1;
        cout<<"�����"<<i + 1<<"�����̵���ʱ��:";
        cin>>PCB[i].arrival_time;
        cout<<"�����"<<i + 1<<"�����̹���ʱ��:";
        cin>>PCB[i].burst_time;
        PCB[i].end_time = 999;

    }
    system("pause");
    system("cls");
    return n;
}

void out(int n)
{
    double sum = 0;
    for(int i = 0; i < n; i++)
    {
        cout<<"PID:"<<PCB[i].pid<<"����תʱ��Ϊ"<<PCB[i].turnaround_time<<endl;
        sum += PCB[i].turnaround_time;
    }
    cout<<n<<"�����̵�ƽ����תʱ��Ϊ:"<<sum / n<<endl;
}

int find(int id, int n)
{
    for(int i = 0; i < n; i++)
    {
        if(PCB[i].pid == id)
        {
            return i;
        }
    }
}

bool check_finish(int n)
{
    for(int i = 0; i < n; i++)
    {
        if(PCB[i].state != 3) return false;
    }
    return true;
}

void fcfs(int n)
{
    cout<<"FCFS�����㷨��ʼ"<<endl;
    queue<Node> Ready;  //��������
    sort(PCB, PCB + n, cmp_arrival);

    int time = 0;
    // bool first_arrival = false;
    bool is_run = false;

    while(time < 20)
    {
        Node temp;
        int temp_id;

        //ÿ��һ��ʱ��Ƭ���ҵ���Ľ��̲���ӵ��������в���ǽ���״̬
        for(int i = 0; i < n; i++)
        {
            if(time >= PCB[i].arrival_time && PCB[i].state == 0)
            {
                // if(first_arrival = false)
                // {
                //     PCB[i].start_time = PCB[i].arrival_time;
                //     first_arrival = true;
                // }

                Ready.push(PCB[i]);
                PCB[i].state = 1;
            }
        }

        //������ʱ��Ƭû�н����������� && �������зǿ�
        if(is_run == false && Ready.empty() == false)
        {
            is_run = true;
            temp = Ready.front();
            temp_id = find(temp.pid, n);
            PCB[temp_id].start_time = time;
            PCB[temp_id].end_time = time + PCB[temp_id].burst_time;
            PCB[temp_id].state = 2;

            Ready.pop();
            PCB[temp_id].waiting_time = PCB[temp_id].start_time - PCB[temp_id].arrival_time;
            PCB[temp_id].turnaround_time = PCB[temp_id].end_time - PCB[temp_id].arrival_time;
        }
        
        //�����ǰʱ��Ƭ�ĸ�����״̬
        cout<<"��ǰʱ��Ƭ:"<<time<<'-'<<time + 1<<endl;
        for(int i = 0; i < n; i++)
        {
            cout<<"pidΪ"<<PCB[i].pid<<"�Ľ���״̬Ϊ:";
            if(PCB[i].state == 0)
            {
                cout<<"δ����"<<endl;
            }
            else if(PCB[i].state == 1)
            {
                cout<<"���ھ�������"<<endl;
            }
            else if(PCB[i].state == 2)
            {
                cout<<"������"<<endl;
            }
            else if(PCB[i].state == 3)
            {
                cout<<"�ѽ���"<<endl;
            }
        }

        //�����ǰʱ��Ƭ�ľ����������
        if(Ready.empty()) cout<<"��������Ϊ��"<<endl;
        else
        {
            cout<<"���ھ������еĽ�����:"<<endl;
            for(int i = 0; i < Ready.size(); i++)
            {
                cout<<"PID:"<<Ready.front().pid<<endl;
                Ready.push(Ready.front());
                Ready.pop();
            }
        }
        cout<<endl;

        system("pause");
        system("cls");

        //�����ǰʱ��Ƭ�ǵ�ǰ�������н��̵Ľ���ʱ��, ��Ǹý���Ϊ���, ������������
        //ʱ��Ƭ��������, ���̿�ʼʱ��ͽ���ʱ�䰴ʱ�������
        //ʱ��ƬͼƬ����:https://cdn.jsdelivr.net/gh/chousinbin/Image/202306192222744.png
        if(PCB[temp_id].end_time - 1 == time)
        {
            PCB[temp_id].state = 3;
            is_run = false;
        }

        time++;

        //�������˳�������ȡ����ķ���
        //�������н���, ������н��̵�״̬, �Ƿ����������
        //���ֱ���жϾ��������Ƿ�Ϊ�յĻ��о�����
        //����ǰ����ʱ��Ƭû�н��̵��� ��ֱ���˳�����
        if(check_finish(n))
        {
            out(n);
            break;
        }

    }
    cout<<"FCFS�����㷨����"<<endl;
}


int main()
{
    fcfs(in());
    return 0;
}