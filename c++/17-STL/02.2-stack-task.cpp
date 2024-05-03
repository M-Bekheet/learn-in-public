#include <iostream>
#include <queue>
using namespace std;

struct last_k_numbers_sum_steam
{
  int sum = 0;
  int k;
  queue<int> q;

  last_k_numbers_sum_steam(int _k)
  {
    k = _k;
  }

  int next(int new_num)
  {
    sum += new_num;
    q.push(new_num);

    if (q.size() > k)
    {
      sum -= q.front();
      q.pop();
    }
    return sum;
  }
};

// Problem: Return the sum of the last k numbers while you're not allowed to store more than k numbers together
int main()
{
  last_k_numbers_sum_steam processor(4);
  int num;

  while (cin >> num)
  {
    cout << processor.next(num) << " ";
  }
}
