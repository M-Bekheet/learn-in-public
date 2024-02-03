#include <iostream>
#include <cmath>
using namespace std;

int set_powers(int base, int len)
{
  int result = 0;
  for (int i = 0; i <= len; i++)
    result += pow(base, i);
  return result;
}

int main()
{
  while (true)
  {
    cout << "Enter number: ";
    int len, base;
    cin >> base;
    cout << "Enter length: ";
    cin >> len;
    set_powers(base, len);
  }
}