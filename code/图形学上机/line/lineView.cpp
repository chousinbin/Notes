// lineView.cpp : implementation of the CLineView class
//
#include "stdafx.h"
#include "line.h"

#include "lineDoc.h"
#include "lineView.h"

#include "math.h"

#ifdef _DEBUG
#define new DEBUG_NEW
#undef THIS_FILE
static char THIS_FILE[] = __FILE__;
#endif

/////////////////////////////////////////////////////////////////////////////
// CLineView

IMPLEMENT_DYNCREATE(CLineView, CView)

BEGIN_MESSAGE_MAP(CLineView, CView)
	//{{AFX_MSG_MAP(CLineView)
	ON_COMMAND(ID_hanshu, Onhanshu)
	ON_COMMAND(ID_sanjiao, Onsanjiao)
	ON_COMMAND(ID_fangzi, Onfangzi)
	ON_COMMAND(ID_dda, Ondda)
	ON_COMMAND(ID_bre, Onbre)
	ON_COMMAND(ID_huayuan, Onhuayuan)
	ON_COMMAND(ID_yuantu, Onyuantu)
	ON_COMMAND(ID_pingyi, Onpingyi)
	ON_COMMAND(ID_xuanzhaun, Onxuanzhaun)
	ON_COMMAND(ID_suofang, Onsuofang)
	ON_COMMAND(ID_fuhesanjiao, Onfuhesanjiao)
	ON_COMMAND(ID_dingdianxuanzhuan, Ondingdianxuanzhuan)
	ON_COMMAND(ID_zhongxinxuanzhuan, Onzhongxinxuanzhuan)
	ON_COMMAND(ID_duichenyuan, Onduichenyuan)
	ON_COMMAND(ID_duicheny, Onduicheny)
	//}}AFX_MSG_MAP
	// Standard printing commands
	ON_COMMAND(ID_FILE_PRINT, CView::OnFilePrint)
	ON_COMMAND(ID_FILE_PRINT_DIRECT, CView::OnFilePrint)
	ON_COMMAND(ID_FILE_PRINT_PREVIEW, CView::OnFilePrintPreview)
END_MESSAGE_MAP()

/////////////////////////////////////////////////////////////////////////////
// CLineView construction/destruction

CLineView::CLineView()
{
	// TODO: add construction code here

}

CLineView::~CLineView()
{
}

BOOL CLineView::PreCreateWindow(CREATESTRUCT& cs)
{
	// TODO: Modify the Window class or styles here by modifying
	//  the CREATESTRUCT cs

	return CView::PreCreateWindow(cs);
}

/////////////////////////////////////////////////////////////////////////////
// CLineView drawing

void CLineView::OnDraw(CDC* pDC)
{
	CLineDoc* pDoc = GetDocument();
	ASSERT_VALID(pDoc);
	// TODO: add draw code for native data here
}

/////////////////////////////////////////////////////////////////////////////
// CLineView printing

BOOL CLineView::OnPreparePrinting(CPrintInfo* pInfo)
{
	// default preparation
	return DoPreparePrinting(pInfo);
}

void CLineView::OnBeginPrinting(CDC* /*pDC*/, CPrintInfo* /*pInfo*/)
{
	// TODO: add extra initialization before printing
}

void CLineView::OnEndPrinting(CDC* /*pDC*/, CPrintInfo* /*pInfo*/)
{
	// TODO: add cleanup after printing
}

/////////////////////////////////////////////////////////////////////////////
// CLineView diagnostics

#ifdef _DEBUG
void CLineView::AssertValid() const
{
	CView::AssertValid();
}

void CLineView::Dump(CDumpContext& dc) const
{
	CView::Dump(dc);
}

CLineDoc* CLineView::GetDocument() // non-debug version is inline
{
	ASSERT(m_pDocument->IsKindOf(RUNTIME_CLASS(CLineDoc)));
	return (CLineDoc*)m_pDocument;
}
#endif //_DEBUG

/////////////////////////////////////////////////////////////////////////////
// CLineView message handlers

void CLineView::Onhanshu() 
{
	// TODO: Add your command handler code here
	CDC*pDC=GetDC();
	pDC->MoveTo(100,100);
	pDC->LineTo(400,400);
	pDC->TextOut(100,100,"软工212-01-周新斌");
	ReleaseDC(pDC);
}

void CLineView::Onsanjiao() 
{
	// TODO: Add your command handler code here
	CDC*pDC=GetDC();
	pDC->MoveTo(100,100);
	pDC->LineTo(200,300);
	pDC->LineTo(300,100);
	pDC->LineTo(100,100);
	pDC->TextOut(200,300,"201周新斌画三角");
	ReleaseDC(pDC);
}

