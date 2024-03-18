#include <iostream>
using namespace std;

/*
  Function Template Specialization.
  - Notice the signature changes from type T a to string so the template that matched the signature was called.
  - Overloading is used when we want to achieve different behavior based on different datatypes (different parameters & different behavior)
- Template Specialization: identical behavior for different datatypes
 */

template <class T>
T multiply(T a, int factor)
{
  return a * factor;
}

template <>
string multiply(string str, int factor)
{
  string res = "";
  while (factor--)
    res += str;
  return res;
}

int main()
{
  cout << multiply(2, 3) << endl;
  cout << multiply(string("bla"), 3) << endl;
}