#include<bits/stdc++.h>
using namespace std;

const int N = 10;
int n;
char ch[100][100];

struct Node
{
    int pid;
    int arrival_time;
    int burst_time;
    int start_time;
    int end_time;
    int turnaround_time;
    int remaining_time;
    int priority;
    int state; //0Ϊδ����, 1Ϊ��������������, 2Ϊ��������, 3Ϊ�������, 4Ϊ����ͣ
}PCB[N];

bool cmp(Node x, Node y)
{
    if(x.arrival_time != y.arrival_time)  return x.arrival_time < y.arrival_time;
    return x.remaining_time < y.remaining_time;  //�������ʱ����ͬ�����ʣ������
}

bool cmp_p(Node x, Node y)
{
    return x.priority > y.priority;
}

void pause()
{
    cout<<"���������������";
    getchar();
    system("cls");
}

void input()
{
    cout<<"�����������:";
    cin>>n;
    for(int i = 0; i < n; i++)
    {
        PCB[i].pid = i;
        cout<<"�����"<<i + 1<<"�����̵���ʱ��:";
        cin>>PCB[i].arrival_time;
        cout<<"�����"<<i + 1<<"�����̹���ʱ��:";
        cin>>PCB[i].burst_time;
        PCB[i].end_time = 999;  //��ֹ���е��½���δ��ʼִ�оͽ���

    }
    getchar();
    pause();
}

void input_PNP()
{
    cout<<"�����������:";
    cin>>n;
    for(int i = 0; i < n; i++)
    {
        PCB[i].pid = i;
        cout<<"�������pid -> "<<i<<"�ĵ���ʱ��:";
        cin>>PCB[i].arrival_time;
        cout<<"�������pid -> "<<i<<"�Ĺ���ʱ��:";
        cin>>PCB[i].burst_time;
        cout<<"�������pid -> "<<i<<"�����ȼ�:";
        cin>>PCB[i].priority;
        PCB[i].end_time = 999;  //��ֹ���е��½���δ��ʼִ�оͽ���
    }
    getchar();
    pause();
}


void output(int time)
{
    double sum = 0;
    printf("PID \t ����ʱ�� \t ��ʼʱ�� \t ����ʱ�� \t ����ʱ�� \t ��תʱ��\n");
    for(int i = 0; i < n; i++)
    {
        printf("%d %8d %16d %16d %16d %16d\n", PCB[i].pid, 
        PCB[i].arrival_time, PCB[i].start_time, 
        PCB[i].burst_time, PCB[i].end_time, PCB[i].turnaround_time);
        
        sum += PCB[i].turnaround_time;
    }
    cout<<n<<"�����̵�ƽ����תʱ��Ϊ:"<<sum / n<<endl;
    
    cout<<endl<<"����ͼ����(@Ϊ����, *Ϊ�ȴ�)"<<endl;
    for(int i = 0; i <= time; i++)
    {
        printf("%02d ",i);
    }
    cout<<"[time]"<<endl;
    for(int i = 0; i < n; i++)
    {
        
        for(int j = 0; j < time; j++)
        {
            cout<<"  "<<ch[PCB[i].pid][j];
        }
        cout<<"| pid->"<<PCB[i].pid<<endl;
    }
    pause();
}

int find(int id)
{
    int p;
    for(int i = 0; i < n; i++)
    {
        if(PCB[i].pid == id)
        {
           p = i;
           break;
        }
    }
    return p;
}

