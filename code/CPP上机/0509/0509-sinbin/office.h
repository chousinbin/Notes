#ifndef OFFICE_H
#define OFFICE_H

#include "building.h"
using namespace std;

class office : public building
{
	int offices;
    int meetingrooms;
	public:
	    office(const std::string& name, int floor, double area, int office, int meetingroom);
	    void print() const override;
};

#endif