void CLineView::Onfangzi() 
{
	// TODO: Add your command handler code here
	// 房顶
	CDC*pDC=GetDC();
	pDC->MoveTo(100,300); // 左下
	pDC->LineTo(200,100); // 顶点
	pDC->LineTo(300,300); // 右下
	pDC->LineTo(100,300);
	// 主体
	CDC*pDC2=GetDC();
	pDC2->MoveTo(100,300);
	pDC2->LineTo(100,500);
	pDC2->LineTo(300,500);
	pDC2->LineTo(300,300);
	// 门
	CDC*pDC3=GetDC();
	pDC3->MoveTo(175,500);
	pDC3->LineTo(225,500);
	pDC3->LineTo(225,400);
	pDC3->LineTo(175,400);
	pDC3->LineTo(175,500);


}

void CLineView::Ondda() 
{
	// TODO: Add your command handler code here
	
	CDC *pDC = GetDC();
	pDC->TextOut(50, 50, "软工212-01-周新斌");
	int k;
	double x1 = 50, y1 = 50, x2 = 300, y2 = 350;
	double x, y, deltx, delty, len;
	if(fabs(x2 - x1) >= fabs(y2 - y1))
		len = fabs(x2 - x1);
	else
		len = fabs(y2 - y1);
	
	deltx = (x2 - x1) / len;
	delty = (y2 - y1) / len;

	x  = x1, y = y1, k = 1;
	while(k <= len)
	{
		pDC->SetPixel((int)x, (int)y, RGB(255, 0, 0));
		x += deltx;
		y += delty;
		k += 1;
		Sleep(10);
	}
	pDC->TextOut(300, 350, "软工212-01-周新斌");
	ReleaseDC(pDC);
}

void CLineView::Onbre() 
{
	// TODO: Add your command handler code here

	CDC* pDC = GetDC();

	pDC->TextOut(10, 10, "软工212-01-周新斌");

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
				if(k == 1 + abs((int)deltx) >> 1)
				{
					pDC->TextOut((int)x, (int)y, "软工212-01-周新斌");
				}
				pDC->SetPixel((int)x, (int)y, RGB(2, 9, 22));
				E += 2 * delty;
				if(E >= 0)
				{
					y++;
					E -= 2 * deltx;
				}				
				x = x + 1;
				Sleep(10);
			}
		} 
	}
	pDC->TextOut(100, 150, "软工212-01-周新斌");
	ReleaseDC(pDC);
}

void CLineView::Onhuayuan() 
{
	// TODO: Add your command handler code here

	CDC* pDC = GetDC();

	pDC->TextOut(10, 10, "软工212-01-周新斌");

	double xc = 200, yc = 200, r = 80;
	double x = 0, y = r, p = 1 - r;

	while(x <= y)
	{
		if(p < 0)
		{
			p += 2 * x + 1;
		}
		else
		{
			p += 2 * x - 2 * y + 1;
			y--;
		}

		x++;
		
		pDC->SetPixel((int)(xc + x), (int)(yc + y), RGB(110, 155, 197));
		pDC->SetPixel((int)(xc - x), (int)(yc + y), RGB(110, 155, 197));
		pDC->SetPixel((int)(xc + x), (int)(yc - y), RGB(110, 155, 197));
		pDC->SetPixel((int)(xc - x), (int)(yc - y), RGB(110, 155, 197));
		pDC->SetPixel((int)(xc + y), (int)(yc + x), RGB(110, 155, 197));
		pDC->SetPixel((int)(xc - y), (int)(yc + x), RGB(110, 155, 197));
		pDC->SetPixel((int)(xc + y), (int)(yc - x), RGB(110, 155, 197));
		pDC->SetPixel((int)(xc - y), (int)(yc - x), RGB(110, 155, 197));

		Sleep(10);

	}
	ReleaseDC(pDC);
}

void CLineView::Onyuantu() 
{
	// TODO: Add your command handler code here
	CDC*pDC=GetDC();

	pDC->MoveTo(100,100);
	pDC->LineTo(200,300);
	pDC->LineTo(300,100);
	pDC->LineTo(100,100);

	pDC->TextOut(200,300,"201周新斌 - 三角原图");

	ReleaseDC(pDC);
}

void CLineView::Onpingyi() 
{
	// TODO: Add your command handler code here
	int x[3] = {100, 200, 300};
	int y[3] = {100, 300, 100};
	
	int dx = 150, dy = 150;

	for(int i = 0; i < 3; i++)
		x[i] += dx, y[i] += dy;

	CDC*pDC=GetDC();
	pDC->MoveTo(x[2],y[2]);

	for(int j = 0; j < 3; j++)
		pDC->LineTo(x[j], y[j]);
	
	pDC->TextOut(x[1],y[1],"201周新斌 - 三角平移");
	
}

void CLineView::Onxuanzhaun() 
{
	// TODO: Add your command handler code here

	int x[3] = {100, 200, 300};
	int y[3] = {100, 300, 100};

	double a = 0.4;

	for(int i = 0; i < 3; i++)
		x[i] = x[i] * cos(a) - y[i] * sin(a), y[i] = x[i] * sin(a) + y[i] * cos(a);
	
	CDC*pDC=GetDC();
	pDC->MoveTo(x[2],y[2]);

	for(int j = 0; j < 3; j++)
		pDC->LineTo(x[j], y[j]);
	
	pDC->TextOut(x[1],y[1],"201周新斌 - 三角旋转");
}

