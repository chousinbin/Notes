#include <stdio.h>
int main(){
    const int size=3;
    int board[size][size];
    int i,j;
    int numOfX;//����
    int numOfO;//����
    int numOfX2;
    int numOfO2;
    int result=-1;//-1û��Ӯ 1:����Ӯ 0:����Ӯ
    //�������
    for(i=0;i<size;i++){
        for(j=0;j<size;j++){
            scanf("%d",&board[i][j]);
        }
    }
    if(result==-1){
     //�����,��
        for(j=0;j<size&&result==-1;j++){
        //ֻ��������ǰ��λ��,�����������
        numOfO=numOfX=0;
        numOfO2=numOfX2=0;
        for(i=0;i<size;i++){
            if(board[j][i]==1){
                numOfX++;
            }else{
                numOfO++;
            }
        }
        for(i=0;i<size;i++){
                if(board[i][j]==1){
                    numOfX2++;
                }else{
                    numOfO2++;
                }
            }
        if(numOfX==size||numOfX2==size){
            result=1;
        }else if(numOfO==size||numOfO2==size){
            result=0;
        }
    }
}
    //���Խ���
    if(result==-1){
        for(j=1;j<size;j++){
            numOfO=numOfX=0;
            numOfO2=numOfX2=0;
            for(i=0;i<size;i++){
                if(board[i][i]==1){
                    numOfX++;
                }else{
                    numOfO++;
                }
            }
            for(i=0;i<size;i++){
                if(board[i][size-i-1]==1){
                    numOfX2++;
                }else{
                    numOfO2++;
                }
            }
            if(numOfX==size||numOfX2==size){
                result=1;
            }else if(numOfO==size||numOfO2==size){
                result=0;
            }
        }
    }
    if(result==1){
        printf("����ʤ");
    }else if(result==0){
        printf("����ʤ");
    }else{
        printf("˭��û��ʤ��");
    }
}
