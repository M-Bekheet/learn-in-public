#include <iostream>
using namespace std;

/*
   - The same of Function Templates, but used with `struct` instead of methods so that I don't have to repeat similar structs.
   - Overloading is used when we want to achieve different behavior based on different datatypes (different parameters & different behavior)
   - Template Specialization: identical behavior for different datatypes
 */

template <typename T>
struct MyQueue
{
  T arr[100];
  int pos;

  MyQueue() { pos = 0; }
  MyQueue(T param_arr[], int len) // using the T type in constructor
  {
    for (int i = 0; i < len; i++)
      arr[i] = param_arr[i];
    pos = len;
  }

  void add_front(T elem) // Using the T type
  {
    arr[pos++] = elem;
  }

  // new template
  template <typename S>
  void sum_and_add(S a, S b)
  {
    arr[pos++] = a + b;
  }

  void print()
  {
    for (int i = 0; i < pos; i++)
      cout << arr[i] << " ";
    cout << "\n";
  }
};

int main()
{
  MyQueue<string> q_str;
  q_str.add_front(string("Hello,"));
  q_str.sum_and_add(string("I am"), string(" Mahmoud"));
  q_str.add_front("and I am an engineer");
  q_str.print();

  MyQueue<int> q_dob;
  q_dob.add_front(5);
  q_dob.add_front(2);
  q_dob.sum_and_add<double>(2.5, 3.9);
  q_dob.print();
}