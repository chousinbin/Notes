#include<stdio.h>
#include<math.h>
int main()
{
	int N;
	scanf("%d",&N);
	int score[N][4];
	int i,n;
	for(i=0;i<N;i++)
	{
		for(n=0;n<3;n++)
		{
			scanf("%d",&score[i][n]);
		}
		score[i][3]=score[i][0]+score[i][1]+score[i][2];
	}
	int cnt=0,j;
	for(i=0;i<N;i++)
	{
		for(j=i+1;j<N;j++)
		{
			int x=abs(score[i][0]-score[j][0]);
			int y=abs(score[i][1]-score[j][1]);
			int z=abs(score[i][2]-score[j][2]);
			int t=abs(score[i][3]-score[j][3]);
			if(x<=5&&y<=5&&z<=5&&t<=10)
			cnt++;
		}
	}
	printf("%d\n",cnt);
	return 0;
}
