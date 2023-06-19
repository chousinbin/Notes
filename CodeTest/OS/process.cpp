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
    int state; //0为未到达, 1为到达加入就绪队列, 2为正在运行, 3为进程完成
}PCB[N];

bool cmp_arrival(Node x, Node y)
{
    return x.arrival_time < y.arrival_time;
}

int in()
{
    int n;
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
    return n;
}

void out(int n)
{
    double sum = 0;
    for(int i = 0; i < n; i++)
    {
        cout<<"PID:"<<PCB[i].pid<<"的周转时间为"<<PCB[i].turnaround_time<<endl;
        sum += PCB[i].turnaround_time;
    }
    cout<<n<<"个进程的平均周转时间为:"<<sum / n<<endl;
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
    cout<<"FCFS调度算法开始"<<endl;
    queue<Node> Ready;  //就绪队列
    sort(PCB, PCB + n, cmp_arrival);

    int time = 0;
    // bool first_arrival = false;
    bool is_run = false;

    while(time < 20)
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
            temp_id = find(temp.pid, n);
            PCB[temp_id].start_time = time;
            PCB[temp_id].end_time = time + PCB[temp_id].burst_time;
            PCB[temp_id].state = 2;

            Ready.pop();
            PCB[temp_id].waiting_time = PCB[temp_id].start_time - PCB[temp_id].arrival_time;
            PCB[temp_id].turnaround_time = PCB[temp_id].end_time - PCB[temp_id].arrival_time;
        }
        
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

        //如果当前时间片是当前正在运行进程的结束时间, 标记该进程为完成, 弹出就绪队列
        //时间片按块来算, 进程开始时间和结束时间按时间点来算
        //时间片图片访问:https://cdn.jsdelivr.net/gh/chousinbin/Image/202306192222744.png
        if(PCB[temp_id].end_time - 1 == time)
        {
            PCB[temp_id].state = 3;
            is_run = false;
        }

        time++;

        //这里检查退出条件采取的最笨的方法
        //遍历所有进程, 检查所有进程的状态, 是否都以完成运行
        //如果直接判断就绪队列是否为空的话有局限性
        //比如前几个时间片没有进程到达 会直接退出程序
        if(check_finish(n))
        {
            out(n);
            break;
        }

    }
    cout<<"FCFS调度算法结束"<<endl;
}


int main()
{
    fcfs(in());
    return 0;
}