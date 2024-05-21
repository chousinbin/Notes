#include<stdio.h>
#include<stdlib.h>
#include<time.h>
int main()
{
	srand(time(0));
	
	int i=0;
	int number;
	int n=rand()%100;
	
	scanf("%d",&number);
	while(n!=number){
		if(number<n){
			printf("您的数小了！\n"); 
		}else if(number>n){
			printf("您的数大了！\n");
		}
		scanf("%d",&number);
		i++;
	}
	printf("%d",i);
	return 0;
 } 
