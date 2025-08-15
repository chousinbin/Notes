#include <bits/stdc++.h>
using namespace std;

typedef struct Node {
    int value;
    struct Node* next;
} Node, *LinkList;

// 初始化链表，创建头结点和尾结点
void init(LinkList &L, LinkList &T) {
    L = (Node*)malloc(sizeof(Node));
    if (L == NULL) {
        cout << "Memory allocation failed" << endl;
        exit(1);
    }
    L->next = NULL;
    T = L; // 初始化时头尾指针都指向头结点
}

// 在链表尾部插入新节点
void insertTail(LinkList &T, int value) {
    Node* newNode = (Node*)malloc(sizeof(Node));
    if (newNode == NULL) {
        cout << "Memory allocation failed" << endl;
        exit(1);
    }
    newNode->value = value;
    newNode->next = NULL;
    T->next = newNode; // 将新节点链接到尾节点
    T = newNode; // 更新尾指针
}

// 删除指定位置的节点
void deleteNode(LinkList L, int position) {
    if (position < 0) {
        cout << "Invalid position" << endl;
        return;
    }

    Node* temp = L;
    for (int i = 0; i < position; ++i) {
        if (temp->next == NULL) {
            cout << "Position out of range" << endl;
            return;
        }
        temp = temp->next;
    }

    Node* toDelete = temp->next;
    if (toDelete == NULL) {
        cout << "Position out of range" << endl;
        return;
    }

    temp->next = toDelete->next;
    free(toDelete);
}

// 查找指定值的节点
Node* findNode(LinkList L, int value) {
    Node* temp = L->next; // 从头结点的下一个节点开始
    while (temp != NULL) {
        if (temp->value == value) {
            return temp;
        }
        temp = temp->next;
    }
    return NULL;
}

// 修改指定位置节点的值
void updateNode(LinkList L, int position, int newValue) {
    if (position < 0) {
        cout << "Invalid position" << endl;
        return;
    }

    Node* temp = L;
    for (int i = 0; i <= position; ++i) {
        if (temp->next == NULL) {
            cout << "Position out of range" << endl;
            return;
        }
        temp = temp->next;
    }

    temp->value = newValue;
}

// 打印链表
void printList(LinkList L) {
    Node* temp = L->next; // 从头结点的下一个节点开始
    while (temp != NULL) {
        cout << temp->value << " -> ";
        temp = temp->next;
    }
    cout << "NULL" << endl;
}

int main() {
    LinkList L, T;
    init(L, T);

    insertTail(T, 1);
    insertTail(T, 2);
    insertTail(T, 3);
    printList(L);

    deleteNode(L, 1);
    printList(L);

    Node* found = findNode(L, 3);
    if (found != NULL) {
        cout << "Found node with value: " << found->value << endl;
    } else {
        cout << "Node not found" << endl;
    }

    updateNode(L, 1, 10);
    printList(L);

    return 0;
}
