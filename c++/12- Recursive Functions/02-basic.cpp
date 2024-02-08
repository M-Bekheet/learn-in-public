#include <iostream>
using namespace std;

int factorial(int n)
{
  if (n < 2)
    return 1;
  return n * factorial(n - 1);
}


int print_3n_plus_1(int n)
{
  cout << n << " ";
  if (n == 1)
    return 1;

  if (n % 2 == 0)
    return print_3n_plus_1((n * 1.0) / 2);
  else
    return print_3n_plus_1(3.0 * n + 1);
}

// There's a better solution below - without an external `len` variable
int len = 0;
int get_3n_plus_1_length(int n)
{
  len++;
  if (n == 1)
    return len;
  if (n % 2 == 0)
    return get_3n_plus_1_length(n / 2);
  return get_3n_plus_1_length(3 * n + 1);
}

int BETTER_get_3n_plus_1_length(int n)
{
  if (n == 1)
    return 1;

  if (n % 2 == 0)
    return 1 + BETTER_get_3n_plus_1_length(n / 2);
  return 1 + BETTER_get_3n_plus_1_length(3 * n + 1);
}

int main()
{
  print_3n_plus_1(3);
  cout << endl;
  cout << get_3n_plus_1_length(3);
  cout << endl;
}