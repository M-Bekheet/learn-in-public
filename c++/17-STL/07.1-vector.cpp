#include <iostream>
#include <vector>
using namespace std;

/*
  - vector is a dynamic size array. It's more like ArrayList in Java.
  - Other than the size(), it has a dynamic capacity that gets doubled whenever the size(count) of elements we need to insert are more than the current capacity.
  - The process is like that: double the capacity, copy all old vector elements, and add the new elements
  Performance Tips:
    - The aforementioned process is not performant specially if the capacity changes a lot.
    - So if we already know the target size of the vector, initialize it with the current size: vector<int> my_vector(100000); // my_vector.size() yields to 100000 now
    - If I only know an initial estimate of required capacity, then reserve it only: vector<int> my_vector; my_vector.reserve(50000); // capacity = 50000, but size = 0;
 */
int main()
{
  vector<int> v1;
  v1.push_back(5);
  v1.push_back(8);
  v1.push_back(9);

  for (int i = 0; i < (int)v1.size(); i++)
    cout << v1[i] << " ";

  cout << endl;

  // Different way to define vector.
  vector<int> v2(5, 7); // length = 5 & all elements filled with 7

  for (int i = 0; i < (int)v2.size(); i++)
    cout << v2[i] << " ";
  cout << "\n=====================\n";

  v2.push_back(9);
  for (const auto &val : v2)
    cout << val << " ";
  cout << "\n=====================\n";

  // Example for erasion: remove all negative values;

  vector<int>
      v3{-1, 2, 8, -12, 11, 11, 14, -9};
  for (auto it = v3.begin(); it < v3.end();)
  {
    if (*it < 0)
    {
      // You MUST use the returned iterator as `erase` will invalidate the removed one
      // This way works only on some Data Structures only
      it = v3.erase(it);
    }
    else
      it++;
  }

  for (const auto &val : v3)
    cout << val << " ";

  cout << "\n=====================\n";

  // Example for insertion: replace the -2 element with other values

  vector<int>
      v4{8, -4, 2, 7, 3, -2, 5, 3, 1, 9};
  auto it = find(v4.begin(), v4.end(), -2);

  bool found = it != v4.end();
  if (found)
  {
    vector<int> v_to_insert{10, 20, 30};
    v4.insert(it, v_to_insert.begin(), v_to_insert.end());
  }

  for (auto const &val : v4)
    cout << val << " "; // 8 -4 2 7 3 10 20 30 -2 5 3 1 9
  cout << endl;
}