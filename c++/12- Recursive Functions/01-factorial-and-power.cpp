#include <iostream>
using namespace std;

// Follow What Not How Strategy to get what is being done in recursion
int factorial(int n)
{
  if (n == 1)
    return 1;
  return n * factorial(n - 1);
}

int power(int value, int p = 2)
{
  if (p == 0)
    return 1;
  return value * power(value, p - 1);
}

int main()
{

  cout << factorial(4) << endl;
  cout << power(5, 3) << endl;
  cout << power(3) << endl;
}