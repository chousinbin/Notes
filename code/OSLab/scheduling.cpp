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
    int state; //0为未到达, 1为到达加入就绪队列, 2为正在运行, 3为进程完成, 4为被暂停
}PCB[N];

bool cmp(Node x, Node y)
{
    if(x.arrival_time != y.arrival_time)  return x.arrival_time < y.arrival_time;
    return x.remaining_time < y.remaining_time;  //如果到达时间相同按最短剩余排序
}

bool cmp_p(Node x, Node y)
{
    return x.priority > y.priority;
}

void pause()
{
    cout<<"请输入任意键继续";
    getchar();
    system("cls");
}

void input()
{
    cout<<"请输入进程数:";
    cin>>n;
    for(int i = 0; i < n; i++)
    {
        PCB[i].pid = i;
        cout<<"输入第"<<i + 1<<"个进程到达时间:";
        cin>>PCB[i].arrival_time;
        cout<<"输入第"<<i + 1<<"个进程工作时间:";
        cin>>PCB[i].burst_time;
        PCB[i].end_time = 999;  //防止误判导致进程未开始执行就结束

    }
    getchar();
    pause();
}

void input_PNP()
{
    cout<<"请输入进程数:";
    cin>>n;
    for(int i = 0; i < n; i++)
    {
        PCB[i].pid = i;
        cout<<"输入进程pid -> "<<i<<"的到达时间:";
        cin>>PCB[i].arrival_time;
        cout<<"输入进程pid -> "<<i<<"的工作时间:";
        cin>>PCB[i].burst_time;
        cout<<"输入进程pid -> "<<i<<"的优先级:";
        cin>>PCB[i].priority;
        PCB[i].end_time = 999;  //防止误判导致进程未开始执行就结束
    }
    getchar();
    pause();
}


