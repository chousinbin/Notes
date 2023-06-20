#include<bits/stdc++.h>
using namespace std;

const int N = 10;
int n;  //���̸���

struct Node
{
    int pid;
    int arrival_time;
    int burst_time;
    int start_time;
    int end_time;
    int turnaround_time;
    int waiting_time;
    int remaining_time;
    int priority;
    int state; //0Ϊδ����, 1Ϊ��������������, 2Ϊ��������, 3Ϊ�������, 4Ϊ����ͣ
}PCB[N];

bool cmp(Node x, Node y)
{
    if(x.arrival_time != y.arrival_time)  return x.arrival_time < y.arrival_time;
    return x.remaining_time < y.remaining_time;  //�������ʱ����ͬ�����ʣ������
}

void input()
{
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
}

void output()
{
    double sum = 0;
    for(int i = 0; i < n; i++)
    {
        cout<<"PID:"<<PCB[i].pid<<"����תʱ��Ϊ"<<PCB[i].turnaround_time<<endl;
        sum += PCB[i].turnaround_time;
    }
    cout<<n<<"�����̵�ƽ����תʱ��Ϊ:"<<sum / n<<endl;
}

int find(int id)
{
    for(int i = 0; i < n; i++)
    {
        if(PCB[i].pid == id)
        {
            return i;
        }
    }
}

void show_state(int time, queue<Node> Ready)
{
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
            else if(PCB[i].state == 4)
            {
                cout<<"����ͣ"<<endl;
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
}



void FCFS()
{
    cout<<"FCFS�����㷨��ʼ"<<endl;
    queue<Node> Ready;  //��������
    int cnt = 0;  //��¼������ɸ���
    sort(PCB, PCB + n, cmp);

    int time = 0;
    // bool first_arrival = false;
    bool is_run = false;

    while(cnt < n)
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
            temp_id = find(temp.pid);
            PCB[temp_id].start_time = time;
            PCB[temp_id].end_time = time + PCB[temp_id].burst_time;
            PCB[temp_id].state = 2;

            Ready.pop();
            PCB[temp_id].waiting_time = PCB[temp_id].start_time - PCB[temp_id].arrival_time;
            PCB[temp_id].turnaround_time = PCB[temp_id].end_time - PCB[temp_id].arrival_time;
        }
        
        show_state(time, Ready);

        //�����ǰʱ��Ƭ�ǵ�ǰ�������н��̵Ľ���ʱ��, ��Ǹý���Ϊ���, ������������
        //ʱ��Ƭ��������, ���̿�ʼʱ��ͽ���ʱ�䰴ʱ�������
        //ʱ��ƬͼƬ����:https://cdn.jsdelivr.net/gh/chousinbin/Image/202306192222744.png
        if(PCB[temp_id].end_time - 1 == time)
        {
            PCB[temp_id].state = 3;
            is_run = false;
            cnt++;
        }

        time++;
    }
    output();
    cout<<"FCFS�����㷨����"<<endl;
}

void init_SRTF()
{
    for(int i = 0; i < n; i++)
    {
        PCB[i].remaining_time = PCB[i].burst_time;
    }
}

Node check_shorst(queue<Node> &Ready, Node &temp)
{
    int p = -1;
    for(int i = 0; i < Ready.size(); i++)
    {
        if(Ready.front().remaining_time < temp.remaining_time)
        {
            p = i;
        }
        Ready.push(Ready.front());
        Ready.pop();
    }

    for(int i = 0; i < p; i++)
    {
        Ready.push(Ready.front());
        Ready.pop();
    }

    if(p >= 0)  //˵���������������бȵ�ǰ����ʣ��ʱ��̵Ľ���
    {
        Ready.push(temp);
        if(PCB[find(temp.pid)].state == 2) PCB[find(temp.pid)].state = 4;
        temp = Ready.front();
        Ready.pop();
    }
}

void SRTF()
{
    queue<Node> Ready;
    int time = 0;
    sort(PCB, PCB + n, cmp);
    init_SRTF();  //��ʼ��ʣ��ʱ��
    bool is_run = false;
    bool is_new_arrival = false;  //�н��̵���
    int cnt = 0;

    Node temp;
    int temp_id;

    while(cnt < n)
    {
        is_new_arrival = false;
        //��һ����ʱ��Ƭ����µ�����̲������������
        for(int i = 0; i < n; i++)
        {
            if(PCB[i].arrival_time <= time && PCB[i].state == 0)
            {
                Ready.push(PCB[i]);
                PCB[i].state = 1;
                is_new_arrival = true;
            }
        }

        //�������н��� && ���µ���Ľ���
        if(is_run)
        {
            //������ʣ��
            if(is_new_arrival)
            {
                check_shorst(Ready, temp);
                temp_id = find(temp.pid);
            }
            if(temp.state == 1)
            {
                PCB[temp_id].start_time = time;
                PCB[temp_id].remaining_time--;
                PCB[temp_id].state = 2;
            }
            else if(temp.state = 4)
            {
                PCB[temp_id].remaining_time--;
                PCB[temp_id].state = 2;
            }
            else if(temp.state == 2)
            {
                PCB[temp_id].remaining_time--;
            }
        }

        //�����ǰû�н������� && �������зǿ�
        if(is_run == false && Ready.empty() == false)
        {   
            temp = Ready.front();
            Ready.pop();
            
            check_shorst(Ready, temp);
            temp_id = find(temp.pid);
            if(PCB[temp_id].state == 1)
                PCB[temp_id].start_time = time;
            PCB[temp_id].remaining_time--;
            PCB[temp_id].state = 2;
            is_run = true;
        }

        show_state(time, Ready);

        if(PCB[temp_id].remaining_time == 0)
        {
            is_run = false;
            PCB[temp_id].end_time = time + 1;
            PCB[temp_id].state = 3;
            PCB[temp_id].turnaround_time = PCB[temp_id].end_time - PCB[temp_id].arrival_time;
            PCB[temp_id].waiting_time = PCB[temp_id].turnaround_time - PCB[temp_id].burst_time;
            
            cnt++;
        }

        time++;
    }
    output();
}

int main()
{
    input();
    SRTF();
    return 0;
}