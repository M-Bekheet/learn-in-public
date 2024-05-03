#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;

void print(vector<int> v)
{
  for (int &val : v)
    cout << val << " ";
  cout << "\n";
}

/* C++ like other programming languages, has some built-in functions that use algorithms */

int main()
{
  vector<int> v({5, 9, 6, 10, 4, 7, 8});

  // sort(v.begin(), v.end());
  // print(v); // 4 5 6 7 8 9 10

  sort(v.begin() + 1, v.end()); // 5 4 6 7 8 9 10 >> starts from index 1
  print(v);

  // Reverse Sort
  sort(v.rbegin(), v.rend()); // 10 9 8 7 6 5 4
  print(v);
}