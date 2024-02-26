#include <iostream>
using namespace std;

struct MaintenanceHistory
{
  string description;
  string date;
  double price;
};

struct Car
{
  string model;
  MaintenanceHistory history[200]{};
};

struct Location
{
  string name;
  string address;
  Car new_cars[200]{};
  Car used_cars[200]{};
};

struct Honda
{
  Location locations[200]{};
};

int main()
{
}