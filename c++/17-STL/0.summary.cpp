#include <iostream>
#include <stack>
using namespace std;

/*

  Gotcha:
  - Vector, Queue, and Deque are fast. Unordered Set is fast too, but not like them.
  - Any erase/find operation is slow except for erase on average Unordered Set.
  - Set/Multiset/Map are slow. Don't use them, unless it's for a good reason.
  - In Practice, Vector is one of the most used DS. Initialize with a capacity if possible. push_back is slow though.
  - Set & Map are the most used after the Vector.
  - Set can do what a priority queue does, but not the opposite.


  ==> Quick Summary for STL
  Queue:
    - [FIFO] Add/Remove from the end only
  Deque:
   - Add/Remove from the front & the end
  Stack:
   - LIFO: Pop from the top
  Vector:
    - Flexible size DS.
    - Push to back & Pop from the back.
    - Erasion can be done by Iterators
  Map:
    - Key-value pairs (Not zero-based as regular arrays)
  Set:
    - Ordered & Unique.
  Multiset:
   - Ordered & NOT Unique
  Unordered Set:
  - Unordered & Unique
  Pair:
    - A pair of 2 values only that can be of any datatype.
    - Comparison between pairs is done from the left to right.
  Tuple:
   - An array of different types. Like a group of pairs
  Iterator:
  - An object looking at an index of the Data Structure that helps with looping over different DS.
  - Iterator begin() is at 0 & Iterator end() is after @size() of the DS (1-based unlike the index).
  - rbegin() and rend() iterate in the reverse order
*/

int main()
{
}