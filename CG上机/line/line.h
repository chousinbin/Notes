// line.h : main header file for the LINE application
//

#if !defined(AFX_LINE_H__BFE35548_81EF_45F4_9CC0_1E8AF7FF8555__INCLUDED_)
#define AFX_LINE_H__BFE35548_81EF_45F4_9CC0_1E8AF7FF8555__INCLUDED_

#if _MSC_VER > 1000
#pragma once
#endif // _MSC_VER > 1000

#ifndef __AFXWIN_H__
	#error include 'stdafx.h' before including this file for PCH
#endif

#include "resource.h"       // main symbols

/////////////////////////////////////////////////////////////////////////////
// CLineApp:
// See line.cpp for the implementation of this class
//

class CLineApp : public CWinApp
{
public:
	CLineApp();

// Overrides
	// ClassWizard generated virtual function overrides
	//{{AFX_VIRTUAL(CLineApp)
	public:
	virtual BOOL InitInstance();
	//}}AFX_VIRTUAL

// Implementation
	//{{AFX_MSG(CLineApp)
	afx_msg void OnAppAbout();
		// NOTE - the ClassWizard will add and remove member functions here.
		//    DO NOT EDIT what you see in these blocks of generated code !
	//}}AFX_MSG
	DECLARE_MESSAGE_MAP()
};


/////////////////////////////////////////////////////////////////////////////

//{{AFX_INSERT_LOCATION}}
// Microsoft Visual C++ will insert additional declarations immediately before the previous line.

#endif // !defined(AFX_LINE_H__BFE35548_81EF_45F4_9CC0_1E8AF7FF8555__INCLUDED_)
