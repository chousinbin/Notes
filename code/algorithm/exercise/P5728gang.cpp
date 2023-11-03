#include <iostream>
using namespace std;

int main()
{
 int num,n1,n2,m,couple,ret,tot1,tot2,n,score1;
 cin >> num;
 m = num;
 couple = 0;
 int score[num][3] = {0};
 for(n = 0;n < num;n ++)
 {
  for(m = 0;m < 3;m ++)
  {
   cin >> score[n][m];
  }
 }
 for(n1 = 0;n1 < num-1;n1 ++)//每人遍历 
 {
  for(n2 = n1+1;n2 < num;n2 ++)
  {
   ret = 0;
  
   for(m = 0;m < 3;m ++)//单科比较
   {
    score1 = score[n1][m] - score[n2][m];
     if(score1 < -5 ||score1 > 5) 
    {
     ret = 1;
     break;
    }
   } 
   
   tot1 = tot2 = 0;
   for(m = 0;m < 3;m ++)//总成绩比较 
   {
    tot1 +=score[n1][m];
    tot2 +=score[n2][m];
   }
   if(tot1 - tot2 > 10||tot1 - tot2 < -10)
   {
    ret = 1;
   }
    if(!ret)
   {
    couple ++;
   }
  } 
 }
 cout << couple;
 return 0;
}
