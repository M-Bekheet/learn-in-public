#include <iostream>
#include <queue>
#include <deque>
using namespace std;

/*
  Utilities: Start
*/

void print_queue(queue<int> q)
{
  while (!q.empty())
  {
    cout << q.front() << " ";
    q.pop(); // Unlike JavaScript, pop here removes from the beginning. In other words, it pops out the element that should be served FIRST [ Top element]
  }
  cout << "\n=================\n";
}

void print_priority_queue(priority_queue<int> pq)
{
  while (!pq.empty())
  {
    cout << pq.top() << " "; // NOTE: It's called top() here not front()
    pq.pop();
  }
  cout << "\n=================\n";
}

bool is_palindrome(string str)
{
  deque<char> dq;
  for (char c : str)
    dq.push_back(c);

  while (dq.size() > 1)
  {
    char c1 = dq.front();
    char c2 = dq.back();

    if (c1 != c2)
      return false;
    dq.pop_front();
    dq.pop_back();
  }
  return true;
}

/*
  Utilities: End
*/

int main()
{
  /*
   Queue: FIFO(First In First Out) Structure which means that the first elements to be added to the structure will be first.
   Queue: You can add to the end and only pop from the end
   Deque: Add to the front or back & remove from the front and back
  */
  queue<int> q;
  q.push(3); // push : adds to the end
  q.push(0);
  q.push(44);
  print_queue(q); // 3 0 44

  /*
    Priority Queue: sorts the items out from the largest to smallest
  */
  priority_queue<int>
      pq;
  pq.push(5); // 5
  pq.push(2); // 5 2
  pq.push(8); // 8 5 2
  print_priority_queue(pq);

  /*
    Dequeue: Allows adding and removing to/from the front & the back
    Utils:
     - front() & back() & size()
     - push_front() & push_back()
     - pop_front() & pop_back()
     - clear()
     - access elements:
      - dq[index] will not check the element existence if the index is not correct and it might crash the program
      - dq.at(index) out_of_range error is thrown if there's no element at that index
      - use [] if you're sure of the index, otherwise use at() while you're catching such errors and handling them
      - check: https://en.cppreference.com/w/cpp/container/deque/at    &     https://en.cppreference.com/w/cpp/container/deque/operator_at
   */

  deque<int> dq;
  dq.push_front(7); // 7
  dq.push_front(9); // 9 7
  dq.push_back(11); // 9 7 11

  deque<int> dq_copy = dq; // This is a deep copy and won't be affected by the dq changes

  cout << dq.front() << "\n"; // 9
  cout << dq.back() << "\n";  // 11

  dq.pop_back();             // dq = 9 7
  cout << dq.back() << "\n"; // 7

  dq.pop_front(); // dq = 7
  cout << dq.front() << "\n";
  cout << dq.size() << "\n"; // 1

  cout << "dq_copy is 9 7 1 and its size is still: " << dq_copy.size() << "\n";
  dq_copy.clear();
  cout << "dq_copy is cleared now and its size became: " << dq_copy.size() << "\n";
  // cout << dq_copy[5000] << "\n"; // Crash
  // cout << dq_copy.at(5000) << "\n"; // Error: std::out_of_range

  cout << "=================\n";
  cout << boolalpha; // *NOTE: This makes cout prints true/false instead of 0/1
  cout << is_palindrome("ABba") << "\n";
  cout << is_palindrome("ABA") << "\n";
  cout << is_palindrome("R") << "\n";
  cout << is_palindrome("abba") << "\n";
}