void CLineView::Onsuofang() 
{
	// TODO: Add your command handler code here
	double x[3] = {100, 200, 300};
	double y[3] = {100, 300, 100};
	
	double sx = 0.5, sy = 0.5;

	for(int i = 0; i < 3; i++)
		x[i] *= sx, y[i] *= sy;

	CDC*pDC=GetDC();
	pDC->MoveTo((int)x[2],(int)y[2]);

	for(int j = 0; j < 3; j++)
		pDC->LineTo((int)x[j], (int)y[j]);
	
	pDC->TextOut(x[1],y[1],"201周新斌 - 三角缩放");
	
}

void CLineView::Onfuhesanjiao() 
{
	// TODO: Add your command handler code here
	CDC*pDC=GetDC();

	pDC->MoveTo(100,100);
	pDC->LineTo(200,300);
	pDC->LineTo(300,100);
	pDC->LineTo(100,100);

	pDC->TextOut(200,300,"201周新斌 - 三角原图");

	ReleaseDC(pDC);
	
}

void CLineView::Ondingdianxuanzhuan() 
{
	// TODO: Add your command handler code here
	CDC*pDC=GetDC();
	double x1 = 100, y1 = 100;
	double x2 = 200, y2 = 300;
	double x3 = 300, y3 = 100;

	double a = -0.3;
	double dx = 100, dy = 100;

	x1 = cos(a) * x1 - sin(a) * y1 + (dx * (1 - cos(a)) + dy * sin(a));
	y1 = sin(a) * x1 + cos(a) * y1 + (dy * (1 - cos(a)) - dx * sin(a));

	x2 = cos(a) * x2 - sin(a) * y2 + (dx * (1 - cos(a)) + dy * sin(a));
	y2 = sin(a) * x2 + cos(a) * y2 + (dy * (1 - cos(a)) - dx * sin(a));

	x3 = cos(a) * x3 - sin(a) * y3 + (dx * (1 - cos(a)) + dy * sin(a));
	y3 = sin(a) * x3 + cos(a) * y3 + (dy * (1 - cos(a)) - dx * sin(a));

	pDC->MoveTo((int)x3,(int)y3);
	pDC->LineTo((int)x1,(int)y1);
	pDC->LineTo((int)x2,(int)y2);
	pDC->LineTo((int)x3,(int)y3);

	pDC->TextOut((int)x2,(int)y2,"201周新斌 - 顶点旋转");

}

void CLineView::Onzhongxinxuanzhuan() 
{
	// TODO: Add your command handler code here
	CDC*pDC=GetDC();
	double x1 = 100, y1 = 100;
	double x2 = 200, y2 = 300;
	double x3 = 300, y3 = 100;

	double xf = (x1 + x2 + x3) / 3;
	double yf = (y1 + y2 + y3) / 3;
	
	double sx = 0.5, sy = 0.5;

	x1 = sx * x1 + xf * (1 - sx);
	y1 = sy * y1 + yf * (1 - sy);
	x2 = sx * x2 + xf * (1 - sx);
	y2 = sy * y2 + yf * (1 - sy); 
	x3 = sx * x3 + xf * (1 - sx);
	y3 = sy * y3 + yf * (1 - sy); 
	
	pDC->MoveTo((int)x3,(int)y3);
	pDC->LineTo((int)x1,(int)y1);
	pDC->LineTo((int)x2,(int)y2);
	pDC->LineTo((int)x3,(int)y3);

	pDC->TextOut((int)x3,(int)y3,"201周新斌 - 重心缩放");

}

void CLineView::Onduichenyuan() 
{
	// TODO: Add your command handler code here

	CDC*pDC=GetDC();

	pDC->MoveTo(50,300);
	pDC->LineTo(100,400);
	pDC->LineTo(150,300);
	pDC->LineTo(50,300);

	//pDC->TextOut(200,300,"201周新斌 - 三角原图");

	ReleaseDC(pDC);
}

void CLineView::Onduicheny() 
{
	// TODO: Add your command handler code here
	
	// 关于 y = x + 50 对称
	double b = 50;

	// 画y = x + 50 线
	CDC* pDC2 = GetDC();
	pDC2->MoveTo(0, 50);
	pDC2->LineTo(1000, 1050);
	pDC2->TextOut(300, 350,"201周新斌 - y = x + 50");

	// 初始化原始三角形数据
	double x[] = {50, 100, 150};
	double y[] = {300, 400, 300};
	

	for(int i = 0; i < 3; i++)
	{
		// 平移
		y[i] -= b;
		// 关于 y = x 轴对称
		double tmp = x[i];
		x[i] = y[i];
		y[i] = tmp;
		// 逆平移
		y[i] += b;
	}

	// 画图
	CDC*pDC=GetDC();
	pDC->MoveTo((int)x[2], (int)y[2]);
	for(int j = 0; j < 3; j++)
		pDC->LineTo((int)x[j], (int)y[j]);

	pDC->TextOut((int)x[1],(int)y[1],"201周新斌 - 对称变换");

	ReleaseDC(pDC);
	ReleaseDC(pDC2);
}
