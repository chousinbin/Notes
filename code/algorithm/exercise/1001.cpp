#include<stdio.h>
int main()
{
	int num=5;
	int *p=&num;
	int **r=&p;
	
	printf("  p=%p\n",p);//ָ��pΪnum=5�ĵ�ַ 
	printf(" *p=%d\n",*p);// *pΪָ��num=5��ָ�� 
	printf(" *r=%p\n",*r);//r Ϊָ��p�ĵ�ַ ��*rΪָ��ָ��p�����ݴ����num=5�ĵ�ַ 
	printf("**r=%d\n",**r);//**rָ��ָ��p pָ��num=5 
	return 0;
}
