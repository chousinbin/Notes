#include <stdio.h>
#include <stdlib.h>

// 定义顺序表结构体
typedef struct {
    int *data;     // 动态数组
    int size;      // 顺序表的当前大小
    int capacity;  // 顺序表的容量
} SeqList;

// 初始化顺序表
SeqList* initSeqList(int capacity) {
    SeqList* list = (SeqList*)malloc(sizeof(SeqList));
    list->data = (int*)malloc(sizeof(int) * capacity);
    list->size = 0;
    list->capacity = capacity;
    return list;
}

// 动态扩容
void resize(SeqList* list, int newCapacity) {
    int* newData = (int*)malloc(sizeof(int) * newCapacity);
    for (int i = 0; i < list->size; ++i) {
        newData[i] = list->data[i];
    }
    free(list->data);
    list->data = newData;
    list->capacity = newCapacity;
}

// 插入元素
void insert(SeqList* list, int index, int value) {
    if (index < 0 || index > list->size) {
        printf("Index out of range\n");
        return;
    }

    if (list->size == list->capacity) {
        resize(list, list->capacity * 2);
    }

    for (int i = list->size; i > index; --i) {
        list->data[i] = list->data[i - 1];
    }

    list->data[index] = value;
    list->size++;
}

// 删除元素
void remove(SeqList* list, int index) {
    if (index < 0 || index >= list->size) {
        printf("Index out of range\n");
        return;
    }

    for (int i = index; i < list->size - 1; ++i) {
        list->data[i] = list->data[i + 1];
    }

    list->size--;
}

// 修改元素
void update(SeqList* list, int index, int value) {
    if (index < 0 || index >= list->size) {
        printf("Index out of range\n");
        return;
    }

    list->data[index] = value;
}

// 查找元素
int get(SeqList* list, int index) {
    if (index < 0 || index >= list->size) {
        printf("Index out of range\n");
        return -1;  // 返回-1表示查找失败
    }

    return list->data[index];
}

// 打印顺序表
void printSeqList(SeqList* list) {
    for (int i = 0; i < list->size; ++i) {
        printf("%d ", list->data[i]);
    }

    printf("\n");
}

// 释放顺序表
void freeSeqList(SeqList* list) {
    free(list->data);
    free(list);
}

int main() {
    SeqList* list = initSeqList(10);
    
    insert(list, 0, 1);
    insert(list, 1, 2);
    insert(list, 2, 3);
    printSeqList(list);
    
    remove(list, 1);
    printSeqList(list);
    
    update(list, 1, 10);
    printSeqList(list);
    
    int value = get(list, 1);
    printf("Element at index 1: %d\n", value);
    
    freeSeqList(list);
    return 0;
}