void output(int time)
{
    double sum = 0;
    printf("PID \t 到达时间 \t 开始时间 \t 工作时间 \t 结束时间 \t 周转时间\n");
    for(int i = 0; i < n; i++)
    {
        printf("%d %8d %16d %16d %16d %16d\n", PCB[i].pid, 
        PCB[i].arrival_time, PCB[i].start_time, 
        PCB[i].burst_time, PCB[i].end_time, PCB[i].turnaround_time);
        
        sum += PCB[i].turnaround_time;
    }
    cout<<n<<"个进程的平均周转时间为:"<<sum / n<<endl;
    
    cout<<endl<<"甘特图如下(@为运行, *为等待)"<<endl;
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
    //输出当前时间片的各进程状态
    cout<<"当前时间片:["<<time<<'-'<<time + 1<<']'<<endl;
    for(int i = 0; i < n; i++)
    {
        cout<<"pid为"<<PCB[i].pid<<"的进程状态为:";
        if(PCB[i].state == 0)
        {
            cout<<"未到达"<<endl;
        }
        else if(PCB[i].state == 1)
        {
            cout<<"就绪中"<<endl;
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
            cout<<"暂停中"<<endl;
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
    sort(PCB, PCB + n, cmp);  //按进程到达时间升序排序
    
    int cnt = 0;  //记录进程完成个数
    int time = 0;
    bool is_run = false;
    queue<Node> Ready;  //就绪队列
    Node temp;
    int temp_id;

    while(cnt < n)
    {
        for(int i = 0; i < n; i++)  //每到一个时间片, 查找到达的进程并添加到就绪队列并标记进程状态
        {
            if(time >= PCB[i].arrival_time && PCB[i].state == 0)
            {
                Ready.push(PCB[i]);
                PCB[i].state = 1;
            }
        }
        
        if(is_run == false && Ready.empty() == false)  //如果这个时间片没有进程正在运行 && 就绪队列非空
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

        //时间片按块来算, 进程开始时间和结束时间按时间点来算:https://cdn.jsdelivr.net/gh/chousinbin/Image/202306192222744.png
        if(PCB[temp_id].end_time - 1 == time)  //如果当前时间片是当前正在运行进程的结束时间, 标记该进程为完成, 弹出就绪队列
        {
            PCB[temp_id].state = 3;
            is_run = false;
            cnt++;
        }

        time++;
    }
    output(time);
}

void init_remaining_time()  //初始化: 剩余时间 = 工作时间
{
    for(int i = 0; i < n; i++)
    {
        PCB[i].remaining_time = PCB[i].burst_time;
    }
}

void check_shorst(queue<Node> &Ready, Node &temp, int &temp_id)  //检查就绪队列是否有进程的剩余时间 < 目前temp的剩余时间
{
    /*
    temp可能是正在运行/没有运行过将要运行的进程
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

    if(p >= 0)  //说明就绪队列里面有比temp进程剩余时间短的进程
    {
        for(int i = 0; i < p; i++)  //把最短的移到就绪队列的队头
        {
            Ready.push(Ready.front());
            Ready.pop();
        }

        Ready.push(temp);  //当前temp进程加到就绪队列
        if(PCB[find(temp.pid)].state == 2) PCB[find(temp.pid)].state = 4;  //特判: temp是正在运行的进程 状态设为4暂停中
        temp = Ready.front();  //更新temp进程
        Ready.pop();
    }
    temp_id = find(temp.pid);  //temp是否更新, 都要获取 / 更新temp进程在PCB中的下标
}

void SRTF()
{
    sort(PCB, PCB + n, cmp);  //先按到达时间升序, 如果到达时间相同, 按剩余时间升序
    init_remaining_time();  //初始化剩余时间

    int time = 0;
    int cnt = 0;
    bool is_run = false;
    bool is_new_arrival = false;  //默认没有新进程到达
    queue<Node> Ready;  //就绪队列
    Node temp;
    int temp_id;

    while(cnt < n)
    {
        is_new_arrival = false;  //每到一个新的时间片, 把新进程到达标志归为FALSE
        for(int i = 0; i < n; i++)  //每到一个新时间片, 检查新到达进程并加入就绪队列
        {
            if(PCB[i].arrival_time <= time && PCB[i].state == 0)
            {
                Ready.push(PCB[i]);
                PCB[i].state = 1;
                is_new_arrival = true;
            }
        }

        
        if(is_run)//如果当前有进程正在运行
        {
            
            if(is_new_arrival)  //有进程新到达
            {
                check_shorst(Ready, temp, temp_id);  //检查正在运行的进程是否为最短剩余
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

        if(is_run == false && Ready.empty() == false)  //如果当前没有进程运行 && 就绪队列非空
        {   
            temp = Ready.front();  //从就绪队列任取一个进程
            Ready.pop();

            check_shorst(Ready, temp, temp_id);  //检查将要运行的进程是否为最短剩余

            if(PCB[temp_id].state == 1)  //如果要运行的进程是首次运行
                PCB[temp_id].start_time = time;

            PCB[temp_id].remaining_time--;
            PCB[temp_id].state = 2;
            is_run = true;
        }

        query_state(time);
        show_state(time, Ready);  //显示当前时间片, 各进程状态
        
        if(is_run && PCB[temp_id].remaining_time == 0)  //当前进程待执行时间为0, 说明进程结束
        {
            PCB[temp_id].end_time = time + 1;
            PCB[temp_id].state = 3;
            PCB[temp_id].turnaround_time = PCB[temp_id].end_time - PCB[temp_id].arrival_time;
            
            is_run = false;
            cnt++;
        }

        time++;
    }
    output(time);  //输出各进程周转时间和所有进程的平均周转时间
}

void RR()  //同一时间到达
{
    init_remaining_time();
    sort(PCB, PCB + n, cmp);
    int timer;
    cout<<"请输入轮转时间片长度:";
    cin>>timer;

    getchar();
    pause();

    int time = 0;
    int cnt = 0;
    bool is_run = false;
    queue<Node> Ready;  //就绪队列
    Node temp;
    int temp_id;

    int c = 0;  //当前小计时器
    while(cnt < n)
    {
        for(int i = 0; i < n; i++)  //每到一个新时间片, 检查新到达进程并加入就绪队列
        {
            if(PCB[i].arrival_time <= time && PCB[i].state == 0)
            {
                Ready.push(PCB[i]);
                PCB[i].state = 1;
            }
        }

        if(is_run == false && Ready.empty() == false)  //就绪队列非空 && 没有程序在运行
        {
            temp = Ready.front();
            temp_id = find(temp.pid);
            Ready.pop();  //先弹出到后期视情况再决定是否重回就绪队列

            if(PCB[temp_id].state == 1)  //该进程首次启动
            {
                PCB[temp_id].start_time = time;
                PCB[temp_id].state = 2;
            }
            else  //从挂起恢复的进程
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

        if(PCB[temp_id].remaining_time == 0)  //这个时间片后该进程结束
        {
            PCB[temp_id].end_time = time + 1;
            PCB[temp_id].state = 3;
            c = 0;
            is_run = false;
            cnt++;
            PCB[temp_id].turnaround_time = PCB[temp_id].end_time - PCB[temp_id].arrival_time;
        }
        else if(c == timer)  //当前时间片走完但还有剩余工作时长, 挂起此进程
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

void PNP()  //优先级非抢占调度
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
        for(int i = 0; i < n; i++)  //每到一个时间片, 查找到达的进程并添加到就绪队列并标记进程状态
        {
            if(time >= PCB[i].arrival_time && PCB[i].state == 0)
            {
                Ready.push(PCB[i]);
                PCB[i].state = 1;
                sort_p(Ready);  //每加一个进程到就绪队列, 按优先级排序, 高的在队头
            }
        }

        if(is_run == false && Ready.empty() == false)  //如果这个时间片没有进程正在运行 && 就绪队列非空
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

        if(PCB[temp_id].end_time - 1 == time)  //如果当前时间片是当前正在运行进程的结束时间, 标记该进程为完成, 弹出就绪队列
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
    cout<<"=======主菜单======="<<endl;
    cout<<"1. FCFS算法"<<endl;
    cout<<"2. SRTF算法(最短剩余优先)"<<endl;
    cout<<"3. RR算法(同时到达)"<<endl;
    cout<<"4. 优先级算法(非抢占)"<<endl;
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
                cout<<"当前为同时到达板轮转时间片, 确保所有进程同一时间到达"<<endl;
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
                cout<<"此选项无效"<<endl;
                pause();
        }
    }
    return 0;
}