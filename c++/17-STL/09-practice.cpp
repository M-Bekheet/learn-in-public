#include <iostream>
#include <stack>
using namespace std;

int getSum(vector<int> &v)
{
  int sum = 0;
  for (int &val : v)
    sum += val;
  return sum;
}

/*
  - Problem: You have 3 STACKS (only can pop_back) and we need the max sum of each one that is equal to the other 2 stacks
  - I solved it with many loops. This solution with getSum and conditions is cleaner
  */
int max_3stack_sum(vector<int> v1, vector<int> v2, vector<int> v3)
{
  int s1 = getSum(v1),
      s2 = getSum(v2),
      s3 = getSum(v3);

  while (!v1.empty() && !v2.empty() && !v3.empty())
  {
    if (s1 == s2 && s2 == s3)
      return s1;

    if (s1 > s2 && s1 > s3)
    {
      s1 -= v1.back();
      v1.pop_back();
    }
    else if (s2 > s3)
    {
      s2 -= v2.back();
      v2.pop_back();
    }
    else
    {
      s3 -= v3.back();
      v3.pop_back();
    }
  }

  return 0;
}

int main()
{
  vector<int> v1{1, 2, 3};
  vector<int> v2{0, 3, 3};
  vector<int> v3{1, 2, 2, 3};

  cout << max_3stack_sum(v1, v2, v3);
}