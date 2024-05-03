#include <iostream>
#include <deque>
using namespace std;

int main()
{
  int arr[]{1, 2, 3, 4, 5};

  for (auto val : arr) // range loop
    cout << val << " ";

  cout << "\n";

  deque<int> dq{2, 4, 5, 8, 10};

  for (const auto &val : dq) // &val by reference (more efficient), but if you update the val, the dq will be updated. But as you're using const, it will make sure that you're not changing the value
    cout << val << " ";

  cout << endl;

  for (auto val : {100, 200, 300})
    cout << val << " ";

  cout << endl;

  for (auto val : "Hello World")
    cout << val << " ";
}