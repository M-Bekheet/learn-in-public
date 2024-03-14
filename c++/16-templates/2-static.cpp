#include <iostream>
using namespace std;

int global_var = 0;

// Using `static` makes the variable a static member that is memorized in its context. In other words, its value will not be lost when we call increment_me with the same T type
// One static variable for each generated function (for every different signature)

template <typename T>
void increment_me(T x)
{
  static int i = 0; // try it after removing the static keyword too
  cout << ++i << " " << ++global_var << "\n";
}

int main()
{

  increment_me(5); // 1 1
  increment_me(5); // 2 2
  increment_me(5); // 3 3

  cout << "==========\n";

  increment_me(3.6); // 1 4 >> New function as the signature changed from the int to double
  increment_me(3.6); // 2 5
  increment_me(3.6); // 3 6
  increment_me(3.6); // 4 7
  increment_me(3.6); // 5 8
  increment_me(3.6); // 6 9
  increment_me(200); // 4 10 >> this has the increment_me(5) signature so it builds on it
}