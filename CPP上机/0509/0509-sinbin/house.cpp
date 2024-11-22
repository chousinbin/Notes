#include "house.h"
using namespace std;

house::house(const std::string& name, int floors, double areas, int rooms, bool balcony)
    : building(name, floors, areas), rooms(rooms), balcony(balcony) {}

void house::print() const
{
    building::print();
    cout << "rooms: " << rooms << ' ' << "balcony: " << balcony << endl;
}
