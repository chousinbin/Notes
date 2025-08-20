// lineView.h : interface of the CLineView class
//
/////////////////////////////////////////////////////////////////////////////

#if !defined(AFX_LINEVIEW_H__5221797A_CDEA_492C_9F3A_9D2E3663E07B__INCLUDED_)
#define AFX_LINEVIEW_H__5221797A_CDEA_492C_9F3A_9D2E3663E07B__INCLUDED_

#if _MSC_VER > 1000
#pragma once
#endif // _MSC_VER > 1000


class CLineView : public CView
{
protected: // create from serialization only
	CLineView();
	DECLARE_DYNCREATE(CLineView)

// Attributes
public:
	CLineDoc* GetDocument();

// Operations
public:

// Overrides
	// ClassWizard generated virtual function overrides
	//{{AFX_VIRTUAL(CLineView)
	public:
	virtual void OnDraw(CDC* pDC);  // overridden to draw this view
	virtual BOOL PreCreateWindow(CREATESTRUCT& cs);
	protected:
	virtual BOOL OnPreparePrinting(CPrintInfo* pInfo);
	virtual void OnBeginPrinting(CDC* pDC, CPrintInfo* pInfo);
	virtual void OnEndPrinting(CDC* pDC, CPrintInfo* pInfo);
	//}}AFX_VIRTUAL

// Implementation
public:
	virtual ~CLineView();
#ifdef _DEBUG
	virtual void AssertValid() const;
	virtual void Dump(CDumpContext& dc) const;
#endif

protected:

// Generated message map functions
protected:
	//{{AFX_MSG(CLineView)
	afx_msg void Onhanshu();
	afx_msg void Onsanjiao();
	afx_msg void Onfangzi();
	afx_msg void Ondda();
	afx_msg void Onbre();
	afx_msg void Onhuayuan();
	afx_msg void Onyuantu();
	afx_msg void Onpingyi();
	afx_msg void Onxuanzhaun();
	afx_msg void Onsuofang();
	afx_msg void Onfuhesanjiao();
	afx_msg void Ondingdianxuanzhuan();
	afx_msg void Onzhongxinxuanzhuan();
	afx_msg void Onduichenyuan();
	afx_msg void Onduicheny();
	afx_msg void Oncohen();
	//}}AFX_MSG
	DECLARE_MESSAGE_MAP()
};

#ifndef _DEBUG  // debug version in lineView.cpp
inline CLineDoc* CLineView::GetDocument()
   { return (CLineDoc*)m_pDocument; }
#endif

/////////////////////////////////////////////////////////////////////////////

//{{AFX_INSERT_LOCATION}}
// Microsoft Visual C++ will insert additional declarations immediately before the previous line.

#endif // !defined(AFX_LINEVIEW_H__5221797A_CDEA_492C_9F3A_9D2E3663E07B__INCLUDED_)
