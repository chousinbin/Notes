#include "office.h"
using namespace std;

office::office(const std::string& name, int floor, double area, int office, int meetingroom)
    : building(name, floor, area), offices(office), meetingrooms(meetingroom) {}

void office::print() const
{
    building::print();
    cout << "offices: " << offices << ' ' << "meetrooms: " << meetingrooms << endl;
}
