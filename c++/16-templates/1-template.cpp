#include <iostream>
using namespace std;

template <typename T>
T MyMax(T a, T b)
{
  if (a > b)
    return a;
  return b;
}

template <class Type1, class Type2>
Type1 Sum(Type1 a, Type2 b)
{
  Type1 r = a + b;
  return r;
}

int main()
{
  cout << MyMax(1.3, 3.8) << "\n"; // 3.8 (compiler could tell that they're double)
  // cout << MyMax(1, 3.8) << "\n";           // (compiler could NOT tell their type)
  cout << MyMax<double>(1.3, 3.8) << "\n"; // 3.8
  cout << MyMax<int>(1.3, 3.8) << "\n";    // 3 (warning)
  cout << MyMax('A', 'B');

  cout << "\n===============\n";
  cout << Sum(1, 3) << "\n";
  cout << Sum(1.3, 4.0) << "\n";           // 5.3
  cout << Sum<int, int>(1.3, 4.0) << "\n"; // <int, int> forced Type1 & Type2 to be int >> 5
  cout << Sum(string("I am "), string("Mahmoud")) << "\n";
  cout << Sum('A', 1) << "\n"; // Returns 'A' Type which is Character >> B
  cout << Sum(1, 'A') << "\n"; // Returns 1 Type which = 1 + Ascii code of A (62) >> 65
}