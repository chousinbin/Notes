// lineDoc.h : interface of the CLineDoc class
//
/////////////////////////////////////////////////////////////////////////////

#if !defined(AFX_LINEDOC_H__C6310E83_55D8_49F2_AD1F_20B127120CFB__INCLUDED_)
#define AFX_LINEDOC_H__C6310E83_55D8_49F2_AD1F_20B127120CFB__INCLUDED_

#if _MSC_VER > 1000
#pragma once
#endif // _MSC_VER > 1000


class CLineDoc : public CDocument
{
protected: // create from serialization only
	CLineDoc();
	DECLARE_DYNCREATE(CLineDoc)

// Attributes
public:

// Operations
public:

// Overrides
	// ClassWizard generated virtual function overrides
	//{{AFX_VIRTUAL(CLineDoc)
	public:
	virtual BOOL OnNewDocument();
	virtual void Serialize(CArchive& ar);
	//}}AFX_VIRTUAL

// Implementation
public:
	virtual ~CLineDoc();
#ifdef _DEBUG
	virtual void AssertValid() const;
	virtual void Dump(CDumpContext& dc) const;
#endif

protected:

// Generated message map functions
protected:
	//{{AFX_MSG(CLineDoc)
		// NOTE - the ClassWizard will add and remove member functions here.
		//    DO NOT EDIT what you see in these blocks of generated code !
	//}}AFX_MSG
	DECLARE_MESSAGE_MAP()
};

/////////////////////////////////////////////////////////////////////////////

//{{AFX_INSERT_LOCATION}}
// Microsoft Visual C++ will insert additional declarations immediately before the previous line.

#endif // !defined(AFX_LINEDOC_H__C6310E83_55D8_49F2_AD1F_20B127120CFB__INCLUDED_)
