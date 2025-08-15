#include "building.h"
#include "house.h"
#include "office.h"
#include <iostream>

/* run this program using the console pauser or add your own getch, system("pause") or input loop */

int main(int argc, char** argv) {
	building b("building", 1, 1.1);
	b.print();
	puts("");
	house h("house", 2, 2.2, 222, true);
	h.print();
	puts("");
	office o("office", 3, 3.3, 333, 3333);
	o.print();
	
	cout << sizeof(building) << endl; 
	cout << sizeof(bool) << endl;
	cout << sizeof(h) << endl;
	cout << sizeof(o) << endl;
	return 0;
}
