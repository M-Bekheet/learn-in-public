#include <iostream>
using namespace std;

int max(int a, int b)
{
  if (a >= b)
    return a;
  return b;
}
int max(int a, int b, int c)
{
  if (max(a, b) > c)
    return max(a, b);
  return c;
}
int max(int a, int b, int c, int d)
{
  if (max(a, b, c) > d)
    return max(a, b, c);
  return d;
}
int max(int a, int b, int c, int d, int e)
{
  if (max(a, b, c, d) > e)
    return max(a, b, c, d);
  return e;
}
int max(int a, int b, int c, int d, int e, int f)
{
  if (max(a, b, c, d, e) > f)
    return max(a, b, c, d, e);
  return f;
}

int main()
{
  cout << max(1, 10) << "\n";
  cout << max(2, 7, 1) << "\n";
  cout << max(10, 3, 5, 1) << "\n";
  cout << max(1, 2, 100, 3) << "\n";
  cout << max(1, 1, 1, 1, 1) << "\n";
}