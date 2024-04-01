#include <iostream>
#include <stack>
using namespace std;

/*
  Utilities: Start
*/
template <typename T>
void print(stack<T> s)
{
  while (!s.empty())
  {
    cout << s.top() << " ";
    s.pop();
  }
  cout << "\n";
}

/*
  Utilities: End
*/

/*
  Stack: LIFO Structure (Last In First Out)
 */
int main()
{
  stack<string> s;
  s.push("Bekheet");
  s.push("Mahmoud");
  print<string>(s); // Mahmoud Bekheet
}