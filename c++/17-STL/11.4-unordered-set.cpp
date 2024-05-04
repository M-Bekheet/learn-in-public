#include <iostream>
#include <unordered_set>
#include <set>
#include <algorithm>
using namespace std;

/*
  - Unordered Set: No Preserved Order, but Unique Values
  - Unordered Set is very FAST in comparison to sets maps (erase, find, ..) as its based on Hash Tables
  - You cannot change an item value in the set, but you can erase it and add another one instead
  - There's also an unordered_multiset
 */
int main()
{
  unordered_set<int> s1{20, 10, 20, 5, 30};
  s1.insert(7);
  s1.insert(0);

  for (auto v : s1)
    cout << v << " "; // 0 7 30 5 10 20
  cout << "\n";

  /*
    Remember, `find` is FAST as it considers the internal representation of the unordered list
    A rule of thumb here: if your DS has an internal function such as my_unordered_set.find(target), use it.
    Unlike find(my_unordered_set.begin(), my_unordered_list.end(), target)
  */
  auto it1 = s1.find(20);
  cout << *it1 << "\n"; // 20
  // *it = 30; // CAN'T change it

  auto it2 = find(s1.begin(), s1.end(), 20); // SLOW as it doesn't consider the internal representation of the unordered list
  cout << *it2 << "\n";

  cout << s1.size() << "\n"; // 6
  s1.erase(s1.begin());
  cout << s1.size() << "\n"; // 5

  cout << "=============\n";

  int arr[]{20, 10, 20, 5, 30, 7, 0};
  unordered_set<int> s2(arr, arr + 3); // Shall be explained in pointers
  for (auto v : s2)
    cout << v << " "; //  10 20
  cout << "\n";

  // swapping
  s1.swap(s2);
  for (auto v : s2)
    cout << v << " "; // 7 30 5 10 20
  cout << "\n";
}