void show_state(int time, queue<Node> Ready)
{
    //�����ǰʱ��Ƭ�ĸ�����״̬
    cout<<"��ǰʱ��Ƭ:["<<time<<'-'<<time + 1<<']'<<endl;
    for(int i = 0; i < n; i++)
    {
        cout<<"pidΪ"<<PCB[i].pid<<"�Ľ���״̬Ϊ:";
        if(PCB[i].state == 0)
        {
            cout<<"δ����"<<endl;
        }
        else if(PCB[i].state == 1)
        {
            cout<<"������"<<endl;
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
            cout<<"��ͣ��"<<endl;
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
    
    pause();
}

void query_state(int time)
{
    for(int i = 0; i < n; i++)
    {
        if(PCB[i].state == 2) ch[PCB[i].pid][time] = '@';
        else if(PCB[i].state == 4 || PCB[i].state == 1) ch[PCB[i].pid][time] = '*';
        else ch[PCB[i].pid][time] = ' ';
    }
}

void FCFS()
{ 
    sort(PCB, PCB + n, cmp);  //�����̵���ʱ����������
    
    int cnt = 0;  //��¼������ɸ���
    int time = 0;
    bool is_run = false;
    queue<Node> Ready;  //��������
    Node temp;
    int temp_id;

    while(cnt < n)
    {
        for(int i = 0; i < n; i++)  //ÿ��һ��ʱ��Ƭ, ���ҵ���Ľ��̲���ӵ��������в���ǽ���״̬
        {
            if(time >= PCB[i].arrival_time && PCB[i].state == 0)
            {
                Ready.push(PCB[i]);
                PCB[i].state = 1;
            }
        }
        
        if(is_run == false && Ready.empty() == false)  //������ʱ��Ƭû�н����������� && �������зǿ�
        {
            is_run = true;
            temp = Ready.front();
            Ready.pop();
            temp_id = find(temp.pid);

            PCB[temp_id].start_time = time;
            PCB[temp_id].end_time = time + PCB[temp_id].burst_time;
            PCB[temp_id].state = 2;
            PCB[temp_id].turnaround_time = PCB[temp_id].end_time - PCB[temp_id].arrival_time;
        }
        
        query_state(time);
        show_state(time, Ready);

        //ʱ��Ƭ��������, ���̿�ʼʱ��ͽ���ʱ�䰴ʱ�������:https://cdn.jsdelivr.net/gh/chousinbin/Image/202306192222744.png
        if(PCB[temp_id].end_time - 1 == time)  //�����ǰʱ��Ƭ�ǵ�ǰ�������н��̵Ľ���ʱ��, ��Ǹý���Ϊ���, ������������
        {
            PCB[temp_id].state = 3;
            is_run = false;
            cnt++;
        }

        time++;
    }
    output(time);
}

void init_remaining_time()  //��ʼ��: ʣ��ʱ�� = ����ʱ��
{
    for(int i = 0; i < n; i++)
    {
        PCB[i].remaining_time = PCB[i].burst_time;
    }
}

void check_shorst(queue<Node> &Ready, Node &temp, int &temp_id)  //�����������Ƿ��н��̵�ʣ��ʱ�� < Ŀǰtemp��ʣ��ʱ��
{
    /*
    temp��������������/û�����й���Ҫ���еĽ���
    */
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

    if(p >= 0)  //˵���������������б�temp����ʣ��ʱ��̵Ľ���
    {
        for(int i = 0; i < p; i++)  //����̵��Ƶ��������еĶ�ͷ
        {
            Ready.push(Ready.front());
            Ready.pop();
        }

        Ready.push(temp);  //��ǰtemp���̼ӵ���������
        if(PCB[find(temp.pid)].state == 2) PCB[find(temp.pid)].state = 4;  //����: temp���������еĽ��� ״̬��Ϊ4��ͣ��
        temp = Ready.front();  //����temp����
        Ready.pop();
    }
    temp_id = find(temp.pid);  //temp�Ƿ����, ��Ҫ��ȡ / ����temp������PCB�е��±�
}

void SRTF()
{
    sort(PCB, PCB + n, cmp);  //�Ȱ�����ʱ������, �������ʱ����ͬ, ��ʣ��ʱ������
    init_remaining_time();  //��ʼ��ʣ��ʱ��

    int time = 0;
    int cnt = 0;
    bool is_run = false;
    bool is_new_arrival = false;  //Ĭ��û���½��̵���
    queue<Node> Ready;  //��������
    Node temp;
    int temp_id;

    while(cnt < n)
    {
        is_new_arrival = false;  //ÿ��һ���µ�ʱ��Ƭ, ���½��̵����־��ΪFALSE
        for(int i = 0; i < n; i++)  //ÿ��һ����ʱ��Ƭ, ����µ�����̲������������
        {
            if(PCB[i].arrival_time <= time && PCB[i].state == 0)
            {
                Ready.push(PCB[i]);
                PCB[i].state = 1;
                is_new_arrival = true;
            }
        }

        
        if(is_run)//�����ǰ�н�����������
        {
            
            if(is_new_arrival)  //�н����µ���
            {
                check_shorst(Ready, temp, temp_id);  //����������еĽ����Ƿ�Ϊ���ʣ��
            }

            if(PCB[temp_id].state == 1)
            {
                PCB[temp_id].start_time = time;
                PCB[temp_id].remaining_time--;
                PCB[temp_id].state = 2;
            }
            else if(PCB[temp_id].state = 4)
            {
                PCB[temp_id].remaining_time--;
                PCB[temp_id].state = 2;
            }
            else if(PCB[temp_id].state == 2)
            {
                PCB[temp_id].remaining_time--;
            }
        }

        if(is_run == false && Ready.empty() == false)  //�����ǰû�н������� && �������зǿ�
        {   
            temp = Ready.front();  //�Ӿ���������ȡһ������
            Ready.pop();

            check_shorst(Ready, temp, temp_id);  //��齫Ҫ���еĽ����Ƿ�Ϊ���ʣ��

            if(PCB[temp_id].state == 1)  //���Ҫ���еĽ������״�����
                PCB[temp_id].start_time = time;

            PCB[temp_id].remaining_time--;
            PCB[temp_id].state = 2;
            is_run = true;
        }

        query_state(time);
        show_state(time, Ready);  //��ʾ��ǰʱ��Ƭ, ������״̬
        
        if(is_run && PCB[temp_id].remaining_time == 0)  //��ǰ���̴�ִ��ʱ��Ϊ0, ˵�����̽���
        {
            PCB[temp_id].end_time = time + 1;
            PCB[temp_id].state = 3;
            PCB[temp_id].turnaround_time = PCB[temp_id].end_time - PCB[temp_id].arrival_time;
            
            is_run = false;
            cnt++;
        }

        time++;
    }
    output(time);  //�����������תʱ������н��̵�ƽ����תʱ��
}

void RR()  //ͬһʱ�䵽��
{
    init_remaining_time();
    sort(PCB, PCB + n, cmp);
    int timer;
    cout<<"��������תʱ��Ƭ����:";
    cin>>timer;

    getchar();
    pause();

    int time = 0;
    int cnt = 0;
    bool is_run = false;
    queue<Node> Ready;  //��������
    Node temp;
    int temp_id;

    int c = 0;  //��ǰС��ʱ��
    while(cnt < n)
    {
        for(int i = 0; i < n; i++)  //ÿ��һ����ʱ��Ƭ, ����µ�����̲������������
        {
            if(PCB[i].arrival_time <= time && PCB[i].state == 0)
            {
                Ready.push(PCB[i]);
                PCB[i].state = 1;
            }
        }

        if(is_run == false && Ready.empty() == false)  //�������зǿ� && û�г���������
        {
            temp = Ready.front();
            temp_id = find(temp.pid);
            Ready.pop();  //�ȵ���������������پ����Ƿ��ػؾ�������

            if(PCB[temp_id].state == 1)  //�ý����״�����
            {
                PCB[temp_id].start_time = time;
                PCB[temp_id].state = 2;
            }
            else  //�ӹ���ָ��Ľ���
            {
                PCB[temp_id].state = 2;
            }
            is_run = true;
        }

        if(is_run)
        {
            c++;
            PCB[temp_id].remaining_time--;
        }

        query_state(time);
        show_state(time, Ready);

        if(PCB[temp_id].remaining_time == 0)  //���ʱ��Ƭ��ý��̽���
        {
            PCB[temp_id].end_time = time + 1;
            PCB[temp_id].state = 3;
            c = 0;
            is_run = false;
            cnt++;
            PCB[temp_id].turnaround_time = PCB[temp_id].end_time - PCB[temp_id].arrival_time;
        }
        else if(c == timer)  //��ǰʱ��Ƭ���굫����ʣ�๤��ʱ��, ����˽���
        {
            PCB[temp_id].state = 4;
            Ready.push(PCB[temp_id]);
            c = 0;
            is_run = false;
        }

        time++;
    }
    output(time);
}

void sort_p(queue<Node> &Ready)
{
    int len = Ready.size();
    Node temp_PCB[len];
    for(int i = 0; Ready.empty() == false; i++)
    {
        temp_PCB[i] = PCB[Ready.front().pid];
        Ready.pop();
    }

    sort(temp_PCB, temp_PCB + len, cmp_p);
    
    for(int i = 0; i < len; i++)
    {
        Ready.push(temp_PCB[i]);
    }
}

void PNP()  //���ȼ�����ռ����
{
    sort(PCB, PCB + n, cmp);

    int cnt = 0;
    int time = 0;
    bool is_run = false;
    queue<Node> Ready;
    Node temp;
    int temp_id;

    while(cnt < n)
    {
        for(int i = 0; i < n; i++)  //ÿ��һ��ʱ��Ƭ, ���ҵ���Ľ��̲���ӵ��������в���ǽ���״̬
        {
            if(time >= PCB[i].arrival_time && PCB[i].state == 0)
            {
                Ready.push(PCB[i]);
                PCB[i].state = 1;
                sort_p(Ready);  //ÿ��һ�����̵���������, �����ȼ�����, �ߵ��ڶ�ͷ
            }
        }

        if(is_run == false && Ready.empty() == false)  //������ʱ��Ƭû�н����������� && �������зǿ�
        {
            is_run = true;
            temp = Ready.front();
            Ready.pop();
            temp_id = find(temp.pid);

            PCB[temp_id].start_time = time;
            PCB[temp_id].end_time = time + PCB[temp_id].burst_time;
            PCB[temp_id].state = 2;
            PCB[temp_id].turnaround_time = PCB[temp_id].end_time - PCB[temp_id].arrival_time;
        }

        query_state(time);
        show_state(time, Ready);

        if(PCB[temp_id].end_time - 1 == time)  //�����ǰʱ��Ƭ�ǵ�ǰ�������н��̵Ľ���ʱ��, ��Ǹý���Ϊ���, ������������
        {
            PCB[temp_id].state = 3;
            is_run = false;
            cnt++;
        }

        time++;
    }
    output(time);
}

void to_zero()
{
    for(int i = 0; i < n; i++)
    {
        PCB[i].arrival_time =  0;
        PCB[i].burst_time = 0;
        PCB[i].end_time = 0;
        PCB[i].pid = 0;
        PCB[i].priority = 0;
        PCB[i].remaining_time = 0;
        PCB[i].start_time = 0;
        PCB[i].state = 0;
        PCB[i].turnaround_time = 0;
    }
}

void menu()
{
    cout<<"=======���˵�======="<<endl;
    cout<<"1. FCFS�㷨"<<endl;
    cout<<"2. SRTF�㷨(���ʣ������)"<<endl;
    cout<<"3. RR�㷨(ͬʱ����)"<<endl;
    cout<<"4. ���ȼ��㷨(����ռ)"<<endl;
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

        getchar();
        pause();
        
        switch(choice)
        {
            case 0 :
                return 0;
                break;
            case 1 :
                input();
                FCFS();
                to_zero();
                break;
            case 2 :
                input();
                SRTF();
                to_zero();
                break;
            case 3 :
                cout<<"��ǰΪͬʱ�������תʱ��Ƭ, ȷ�����н���ͬһʱ�䵽��"<<endl;
                input();
                RR();
                to_zero();
                break;
            case 4 :
                input_PNP();
                PNP();
                to_zero();
                break;
            default :
                cout<<"��ѡ����Ч"<<endl;
                pause();
        }
    }
    return 0;
}