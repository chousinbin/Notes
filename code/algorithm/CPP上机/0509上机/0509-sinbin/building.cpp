#include "building.h"
using namespace std;

building::building(const std::string& name, int floor, double area)
	: bname(name), bfloors(floor), bareas(area) {}
	
void building::print() const
{
	cout << "bname: " << bname << ' ' << "bfloors: " << bfloors
	 << ' ' << "bareas: " << bareas << endl;
} 


