#include <iostream>
#include <set>
using namespace std;

int way_num = 2;
struct employee
{
  int num1, num2;
  string str;

  employee(int a, int b, string name)
  {
    num1 = a, num2 = b, str = name;
  }

  // This overrides the internal comparison that is used when comparing instances of the employee (e.g. emp1 > emp2)
  bool operator<(const employee &rhs) const // rhs stands for Right Hand Side
  {
    // First Way to do that: Comparison
    if (way_num == 1)
    {
      if (num1 != rhs.num1)
        return num1 < rhs.num1;
      if (str != rhs.str)
        return str < rhs.str;
      return num2 < rhs.num2;
    }
    // Second Way: Pair Method
    else if (way_num == 2)
    {
      return make_pair(num1, make_pair(str, num2)) < make_pair(rhs.num1, make_pair(rhs.str, rhs.num2));
    }

    // Third Way: The way to go (uses tie)
    else
      return tie(num1, str, num2) < tie(rhs.num1, rhs.str, rhs.num2);
  }
};

int main()
{
  employee a(12, 20, "Khaled");
  employee b(12, 20, "Adam");
  employee c(12, 12, "Zack");

  cout << (a < b) << "\n"; // False as Khaled > Adam
  cout << (a < c) << "\n"; // True as Khaled < Zack ( remember we're comparing the str before num2 )
  cout << (b < c) << "\n"; // True as Adam < Zack

  cout << "===============\n";

  // Make a set of employees
  set<employee> s;
  s.insert(a);
  s.insert(employee(8, 9, "Ali"));
  s.insert(employee(4, 10, "Haneen"));

  for (auto emp : s)
    cout << emp.num1 << " " << emp.str << " " << emp.num2 << "\n";
}