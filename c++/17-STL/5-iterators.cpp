#include <iostream>
#include <queue>
using namespace std;

/*
  Iterator: is an object looking at the index that holds the position of the element that we need to deal with
  We cannot use them on queue, stack, and priority_queue. Although we can iterate on many DS such as strings
 */

void print(deque<int> &my_dq)
{
  /* This way is destructive if my_dq isn't a deep copy (if it's passed by reference) */
  // while (my_dq.front())
  // {
  //   cout << my_dq.front() << " ";
  //   my_dq.pop_front();
  // }

  // The Iterator way:
  deque<int>::iterator it = my_dq.begin(); // iterator here
  // my_dq.end() is AFTER the array end
  while (it != my_dq.end())
  {
    cout << *it << " "; // *it gets the current value of the iterator. * is called a dereference operator
    ++it;
  }
  cout << endl;
}

// The Const Iterator Way
void print2(deque<int> &dq)
{
  deque<int>::const_iterator it = dq.begin();
  while (it != dq.end())
  {
    // *it = 10; // Const Iterator forbids changing the queue values while looping
    cout << *it << " ";
    it++;
  }
  cout << endl;
}

void print_reverse(deque<int> &dq)
{
  deque<int>::iterator it = dq.end();
  while (it != dq.begin())
  {
    // decreasing first as the initial value is dq.end() while we need it to be dq.end() - 1
    // and also the last value will be dq.begin() + 1 (based on our while loop condition above) so we want the dq.begin() in such case
    --it;
    cout << *it << " ";
  }
  cout << endl;
}

// Reverse Iterator: Think of it as the content of the queue is reversed
void print_reverse2(deque<int> &dq)
{
  deque<int>::reverse_iterator it = dq.rbegin();

  while (it != dq.rend()) // rend has passed the last element
  {
    cout << *it << " ";
    it++; // Not: it--;
  }
  cout << endl;
}

// loop over a string
int count_lowers(const string &str)
{
  int count = 0;
  for (auto it = str.begin(); it < str.end(); it++)
  {
    char c = *it;
    if (islower(c))
      count++;
  }
  return count;
}

int main()
{
  deque<int> dq{1, 2, 3, 4, 8};
  print(dq);
  print(dq);
  print2(dq);
  print_reverse(dq);
  print_reverse2(dq);

  // Arithmetic Operations on iterator
  cout << "=================\n";
  auto it = dq.begin();
  cout << *it << endl;       // 1
  cout << *(it++) << endl;   // 1
  cout << *it << endl;       // 2
  cout << *(++it) << endl;   // 3
  cout << *(it + 2) << endl; // 8
  cout << "=================\n";

  // Reset all to 10
  for (auto it = dq.begin(); it != dq.end(); it++)
    *it = 10;
  print(dq);

  cout << "=================\n";
  cout << count_lowers("Mahmoud") << endl;
  cout << count_lowers("") << endl;
  cout << count_lowers("DONE") << endl;
}
