#include <iostream>
#include <queue>
#include <set>
using namespace std;

/*
  Given an array of numbers and there's a sliding window of size k
  Return the max of each sliding window grouped in an array
*/

// This solution is slower as for each i-loop, we're creating a new priority queue
vector<int> get_max_window(vector<int> numbers, int k)
{
  vector<int> result;
  for (int i = 0; i < (int)numbers.size() - k + 1; i++)
  {
    priority_queue<int> q;
    for (int j = 0; j < k; j++)
    {
      q.push(numbers[i + j]);
    }
    result.push_back(q.top()); // Made use of the priority_queue here as its top is always the maximum number
  }
  return result;
}

vector<int> get_max_window_v2(vector<int> numbers, int k)
{
  vector<int> result;
  multiset<int> st;

  if ((int)numbers.size() < k)
    return result;

  for (int i = 0; i < k; i++)
    st.insert(-numbers[i]); // Notice here that we're altering the sign of the number to enforce that the 1st element in the multiset is the LARGEST one not the Smallest

  result.push_back(-*st.begin()); // Resetting the number back here to its original before adding it to the result

  for (int i = k; i < (int)numbers.size(); i++) // starting from k now
  {
    st.erase(*st.find(-numbers[i - k]));
    st.insert(-numbers[i]);
    result.push_back(-*st.begin());
  }
  return result;
}

// https://github.com/kamyu104/LeetCode-Solutions/blob/master/C++/sliding-window-maximum.cpp
// Very elegant faster solution, but harder to understand
// Key idea is to make always front of deque is index of current maximum
// Any time u add number, remove any previous number can't be the answer
// let's say [1 7 3 2 5]
// We enter 1, so fine
// Enter 7. Now, 1 never be an answer. so remove it
// Enter 3: notice when 7 removed, maybe 3 is answer
// Enter 2: notice when 7 & 3 removed, maybe 2 is answer
// Enter 5: now 3 2 never be answer, so remove them ==> [7, 5]

int main()
{
  vector<int> numbers{1, 3, -1, -3, 5, 3, 6, 7};
  int k = 3;

  auto result = get_max_window_v2(numbers, k);
  for (int i = 0; i < result.size(); i++)
  {
    cout << result[i] << " ";
  }
  cout << "\n";
}