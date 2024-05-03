#include <iostream>
#include <stack>
using namespace std;

int main()
{
  /*
     - `pair` structure is a pair of 2 values that can be of any datatype
     - It's like a special case of `tuple` data type as it only holds 2 items
     - Comparison, is done by properties one after another.
   */
  pair<string, int> p = make_pair("Age", 40);
  cout << p.first << endl;  // "Age"
  cout << p.second << endl; // 40

  pair<string, pair<string, int>> p2 = make_pair("Worker", p);
  cout << p2.first << endl;         // Worker
  cout << p2.second.first << endl;  // Age
  cout << p2.second.second << endl; // 40

  stack<pair<int, string>> numbers;
  numbers.push(make_pair(1, "One"));
  numbers.push(make_pair(2, "Two"));
  cout << numbers.top().first << endl;  // 2
  cout << numbers.top().second << endl; // Two
}