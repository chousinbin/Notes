#include<bits/stdc++.h>
using namespace std;

int main()
{
	CDC* pDC = GetDC();
	int k;
	double x1 = 10, y1 = 10, x2 = 200, y2 = 150;
	double x, y, deltx, delty, E;
	deltx = x2 - x1, delty = y2 - y1;
	x = x1, y = y1;
	
	if(deltx > 0 && delty > 0)
	{
		if(fabs(deltx) > fabs(delty))
		{
			E = -deltx;
			for(int k = 1; k <= abs((int)deltx); k++)
			{
				pDC->SetPixel((int)x, (int)y, RGB(2, 9, 22));
				E += 2 * delty;
				if(E >= 0)
				{
					y++;
					E -= 2 * deltx;
				}				
				x++;
				Sleep(10);
			}
		} 
	}
	ReleaseDC(pDC);
}
