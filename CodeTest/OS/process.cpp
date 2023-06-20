#include<bits/stdc++.h>
using namespace std;

const int N = 10;
int n;  //进程个数

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
    int state; //0为未到达, 1为到达加入就绪队列, 2为正在运行, 3为进程完成, 4为被暂停
}PCB[N];

bool cmp(Node x, Node y)
{
    if(x.arrival_time != y.arrival_time)  return x.arrival_time < y.arrival_time;
    return x.remaining_time < y.remaining_time;  //如果到达时间相同按最短剩余排序
}

void input()
{
    cout<<"请输入进程数:";
    cin>>n;
    for(int i = 0; i < n; i++)
    {
        PCB[i].pid = i + 1;
        cout<<"输入第"<<i + 1<<"个进程到达时间:";
        cin>>PCB[i].arrival_time;
        cout<<"输入第"<<i + 1<<"个进程工作时间:";
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
        cout<<"PID:"<<PCB[i].pid<<"的周转时间为"<<PCB[i].turnaround_time<<endl;
        sum += PCB[i].turnaround_time;
    }
    cout<<n<<"个进程的平均周转时间为:"<<sum / n<<endl;
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
    //输出当前时间片的各进程状态
        cout<<"当前时间片:"<<time<<'-'<<time + 1<<endl;
        for(int i = 0; i < n; i++)
        {
            cout<<"pid为"<<PCB[i].pid<<"的进程状态为:";
            if(PCB[i].state == 0)
            {
                cout<<"未到达"<<endl;
            }
            else if(PCB[i].state == 1)
            {
                cout<<"处于就绪队列"<<endl;
            }
            else if(PCB[i].state == 2)
            {
                cout<<"运行中"<<endl;
            }
            else if(PCB[i].state == 3)
            {
                cout<<"已结束"<<endl;
            }
            else if(PCB[i].state == 4)
            {
                cout<<"已暂停"<<endl;
            }
        }

        //输出当前时间片的就绪队列情况
        if(Ready.empty()) cout<<"就绪队列为空"<<endl;
        else
        {
            cout<<"处于就绪队列的进程有:"<<endl;
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
    cout<<"FCFS调度算法开始"<<endl;
    queue<Node> Ready;  //就绪队列
    int cnt = 0;  //记录进程完成个数
    sort(PCB, PCB + n, cmp);

    int time = 0;
    // bool first_arrival = false;
    bool is_run = false;

    while(cnt < n)
    {
        Node temp;
        int temp_id;

        //每到一个时间片查找到达的进程并添加到就绪队列并标记进程状态
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

        //如果这个时间片没有进程正在运行 && 就绪队列非空
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

        //如果当前时间片是当前正在运行进程的结束时间, 标记该进程为完成, 弹出就绪队列
        //时间片按块来算, 进程开始时间和结束时间按时间点来算
        //时间片图片访问:https://cdn.jsdelivr.net/gh/chousinbin/Image/202306192222744.png
        if(PCB[temp_id].end_time - 1 == time)
        {
            PCB[temp_id].state = 3;
            is_run = false;
            cnt++;
        }

        time++;
    }
    output();
    cout<<"FCFS调度算法结束"<<endl;
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

    if(p >= 0)  //说明就绪队列里面有比当前进程剩余时间短的进程
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
    init_SRTF();  //初始化剩余时间
    bool is_run = false;
    bool is_new_arrival = false;  //有进程到达
    int cnt = 0;

    Node temp;
    int temp_id;

    while(cnt < n)
    {
        is_new_arrival = false;
        //到一个新时间片检查新到达进程并加入就绪队列
        for(int i = 0; i < n; i++)
        {
            if(PCB[i].arrival_time <= time && PCB[i].state == 0)
            {
                Ready.push(PCB[i]);
                PCB[i].state = 1;
                is_new_arrival = true;
            }
        }

        //正在运行进程 && 有新到达的进程
        if(is_run)
        {
            //检查最短剩余
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

        //如果当前没有进程运行 && 就绪队列非空
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