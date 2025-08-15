#ifndef HOUSE_H
#define HOUSE_H

#include "building.h"
using namespace std;

class house : public building
{
	int rooms;
	bool balcony;
	public:
		house(const std::string& name, int floors, double areas, int rooms, bool balcony);
    	void print() const override;
};

#endif
